package ru.rayanis.instroy.main_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.rayanis.instroy.data.Holder
import ru.rayanis.instroy.data.HolderRepository
import ru.rayanis.instroy.dialog.EditHolderDialogController
import ru.rayanis.instroy.dialog.EditHolderDialogEvent
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: HolderRepository
):  ViewModel(), EditHolderDialogController {

    override var openDialog = mutableStateOf(false)
        private set
    override var dialogTitle = mutableStateOf("Новый ответственный")
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

    fun onEvent(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.OnHolderSave -> {
                if (nameTextField.value.isEmpty()) return
                viewModelScope.launch {
                    repository.insertHolder(
                        Holder(
                            null,
                            nameTextField.value,
                            phoneNumberTextField.value,
                            emailTextField.value,
                            telegramNicknameTextField.value,
                            whatsappNumberTextField.value
                        )
                    )
                }
            }

            is MainScreenEvent.OnShowEditDialog -> {
                openDialog.value = true
            }
        }
    }

    override fun onEditHolderDialogEvent(event: EditHolderDialogEvent) {
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
                onEvent(MainScreenEvent.OnHolderSave)
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
}