package ru.rayanis.instroy.instruments_screen

import ru.rayanis.instroy.data.instrument.Instrument

sealed class InstrumentsScreenEvent {
    data class OnShowDeleteDialog(val item: Instrument): InstrumentsScreenEvent()
    data class OnShowEditDialog(val item: Instrument): InstrumentsScreenEvent()
    data class OnInstrumentClick(val route: String): InstrumentsScreenEvent()
    object OnInstrumentSave: InstrumentsScreenEvent()
}
