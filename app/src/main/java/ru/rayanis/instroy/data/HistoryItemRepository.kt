package ru.rayanis.instroy.data

import kotlinx.coroutines.flow.Flow

interface HistoryItemRepository {

    suspend fun insertItem(item: HistoryItem)

    fun getHistoryItemById(id: Int): HistoryItem

    fun getAllInstrumentHistoryItemsById(instrumentId: Int): Flow<List<HistoryItem>>

    fun getAllHolderHistoryItemsById(holderId: Int): Flow<List<HistoryItem>>
}