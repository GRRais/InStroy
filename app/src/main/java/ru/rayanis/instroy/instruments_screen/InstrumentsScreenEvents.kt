package ru.rayanis.instroy.instruments_screen

import ru.rayanis.instroy.data.Instrument

sealed class InstrumentsScreenEvents {
    data class onShowDeleteDialog(val item: Instrument): InstrumentsScreenEvents()
    data class onEditClick(val item: Instrument): InstrumentsScreenEvents()
    data class onInstrumentClick(val item: Instrument): InstrumentsScreenEvents()
    object OnInstrumentSave: InstrumentsScreenEvents()
}
