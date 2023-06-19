package ru.rayanis.instroy.dialog

import androidx.compose.runtime.MutableState

interface HistoryDialogController {
    val openDialog: MutableState<Boolean>
    val dialogTitle: MutableState<String>
    val quantityText: MutableState<Int>
    val freeAmountRadioButton: MutableState<Boolean>
    val maxAmountRadioButton: MutableState<Boolean>
    val brokenAmountRadioButton: MutableState<Boolean>
    val decommissionAmountRadioButton: MutableState<Boolean>
    val getAdditionalInfoText: MutableState<String>
    val returnAdditionalInfoText: MutableState<String>
    val showBrokenLine: MutableState<Boolean>
    val showInstrumentStateBlock: MutableState<Boolean>
    val showAdditionalInfoBlock: MutableState<Boolean>
}