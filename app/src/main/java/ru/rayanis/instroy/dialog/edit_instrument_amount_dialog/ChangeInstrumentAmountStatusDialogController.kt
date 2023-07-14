package ru.rayanis.instroy.dialog.edit_instrument_amount_dialog

import androidx.compose.runtime.MutableState

interface ChangeInstrumentAmountStatusDialogController {
    val openAmountDialog: MutableState<Boolean>
    val amountDialogTitle: MutableState<String>
    val quantityText: MutableState<String>
    val showRadioButtons: MutableState<Boolean>
    val showGetReturnInfoTexts: MutableState<Boolean>
    val freeAmountRadioButton: MutableState<Boolean>
    val maxAmountRadioButton: MutableState<Boolean>
    val brokenAmountRadioButton: MutableState<Boolean>
    val decommissionAmountRadioButton: MutableState<Boolean>
    fun onChangeInstrumentAmountStatusDialogEvent(event: ChangeInstrumentAmountStatusDialogEvent)
}