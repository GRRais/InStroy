package ru.rayanis.instroy.dialog

import androidx.compose.runtime.MutableState

interface DeleteDialogController {
    val openDialog: MutableState<Boolean>
    val dialogTitle: MutableState<String>
    fun onDeleteDialogEvent(event: DeleteDialogEvent)
}