package ru.rayanis.instroy.dialog.change_history_item_dialog

sealed class ChangeHistoryItemDialogEvent {
    data class OnQuantityChange(val quantity: Int) : ChangeHistoryItemDialogEvent()
    data class OnFreeAmountRadioButtonChange(val pressed: Boolean) :
        ChangeHistoryItemDialogEvent()

    data class OnBrokenAmountRadioButtonChange(val pressed: Boolean) :
        ChangeHistoryItemDialogEvent()

    data class OnDecommissionAmountRadioButtonChange(val pressed: Boolean) :
        ChangeHistoryItemDialogEvent()

    data class OnGetAdditionalInfoChange(val text: String) : ChangeHistoryItemDialogEvent()
    data class OnReturnAdditionalInfoChange(val text: String) : ChangeHistoryItemDialogEvent()
    object OnCancel : ChangeHistoryItemDialogEvent()
    object OnConfirm : ChangeHistoryItemDialogEvent()
}
