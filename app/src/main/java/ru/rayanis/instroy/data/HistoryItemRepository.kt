package ru.rayanis.instroy.data

import kotlinx.coroutines.flow.Flow

interface HistoryItemRepository {

    suspend fun insertItem(item: HistoryItem)

    fun getAllHolderItemsById(holderId: Int): Flow<List<HistoryItem>>

    fun getAllInstrumentHistoryItemsById(instrumentId: Int): Flow<List<HistoryItem>>

    fun getAllHolderHistoryItemsById(holderId: Int): Flow<List<HistoryItem>>
}