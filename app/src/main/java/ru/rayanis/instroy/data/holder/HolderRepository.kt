package ru.rayanis.instroy.data.holder

import kotlinx.coroutines.flow.Flow

interface HolderRepository {

    suspend fun insertHolder(item: Holder)

    suspend fun deleteHolder(item: Holder)

    fun getAllHolders(): Flow<List<Holder>>

    suspend fun getHolderById(id: Int): Holder
}