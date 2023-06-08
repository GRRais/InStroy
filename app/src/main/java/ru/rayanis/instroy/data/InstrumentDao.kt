package ru.rayanis.instroy.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface InstrumentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Instrument)

    @Update
    suspend fun updateItem(item: Instrument)

    @Delete
    suspend fun deleteItem(item: Instrument)

    @Query("SELECT * FROM instrument_table")
    fun getAllItems(): Flow<List<Instrument>>

    @Query("SELECT * FROM instrument_table WHERE id = :id")
    fun getInstrumentById(id: Int): Instrument
}