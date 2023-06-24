package ru.rayanis.instroy.data.instrument

import kotlinx.coroutines.flow.Flow

class InstrumentRepImpl(
    private val dao: InstrumentDao
): InstrumentRepository {
    override suspend fun insertInstrument(item: Instrument) {
        dao.insertInstrument(item)
    }

    override suspend fun updateInstrument(item: Instrument) {
        dao.updateInstrument(item)
    }

    override suspend fun deleteInstrument(item: Instrument) {
        dao.deleteInstrument(item)
    }

    override fun getAllInstruments(): Flow<List<Instrument>> {
        return  dao.getAllInstruments()
    }

    override suspend fun getInstrumentById(id: Int): Instrument {
        return dao.getInstrumentById(id)
    }
}