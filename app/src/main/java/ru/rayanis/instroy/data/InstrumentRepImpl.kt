package ru.rayanis.instroy.data

import kotlinx.coroutines.flow.Flow

class InstrumentRepImpl(
    private val dao: InstrumentDao
): InstrumentRepository {
    override suspend fun insertItem(item: Instrument) {
        dao.insertItem(item)
    }

    override suspend fun updateItem(item: Instrument) {
        dao.updateItem(item)
    }

    override suspend fun deleteItem(item: Instrument) {
        dao.deleteItem(item)
    }

    override fun getAllItems(): Flow<List<Instrument>> {
        return  dao.getAllItems()
    }

    override suspend fun getInstrumentById(id: Int): Instrument {
        return dao.getInstrumentById(id)
    }
}