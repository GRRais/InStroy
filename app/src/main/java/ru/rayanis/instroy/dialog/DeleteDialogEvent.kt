package ru.rayanis.instroy.dialog

sealed class DeleteDialogEvent{
    object OnCancel: DeleteDialogEvent()
    object OnConfirm: DeleteDialogEvent()
}
