package ru.rayanis.instroy.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HolderDao {

    //Добавление/обновление нового ответственного
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Holder)

    //Удаление ответственного
    @Delete
    suspend fun deleteItem(item: Holder)

    //Получение всех ответственных
    @Query("SELECT * FROM holder_table")
    fun getAllItems(): Flow<List<Holder>>

    //Получение ответственного по id
    @Query("SELECT * FROM holder_table WHERE id = :id")
    fun getHolderById(id: Int): Holder
}