package ru.rayanis.instroy.dialog.delete_dialog

sealed class DeleteDialogEvent{
    object OnCancel: DeleteDialogEvent()
    object OnConfirm: DeleteDialogEvent()
}
