package ru.rayanis.instroy.dialog.edit_instrument_amount_dialog

import androidx.compose.runtime.MutableState

interface EditInstrumentAmountDialogController {
    val openDialog: MutableState<Boolean>
    val dialogTitle: MutableState<String>
    val quantityText: MutableState<Int>
    val freeAmountRadioButton: MutableState<Boolean>
    val maxAmountRadioButton: MutableState<Boolean>
    val brokenAmountRadioButton: MutableState<Boolean>
    val decommissionAmountRadioButton: MutableState<Boolean>
    fun onChangeItemDialogEvent(event: EditInstrumentAmountDialogEvent)
}