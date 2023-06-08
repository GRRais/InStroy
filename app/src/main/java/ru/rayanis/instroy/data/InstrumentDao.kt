package ru.rayanis.instroy.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface InstrumentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Instrument)

    @Delete
    suspend fun deleteItem(item: Instrument)

    @Query("SELECT * FROM Instrument")
    fun getAllItems(): Flow<List<Instrument>>

    @Query("SELECT * FROM instrument WHERE id = :holderId")
    fun getInstrumentById(holderId: Int): Flow<List<HistoryItem>>
}