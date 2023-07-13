package ru.rayanis.instroy.dialog.edit_instrument_amount_dialog

sealed class  EditInstrumentAmountDialogEvent {
    data class OnQuantityChange(val quantity: String) : EditInstrumentAmountDialogEvent()
    data class OnFreeAmountRadioButtonChange(val pressed: Boolean) :
        EditInstrumentAmountDialogEvent()

    data class OnBrokenAmountRadioButtonChange(val pressed: Boolean) :
        EditInstrumentAmountDialogEvent()

    data class OnDecommissionAmountRadioButtonChange(val pressed: Boolean) :
        EditInstrumentAmountDialogEvent()

    object OnCancel : EditInstrumentAmountDialogEvent()
    object OnSave : EditInstrumentAmountDialogEvent()
}
