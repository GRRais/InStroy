package ru.rayanis.instroy.dialog

import ru.rayanis.instroy.data.HistoryItem
import ru.rayanis.instroy.data.Instrument

sealed class EditInstrumentDialogEvent {
    data class OnNameChange(val text: String) : EditInstrumentDialogEvent()
    data class OnAdditionalInfoChange(val text: String) : EditInstrumentDialogEvent()
    data class OnFreeAmountPress(val instrument: Instrument) : EditInstrumentDialogEvent()
    data class OnRepairingAmountPress(val instrumentHistoryItem: HistoryItem) :
        EditInstrumentDialogEvent()

    data class OnMaxAmountPress(val instrument: Instrument) : EditInstrumentDialogEvent()
    data class OnDecommissionAmountPress(val instrumentHistoryItem: HistoryItem) :
        EditInstrumentDialogEvent()

    object OnSave : EditInstrumentDialogEvent()
}
