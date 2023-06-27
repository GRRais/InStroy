package ru.rayanis.instroy.dialog.edit_instrument_dialog

import ru.rayanis.instroy.data.history_item.HistoryItem
import ru.rayanis.instroy.data.instrument.Instrument

sealed class EditInstrumentDialogEvent {
    data class OnNameChange(val name: String) : EditInstrumentDialogEvent()
    data class OnAdditionalInfoChange(val text: String) : EditInstrumentDialogEvent()
    data class OnFreeAmountPress(val instrument: Instrument) : EditInstrumentDialogEvent()
    data class OnRepairingAmountPress(val instrumentHistoryItem: HistoryItem) :
        EditInstrumentDialogEvent()

    data class OnMaxAmountPress(val instrument: Instrument) : EditInstrumentDialogEvent()
    data class OnDecommissionAmountPress(val instrumentHistoryItem: HistoryItem) :
        EditInstrumentDialogEvent()

    object OnSave : EditInstrumentDialogEvent()
    object OnCancel : EditInstrumentDialogEvent()
}
