package ru.rayanis.instroy.instruments_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import ru.rayanis.instroy.data.holder.Holder
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

    private var InstrumentItem: Holder? = null

    override var openDeleteDialog = mutableStateOf(false)
        private set
    override var openDialog = mutableStateOf(false)
        private set
    override var dialogTitle = mutableStateOf("Данные ответственного")
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

    override fun onChangeItemDialogEvent(event: EditInstrumentAmountDialogEvent) {
        TODO("Not yet implemented")
    }

    override var nameText = mutableStateOf("")
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

    override fun onEditInstrumentDialogEvent(event: EditInstrumentDialogEvent) {
        TODO("Not yet implemented")
    }


    fun onEvent(event: InstrumentsScreenEvent) {
        when (event) {
            is InstrumentsScreenEvent.OnInstrumentSave -> {
                if (nameTextField.value.isEmpty()) return
                viewModelScope.launch {
                    repository.insertInstrument(
                        Holder(
                            InstrumentItem?.id,
                            nameTextField.value,
                            phoneNumberTextField.value,
                            emailTextField.value,
                            telegramNicknameTextField.value,
                            whatsappNumberTextField.value
                        )
                    )
                }
            }

            is InstrumentsScreenEvent.onInstrumentClick -> {
                sendUiEvent(UiEvent.Navigate(event.route))
            }

            is InstrumentsScreenEvent.onShowEditDialog -> {
                InstrumentItem = event.item
                openDialog.value = true
                dialogTitle.value = "Редактировать ${InstrumentItem?.name}"
                nameTextField.value = InstrumentItem?.name ?: ""
                phoneNumberTextField.value = InstrumentItem?.phoneNumber ?: ""
            }

            is InstrumentsScreenEvent.onShowDeleteDialog -> {
                InstrumentItem = event.item
                openDeleteDialog.value = true
                dialogTitle.value = "Удалить ${InstrumentItem?.name}?"
            }
        }
    }

    override fun onEditInstrumentDialogEvent(event: EditHolderDialogEvent) {
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
                openDialog.value = false
                nameTextField.value = ""
                phoneNumberTextField.value = ""
                emailTextField.value = ""
                telegramNicknameTextField.value = ""
                whatsappNumberTextField.value = ""
            }

            is EditHolderDialogEvent.OnCancel -> {
                openDialog.value = false
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
                    InstrumentItem?.let { repository.deleteHolder(it) }
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