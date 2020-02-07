package com.github.odaridavid.tuli.di.modules

import android.content.Context
import androidx.room.Room
import com.github.odaridavid.tuli.db.TasksDao
import com.github.odaridavid.tuli.db.TuliDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created By David Odari
 * On 07/02/20
 *
 * Provides database related entities
 **/
@Module
internal class DatabaseModule {

    @Singleton
    @Provides
    internal fun providesDatabase(context: Context, @Named("db_name") dbName: String): TuliDatabase {
        return Room.databaseBuilder(context, TuliDatabase::class.java, dbName)
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    @Named("db_name")
    internal fun providesDbName(): String = "tuli_db"

    @Singleton
    @Provides
    internal fun providesTasksDao(db: TuliDatabase): TasksDao = db.tasksDao()

}