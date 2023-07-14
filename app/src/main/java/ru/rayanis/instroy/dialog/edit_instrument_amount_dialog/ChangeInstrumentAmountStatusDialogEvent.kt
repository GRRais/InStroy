package ru.rayanis.instroy.dialog.edit_instrument_amount_dialog

sealed class  ChangeInstrumentAmountStatusDialogEvent {
    data class OnChangeInstrumentQuantity(val quantity: String) : ChangeInstrumentAmountStatusDialogEvent()
    data class OnChangeGetInfoText(val quantity: String) : ChangeInstrumentAmountStatusDialogEvent()
    data class OnChangeReturnInfoText(val quantity: String) : ChangeInstrumentAmountStatusDialogEvent()
    data class OnChangeFreeRadioButton(val pressed: Boolean) :
        ChangeInstrumentAmountStatusDialogEvent()

    data class OnChangeBrokenRadioButton(val pressed: Boolean) :
        ChangeInstrumentAmountStatusDialogEvent()

    data class OnChangeDecommissionRadioButton(val pressed: Boolean) :
        ChangeInstrumentAmountStatusDialogEvent()

    object OnCancel : ChangeInstrumentAmountStatusDialogEvent()
    object OnSave : ChangeInstrumentAmountStatusDialogEvent()
}
