package ru.rayanis.instroy.holders_screen

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import ru.rayanis.instroy.data.Holder
import ru.rayanis.instroy.data.HolderRepository
import ru.rayanis.instroy.dialog.DeleteDialogController
import ru.rayanis.instroy.dialog.DeleteDialogEvent
import ru.rayanis.instroy.dialog.EditHolderDialogController
import ru.rayanis.instroy.dialog.EditHolderDialogEvent
import ru.rayanis.instroy.utils.UiEvent
import javax.inject.Inject

@HiltViewModel
class HoldersViewModel @Inject constructor(
    private val context: Application,
    private val repository: HolderRepository
) : ViewModel(), EditHolderDialogController, DeleteDialogController {

    private val holdersList = repository.getAllHolders()

    private val _uiEvent = Channel<UiEvent> ()
    val uiEvent = _uiEvent.receiveAsFlow()

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
        when (event) {
            is HoldersScreenEvents.OnHolderSave -> {
                viewModelScope.launch {
                    repository.insertHolder(
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
                sendUiEvent(UiEvent.Navigate(event.route))
            }

            is HoldersScreenEvents.onEditClick -> {
                holderItem = event.item
                openDialog.value = true
                nameTextField.value = holderItem?.name ?: ""
                phoneNumberTextField.value = holderItem?.phoneNumber ?: ""
                emailTextField.value = holderItem?.email ?: ""
                telegramNicknameTextField.value = holderItem?.telegramNickname ?: ""
                whatsappNumberTextField.value = holderItem?.whatsappNumber ?: ""
                dialogTitle.value = "Добавить ответственного?"
            }

            is HoldersScreenEvents.onShowDeleteDialog -> {
                holderItem = event.item
                openDialog.value = true
                dialogTitle.value = "Удалить ${holderItem?.name}?"
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
                HoldersScreenEvents.OnHolderSave
            }
            is EditHolderDialogEvent.OnCancel -> {
                openDialog.value = false
            }
        }
    }

    override fun onDeleteDialogEvent(event: DeleteDialogEvent) {
        when (event) {
            is DeleteDialogEvent.OnConfirm -> {
                viewModelScope.launch {
                    holderItem?.let { repository.deleteHolder(it) }
                }
                openDialog.value = false
            }

            is DeleteDialogEvent.OnCancel -> {
                openDialog.value = false
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}