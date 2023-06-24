package ru.rayanis.instroy.data.history_item

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryItemDao {

    //Добавление/обновление новой записи в историю
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: HistoryItem)

    //Получение записи в истории по id
    @Query("SELECT * FROM history_item_table WHERE id = :id")
    fun getHistoryItemById(id: Int): HistoryItem

    //Получение всех записей истории по инструменту
    @Query("SELECT * FROM history_item_table WHERE instrumentId = :instrumentId")
    fun getAllInstrumentHistoryItemsById(instrumentId: Int): Flow<List<HistoryItem>>

    //Получение всех записей истории по ответственному
    @Query("SELECT * FROM history_item_table WHERE holderId = :holderId")
    fun getAllHolderHistoryItemsById(holderId: Int): Flow<List<HistoryItem>>
}