package ru.rayanis.instroy.data.instrument

import kotlinx.coroutines.flow.Flow

interface InstrumentRepository {

    suspend fun insertInstrument(item: Instrument)

    suspend fun updateInstrument(item: Instrument)

    suspend fun deleteInstrument(item: Instrument)

    fun getAllInstruments(): Flow<List<Instrument>>

    suspend fun getInstrumentById(id: Int): Instrument
}