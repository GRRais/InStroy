package ru.rayanis.instroy.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface InstrumentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Holder)

    @Insert
    suspend fun deleteItem(item: Holder)

    @Query("SELECT * FROM holder")
    fun getAllItems(): Flow<List<Holder>>
}