package ru.rayanis.instroy.data

import kotlinx.coroutines.flow.Flow

interface HolderRepository {

    suspend fun insertItem(item: Holder)

    suspend fun deleteItem(item: Holder)

    fun getAllItems(): Flow<List<Holder>>

    fun getHolderById(id: Int): Holder
}