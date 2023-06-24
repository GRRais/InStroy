package ru.rayanis.instroy.history_screen

import ru.rayanis.instroy.data.history_item.HistoryItem

sealed class HistoryScreenEvents {
    object onChangeSearchField: HistoryScreenEvents()
    data class onShowFilterDialog(val item: HistoryItem): HistoryScreenEvents()
    data class onHistoryItemClick(val item: HistoryItem): HistoryScreenEvents()
}
