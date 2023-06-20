package ru.rayanis.instroy.dialog

sealed class EditHolderDialogEvent{
    data class OnNameChange(val text: String) : EditHolderDialogEvent()
    data class OnPhoneNumberChange(val text: String) : EditHolderDialogEvent()
    data class OnEmailChange(val text: String) : EditHolderDialogEvent()
    data class OnTelegramNicknameChange(val text: String) : EditHolderDialogEvent()
    data class OnWhatsappNumberChange(val text: String) : EditHolderDialogEvent()
    object OnSave : EditHolderDialogEvent()
}
