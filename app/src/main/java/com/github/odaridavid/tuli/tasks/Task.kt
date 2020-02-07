package com.github.odaridavid.tuli.tasks

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created By David Odari
 * On 07/02/20
 *
 **/
@Entity(tableName = "task_table")
data class Task(
    @NonNull
    @ColumnInfo(name = "start")
    val startTime: String,
    @NonNull
    @ColumnInfo(name = "stop")
    val endTime: String,
    @NonNull
    val date: String,
    @NonNull
    val title: String,
    @NonNull
    val complete: Boolean = false,
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Long = 0L
)