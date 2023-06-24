package ru.rayanis.instroy.data.history_item

import kotlinx.coroutines.flow.Flow

interface HistoryItemRepository {

    suspend fun insertItem(item: HistoryItem)

    suspend fun getHistoryItemById(id: Int): HistoryItem

    fun getAllInstrumentHistoryItemsById(instrumentId: Int): Flow<List<HistoryItem>>

    fun getAllHolderHistoryItemsById(holderId: Int): Flow<List<HistoryItem>>
}