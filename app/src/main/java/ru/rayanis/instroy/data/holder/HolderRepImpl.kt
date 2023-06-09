package ru.rayanis.instroy.data.holder

import kotlinx.coroutines.flow.Flow

class HolderRepImpl(
    private val dao: HolderDao
): HolderRepository {
    override suspend fun insertHolder(item: Holder) {
        dao.insertHolder(item)
    }

    override suspend fun deleteHolder(item: Holder) {
        dao.deleteHolder(item)
    }

    override fun getAllHolders(): Flow<List<Holder>> {
        return dao.getAllHolders()
    }

    override suspend fun getHolderById(id: Int): Holder {
        return dao.getHolderById(id)
    }
}