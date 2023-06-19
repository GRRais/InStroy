package ru.rayanis.instroy.dialog

import androidx.compose.runtime.MutableState

interface EditInstrumentDialogController {
    val openDialog: MutableState<Boolean>
    val dialogTitle: MutableState<String>
    val nameText: MutableState<String>
    val additionalInfoText: MutableState<String>
    val freeAmountText: MutableState<Int>
    val brokenAmountText: MutableState<Int>
    val maxAmountText: MutableState<Int>
    val decommissionAmountText: MutableState<Int>
    val showEditFreeAmountButton: MutableState<Boolean>
    val showAddInstrumentButton: MutableState<Boolean>
}