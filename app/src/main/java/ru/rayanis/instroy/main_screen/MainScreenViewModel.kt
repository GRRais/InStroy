package ru.rayanis.instroy.main_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.rayanis.instroy.data.holder.Holder
import ru.rayanis.instroy.data.holder.HolderRepository
import ru.rayanis.instroy.dialog.edit_holder_dialog.EditHolderDialogController
import ru.rayanis.instroy.dialog.edit_holder_dialog.EditHolderDialogEvent
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: HolderRepository
):  ViewModel(), EditHolderDialogController {

    override var openDialog = mutableStateOf(false)
        private set
    override var dialogTitle = mutableStateOf("Новый ответственный")
        private set
    override var nameText = mutableStateOf("")
        private set
    override var phoneNumberText = mutableStateOf("")
        private set
    override var emailText = mutableStateOf("")
        private set
    override var telegramNicknameText = mutableStateOf("")
        private set
    override var whatsappNumberText = mutableStateOf("")
        private set

    fun onEvent(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.OnHolderSave -> {
                if (nameText.value.isEmpty()) return
                viewModelScope.launch {
                    repository.insertHolder(
                        Holder(
                            null,
                            nameText.value,
                            phoneNumberText.value,
                            emailText.value,
                            telegramNicknameText.value,
                            whatsappNumberText.value
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
                nameText.value = event.name
            }

            is EditHolderDialogEvent.OnPhoneNumberChange -> {
                phoneNumberText.value = event.phoneNumber
            }

            is EditHolderDialogEvent.OnEmailChange -> {
                emailText.value = event.email
            }

            is EditHolderDialogEvent.OnTelegramNicknameChange -> {
                telegramNicknameText.value = event.telegramNickname
            }

            is EditHolderDialogEvent.OnWhatsappNumberChange -> {
                whatsappNumberText.value = event.whatsappNumber
            }

            is EditHolderDialogEvent.OnSave -> {
                onEvent(MainScreenEvent.OnHolderSave)
                openDialog.value = false
                nameText.value = ""
                phoneNumberText.value = ""
                emailText.value = ""
                telegramNicknameText.value = ""
                whatsappNumberText.value = ""
            }
            is EditHolderDialogEvent.OnCancel -> {
                openDialog.value = false
                nameText.value = ""
                phoneNumberText.value = ""
                emailText.value = ""
                telegramNicknameText.value = ""
                whatsappNumberText.value = ""
            }
        }
    }
}