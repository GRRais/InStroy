package ru.rayanis.instroy.dialog.delete_dialog

import androidx.compose.runtime.MutableState

interface DeleteDialogController {
    val openDeleteDialog: MutableState<Boolean>
    val dialogTitle: MutableState<String>
    fun onDeleteDialogEvent(event: DeleteDialogEvent)
}