package ru.rayanis.instroy.holders_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import ru.rayanis.instroy.data.holder.Holder
import ru.rayanis.instroy.data.holder.HolderRepository
import ru.rayanis.instroy.dialog.delete_dialog.DeleteDialogController
import ru.rayanis.instroy.dialog.delete_dialog.DeleteDialogEvent
import ru.rayanis.instroy.dialog.edit_holder_dialog.EditHolderDialogController
import ru.rayanis.instroy.dialog.edit_holder_dialog.EditHolderDialogEvent
import ru.rayanis.instroy.utils.UiEvent
import javax.inject.Inject

@HiltViewModel
class HoldersViewModel @Inject constructor(
    private val repository: HolderRepository
) : ViewModel(), EditHolderDialogController, DeleteDialogController {

    val holdersList = repository.getAllHolders()

    private val _uiEvent = Channel<UiEvent> ()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var holderItem: Holder? = null

    override var openDeleteDialog = mutableStateOf(false)
        private set
    override var openDialog = mutableStateOf(false)
        private set
    override var dialogTitle = mutableStateOf("Данные ответственного")
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

    fun onEvent(event: HoldersScreenEvent) {
        when (event) {
            is HoldersScreenEvent.OnHolderSave -> {
                if (nameText.value.isEmpty()) return
                viewModelScope.launch {
                    repository.insertHolder(
                        Holder(
                            holderItem?.id,
                            nameText.value,
                            phoneNumberText.value,
                            emailText.value,
                            telegramNicknameText.value,
                            whatsappNumberText.value
                        )
                    )
                }
            }

            is HoldersScreenEvent.OnHolderClick -> {
                sendUiEvent(UiEvent.Navigate(event.route))
            }

            is HoldersScreenEvent.OnShowEditDialog -> {
                holderItem = event.item
                openDialog.value = true
                dialogTitle.value = "Редактировать ${holderItem?.name}"
                nameText.value = holderItem?.name ?: ""
                phoneNumberText.value = holderItem?.phoneNumber ?: ""
                emailText.value = holderItem?.email ?: ""
                telegramNicknameText.value = holderItem?.telegramNickname ?: ""
                whatsappNumberText.value = holderItem?.whatsappNumber ?: ""
            }

            is HoldersScreenEvent.OnShowDeleteDialog -> {
                holderItem = event.item
                openDeleteDialog.value = true
                dialogTitle.value = "Удалить ${holderItem?.name}?"
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
                onEvent(HoldersScreenEvent.OnHolderSave)
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

    override fun onDeleteDialogEvent(event: DeleteDialogEvent) {
        when (event) {
            is DeleteDialogEvent.OnConfirm -> {
                viewModelScope.launch {
                    holderItem?.let { repository.deleteHolder(it) }
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