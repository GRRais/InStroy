package ru.rayanis.instroy.dialog

sealed class InstrumentStateChangeEvent {
    data class OnQuantityChange(val quantity: Int) : InstrumentStateChangeEvent()
    data class OnFreeAmountRadioButtonChange(val pressed: Boolean) :
        InstrumentStateChangeEvent()

    data class OnBrokenAmountRadioButtonChange(val pressed: Boolean) :
        InstrumentStateChangeEvent()

    data class OnDecommissionAmountRadioButtonChange(val pressed: Boolean) :
        InstrumentStateChangeEvent()

    data class OnGetAdditionalInfoChange(val text: String) : InstrumentStateChangeEvent()
    data class OnReturnAdditionalInfoChange(val text: String) : InstrumentStateChangeEvent()
    object OnCancel : InstrumentStateChangeEvent()
    object OnConfirm : InstrumentStateChangeEvent()
}
