package ru.rayanis.instroy.dialog.edit_holder_dialog

sealed class EditHolderDialogEvent{
    data class OnNameChange(val name: String) : EditHolderDialogEvent()
    data class OnPhoneNumberChange(val phoneNumber: String) : EditHolderDialogEvent()
    data class OnEmailChange(val email: String) : EditHolderDialogEvent()
    data class OnTelegramNicknameChange(val telegramNickname: String) : EditHolderDialogEvent()
    data class OnWhatsappNumberChange(val whatsappNumber: String) : EditHolderDialogEvent()
    object OnSave : EditHolderDialogEvent()
    object OnCancel: EditHolderDialogEvent()
}
