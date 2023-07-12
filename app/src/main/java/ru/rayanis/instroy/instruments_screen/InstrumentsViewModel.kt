package ru.rayanis.instroy.instruments_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import ru.rayanis.instroy.data.instrument.Instrument
import ru.rayanis.instroy.data.instrument.InstrumentRepository
import ru.rayanis.instroy.dialog.delete_dialog.DeleteDialogController
import ru.rayanis.instroy.dialog.delete_dialog.DeleteDialogEvent
import ru.rayanis.instroy.dialog.edit_holder_dialog.EditHolderDialogEvent
import ru.rayanis.instroy.dialog.edit_instrument_amount_dialog.EditInstrumentAmountDialogController
import ru.rayanis.instroy.dialog.edit_instrument_amount_dialog.EditInstrumentAmountDialogEvent
import ru.rayanis.instroy.dialog.edit_instrument_dialog.EditInstrumentDialogController
import ru.rayanis.instroy.dialog.edit_instrument_dialog.EditInstrumentDialogEvent
import ru.rayanis.instroy.utils.UiEvent
import javax.inject.Inject

@HiltViewModel
class InstrumentsViewModel @Inject constructor(
    private val repository: InstrumentRepository
) : ViewModel(), EditInstrumentDialogController, EditInstrumentAmountDialogController,
    DeleteDialogController {

    val instrumentsList = repository.getAllInstruments()

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var instrumentItem: Instrument? = null

    override var openDeleteDialog = mutableStateOf(false)
        private set
    override var openDialog = mutableStateOf(false)
        private set
    override var dialogTitle = mutableStateOf("")
        private set
    override var openAmountDialog = mutableStateOf(false)
        private set
    override var amountDialogTitle = mutableStateOf("")
        private set
    override var quantityText = mutableStateOf(0)
        private set
    override var freeAmountRadioButton = mutableStateOf(false)
        private set
    override var maxAmountRadioButton = mutableStateOf(false)
        private set
    override var brokenAmountRadioButton = mutableStateOf(false)
        private set
    override var decommissionAmountRadioButton = mutableStateOf(false)
        private set

    override fun onChangeAmountDialogEvent(event: EditInstrumentAmountDialogEvent) {

    }

    override var instrumentNameText = mutableStateOf("")
        private set
    override var additionalInfoText = mutableStateOf("")
        private set
    override var freeAmountText = mutableStateOf(0)
        private set
    override var brokenAmountText = mutableStateOf(0)
        private set
    override var maxAmountText = mutableStateOf(0)
        private set
    override var decommissionAmountText = mutableStateOf(0)
        private set
    override var showEditFreeAmountButton = mutableStateOf(false)
        private set
    override var showInstrumentHistoryButton = mutableStateOf(false)
        private set

    fun onEvent(event: InstrumentsScreenEvent) {
        when (event) {
            is InstrumentsScreenEvent.OnInstrumentSave -> {
                if (instrumentNameText.value.isEmpty()) return
                viewModelScope.launch {
                    repository.insertInstrument(
                        Instrument(
                            instrumentItem?.id,
                            instrumentNameText.value,
                            additionalInfoText.value,
                            freeAmountText.value,
                            brokenAmountText.value,
                            maxAmountText.value,
                            decommissionAmountText.value
                        )
                    )
                }
            }

            is InstrumentsScreenEvent.onInstrumentClick -> {
                sendUiEvent(UiEvent.Navigate(event.route))
            }

            is InstrumentsScreenEvent.onShowEditDialog -> {
                instrumentItem = event.item
                openAmountDialog.value = true
                amountDialogTitle.value = "Редактировать ${instrumentItem?.name}"
                instrumentNameText.value = instrumentItem?.name ?: ""
                additionalInfoText.value = instrumentItem?.additionalInfo ?: ""
                freeAmountText.value = instrumentItem?.freeAmount ?: 0
                brokenAmountText.value = instrumentItem?.brokenAmount ?: 0

            }

            is InstrumentsScreenEvent.onShowDeleteDialog -> {
                instrumentItem = event.item
                openDeleteDialog.value = true
                amountDialogTitle.value = "Удалить ${instrumentItem?.name}?"
            }
        }
    }

    override fun onEditInstrumentDialogEvent(event: EditInstrumentDialogEvent) {
        when (event) {
            is EditHolderDialogEvent.OnNameChange -> {
                nameTextField.value = event.name
            }

            is EditHolderDialogEvent.OnPhoneNumberChange -> {
                phoneNumberTextField.value = event.phoneNumber
            }

            is EditHolderDialogEvent.OnEmailChange -> {
                emailTextField.value = event.email
            }

            is EditHolderDialogEvent.OnTelegramNicknameChange -> {
                telegramNicknameTextField.value = event.telegramNickname
            }

            is EditHolderDialogEvent.OnWhatsappNumberChange -> {
                whatsappNumberTextField.value = event.whatsappNumber
            }

            is EditHolderDialogEvent.OnSave -> {
                onEvent(InstrumentsScreenEvent.OnInstrumentSave)
                openAmountDialog.value = false
                nameTextField.value = ""
                phoneNumberTextField.value = ""
                emailTextField.value = ""
                telegramNicknameTextField.value = ""
                whatsappNumberTextField.value = ""
            }

            is EditHolderDialogEvent.OnCancel -> {
                openAmountDialog.value = false
                nameTextField.value = ""
                phoneNumberTextField.value = ""
                emailTextField.value = ""
                telegramNicknameTextField.value = ""
                whatsappNumberTextField.value = ""
            }
        }
    }

    override fun onDeleteDialogEvent(event: DeleteDialogEvent) {
        when (event) {
            is DeleteDialogEvent.OnConfirm -> {
                viewModelScope.launch {
                    instrumentItem?.let { repository.deleteInstrument(it) }
                }
                openDeleteDialog.value = false
            }

            is DeleteDialogEvent.OnCancel -> {
                openDeleteDialog.value = false
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}