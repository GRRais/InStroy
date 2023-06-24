package ru.rayanis.instroy.data.instrument

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
    suspend fun insertInstrument(item: Instrument)

    //Обновление инструмента
    @Update
    suspend fun updateInstrument(item: Instrument)

    //Удаление инструмента
    @Delete
    suspend fun deleteInstrument(item: Instrument)

    //Получение всех инструментов
    @Query("SELECT * FROM instrument_table")
    fun getAllInstruments(): Flow<List<Instrument>>

    //Получение инструмента по id
    @Query("SELECT * FROM instrument_table WHERE id = :id")
    fun getInstrumentById(id: Int): Instrument
}