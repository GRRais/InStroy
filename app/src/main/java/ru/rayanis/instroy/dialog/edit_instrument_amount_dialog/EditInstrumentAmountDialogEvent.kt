package ru.rayanis.instroy.dialog.edit_instrument_amount_dialog

import ru.rayanis.instroy.dialog.change_history_item_dialog.ChangeHistoryItemDialogEvent

sealed class  EditInstrumentAmountDialogEvent {
    data class OnQuantityChange(val quantity: Int) : EditInstrumentAmountDialogEvent()
    data class OnFreeAmountRadioButtonChange(val pressed: Boolean) :
        EditInstrumentAmountDialogEvent()

    data class OnBrokenAmountRadioButtonChange(val pressed: Boolean) :
        EditInstrumentAmountDialogEvent()

    data class OnDecommissionAmountRadioButtonChange(val pressed: Boolean) :
        EditInstrumentAmountDialogEvent()

    object OnCancel : EditInstrumentAmountDialogEvent()
    object OnConfirm : EditInstrumentAmountDialogEvent()
}
