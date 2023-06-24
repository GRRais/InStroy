package ru.rayanis.instroy.data.history_item

import kotlinx.coroutines.flow.Flow

class HistoryItemRepImpl(
    private val dao: HistoryItemDao
): HistoryItemRepository {
    override suspend fun insertItem(item: HistoryItem) {
        dao.insertItem(item)
    }

    override suspend fun getHistoryItemById(id: Int): HistoryItem {
        return dao.getHistoryItemById(id)
    }

    override fun getAllInstrumentHistoryItemsById(instrumentId: Int): Flow<List<HistoryItem>> {
        return dao.getAllInstrumentHistoryItemsById(instrumentId)
    }

    override fun getAllHolderHistoryItemsById(holderId: Int): Flow<List<HistoryItem>> {
        return dao.getAllHolderHistoryItemsById(holderId)
    }
}