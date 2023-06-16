package ru.rayanis.instroy.add_instruments_screen

import ru.rayanis.instroy.data.HistoryItem

sealed class AddInstrumentsScreenEvents {
    data class onChangeQuantityField(val item: HistoryItem): AddInstrumentsScreenEvents()
    data class onIncreaseButtonClick(val item: HistoryItem): AddInstrumentsScreenEvents()
    data class onDecreaseButtonClick(val item: HistoryItem): AddInstrumentsScreenEvents()
    data class onItemClick(val item: HistoryItem): AddInstrumentsScreenEvents()
    object OnAddButtonClick: AddInstrumentsScreenEvents()
}
