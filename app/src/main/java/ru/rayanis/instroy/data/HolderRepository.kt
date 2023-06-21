package ru.rayanis.instroy.data

import kotlinx.coroutines.flow.Flow

interface HolderRepository {

    suspend fun insertHolder(item: Holder)

    suspend fun deleteHolder(item: Holder)

    fun getAllHolders(): Flow<List<Holder>>

    fun getHolderById(id: Int): Holder
}