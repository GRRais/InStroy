package ru.rayanis.instroy.dialog.change_history_item_dialog

import androidx.compose.runtime.MutableState

interface ChangeHistoryItemDialogController {
    val openDialog: MutableState<Boolean>
    val dialogTitle: MutableState<String>
    val quantityText: MutableState<Int>
    val freeAmountRadioButton: MutableState<Boolean>
    val maxAmountRadioButton: MutableState<Boolean>
    val brokenAmountRadioButton: MutableState<Boolean>
    val decommissionAmountRadioButton: MutableState<Boolean>
    val getAdditionalInfoText: MutableState<String>
    val returnAdditionalInfoText: MutableState<String>
    fun onChangeHistoryItemDialogEvent(event: ChangeHistoryItemDialogEvent)
}