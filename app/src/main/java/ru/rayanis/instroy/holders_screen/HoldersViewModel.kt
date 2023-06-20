package ru.rayanis.instroy.holders_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.rayanis.instroy.data.Holder
import ru.rayanis.instroy.data.HolderRepository
import ru.rayanis.instroy.dialog.EditHolderDialogController
import ru.rayanis.instroy.dialog.EditHolderDialogEvent
import ru.rayanis.instroy.dialog.InstrumentStateChangeEvent
import javax.inject.Inject

@HiltViewModel
class HoldersViewModel @Inject constructor(
    private val repository: HolderRepository
): ViewModel(), EditHolderDialogController {

    private var holderItem: Holder? = null

    override var openDialog = mutableStateOf(false)
        private set
    override var dialogTitle = mutableStateOf("")
        private set
    override var nameTextField = mutableStateOf("")
        private set
    override var phoneNumberTextField = mutableStateOf("")
        private set
    override var emailTextField = mutableStateOf("")
        private set
    override var telegramNicknameTextField = mutableStateOf("")
        private set
    override var whatsappNumberTextField = mutableStateOf("")
        private set

    fun onEvent(event: HoldersScreenEvents) {
        when(event) {
            is HoldersScreenEvents.OnHolderSave -> {
                viewModelScope.launch {
                    repository.insertItem(
                        Holder(
                            holderItem?.id,
                            nameTextField.value,
                            phoneNumberTextField.value,
                            emailTextField.value,
                            telegramNicknameTextField.value,
                            whatsappNumberTextField.value
                        )
                    )
                }
            }
            is HoldersScreenEvents.onHolderClick -> {

            }
            is HoldersScreenEvents.onEditClick -> {
                holderItem = event.item
            }
            is HoldersScreenEvents.onShowDeleteDialog -> {

            }
        }
    }

    fun onEditHolderDialogEvent(event: EditHolderDialogEvent) {
        when(event) {
            is EditHolderDialogEvent.OnNameChange -> {

            }
            is EditHolderDialogEvent.OnPhoneNumberChange -> {

            }
            is EditHolderDialogEvent.OnEmailChange -> {

            }
            is EditHolderDialogEvent.OnTelegramNicknameChange -> {

            }
            is EditHolderDialogEvent.OnWhatsappNumberChange -> {

            }
            is EditHolderDialogEvent.OnSave -> {

            }
        }
    }
}