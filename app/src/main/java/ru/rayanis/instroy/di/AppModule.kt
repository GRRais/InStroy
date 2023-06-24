package ru.rayanis.instroy.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.rayanis.instroy.data.history_item.HistoryItemRepImpl
import ru.rayanis.instroy.data.history_item.HistoryItemRepository
import ru.rayanis.instroy.data.holder.HolderRepImpl
import ru.rayanis.instroy.data.holder.HolderRepository
import ru.rayanis.instroy.data.instrument.InstrumentRepImpl
import ru.rayanis.instroy.data.instrument.InstrumentRepository
import ru.rayanis.instroy.data.MainDb
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMainDb(app: Application): MainDb {
        return Room.databaseBuilder(
            app,
            MainDb::class.java,
            "instroy_db",
        ).build()
    }

    @Provides
    @Singleton
    fun provideHolderRepo(db: MainDb): HolderRepository {
        return HolderRepImpl(db.holderDao)
    }

    @Provides
    @Singleton
    fun provideInstrumentRepo(db: MainDb): InstrumentRepository {
        return InstrumentRepImpl(db.instrumentDao)
    }

    @Provides
    @Singleton
    fun provideHistoryItemRepo(db: MainDb): HistoryItemRepository {
        return HistoryItemRepImpl(db.historyItemDao)
    }
}