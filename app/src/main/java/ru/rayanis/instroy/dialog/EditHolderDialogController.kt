package ru.rayanis.instroy.dialog

import androidx.compose.runtime.MutableState

interface EditHolderDialogController {
    val openDialog: MutableState<Boolean>
    val dialogTitle: MutableState<String>
    val nameTextField: MutableState<String>
    val phoneNumberTextField: MutableState<String>
    val emailTextField: MutableState<String>
    val telegramNicknameTextField: MutableState<String>
    val whatsappNumberTextField: MutableState<String>
}