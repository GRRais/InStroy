package ru.rayanis.instroy.dialog.edit_holder_dialog

import androidx.compose.runtime.MutableState

interface EditHolderDialogController {
    val openDialog: MutableState<Boolean>
    val dialogTitle: MutableState<String>
    val nameText: MutableState<String>
    val phoneNumberText: MutableState<String>
    val emailText: MutableState<String>
    val telegramNicknameText: MutableState<String>
    val whatsappNumberText: MutableState<String>
    fun onEditHolderDialogEvent(event: EditHolderDialogEvent)
}