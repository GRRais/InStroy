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

    //Добавление нового инструмента
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Instrument)

    //Обновление инструмента
    @Update
    suspend fun updateItem(item: Instrument)

    //Удаление инструмента
    @Delete
    suspend fun deleteItem(item: Instrument)

    //Получение всех инструментов
    @Query("SELECT * FROM instrument_table")
    fun getAllItems(): Flow<List<Instrument>>

    //Получение инструмента по id
    @Query("SELECT * FROM instrument_table WHERE id = :id")
    fun getInstrumentById(id: Int): Instrument
}