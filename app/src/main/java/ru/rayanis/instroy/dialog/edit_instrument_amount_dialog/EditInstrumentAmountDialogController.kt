package ru.rayanis.instroy.dialog.edit_instrument_amount_dialog

import androidx.compose.runtime.MutableState

interface EditInstrumentAmountDialogController {
    val openAmountDialog: MutableState<Boolean>
    val amountDialogTitle: MutableState<String>
    val quantityText: MutableState<Int>
    val freeAmountRadioButton: MutableState<Boolean>
    val maxAmountRadioButton: MutableState<Boolean>
    val brokenAmountRadioButton: MutableState<Boolean>
    val decommissionAmountRadioButton: MutableState<Boolean>
    fun onChangeAmountDialogEvent(event: EditInstrumentAmountDialogEvent)
}