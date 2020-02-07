package com.github.odaridavid.tuli.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.odaridavid.tuli.tasks.Task

/**
 * Created By David Odari
 * On 07/02/20
 *
 **/
@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TuliDatabase : RoomDatabase() {
    abstract fun tasksDao(): TasksDao
}