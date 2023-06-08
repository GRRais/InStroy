package ru.rayanis.instroy.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: HistoryItem)

    @Query("SELECT * FROM history_item WHERE holderId = :holderId")
    fun getAllHolderItemsById(holderId: Int): Flow<List<HistoryItem>>

    @Query("SELECT * FROM history_item WHERE instrumentId = :instrumentId")
    fun getAllInstrumentHistoryItemsById(instrumentId: Int): Flow<List<HistoryItem>>

    @Query("SELECT * FROM history_item WHERE holderId = :holderId")
    fun getAllHolderHistoryItemsById(holderId: Int): Flow<List<HistoryItem>>
}