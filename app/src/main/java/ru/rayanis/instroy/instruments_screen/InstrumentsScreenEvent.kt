package ru.rayanis.instroy.instruments_screen

import ru.rayanis.instroy.data.instrument.Instrument

sealed class InstrumentsScreenEvent {
    data class onShowDeleteDialog(val item: Instrument): InstrumentsScreenEvent()
    data class onShowEditDialog(val item: Instrument): InstrumentsScreenEvent()
    data class onInstrumentClick(val route: String): InstrumentsScreenEvent()
    object OnInstrumentSave: InstrumentsScreenEvent()
}
