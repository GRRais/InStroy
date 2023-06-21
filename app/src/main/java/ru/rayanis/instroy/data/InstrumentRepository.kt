package ru.rayanis.instroy.data

import kotlinx.coroutines.flow.Flow

interface InstrumentRepository {

    suspend fun insertItem(item: Instrument)

    suspend fun updateItem(item: Instrument)

    suspend fun deleteItem(item: Instrument)

    fun getAllItems(): Flow<List<Instrument>>

    suspend fun getInstrumentById(id: Int): Instrument
}