package ru.rayanis.instroy.utils

import androidx.compose.runtime.MutableState

interface DialogController {
    val dialogTitle: MutableState<String>
    val quantityTextField: MutableState<Int>
    val openDialog: MutableState<Boolean>
    val showEditableText: MutableState<Boolean>
}