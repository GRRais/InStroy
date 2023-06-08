package ru.rayanis.instroy.data

import kotlinx.coroutines.flow.Flow

class HolderRepImpl(
    private val dao: HolderDao
): HolderRepository {
    override suspend fun insertItem(item: Holder) {
        dao.insertItem(item)
    }

    override suspend fun deleteItem(item: Holder) {
        dao.deleteItem(item)
    }

    override fun getAllItems(): Flow<List<Holder>> {
        return dao.getAllItems()
    }

    override fun getHolderById(id: Int): Holder {
        return dao.getHolderById(id)
    }
}