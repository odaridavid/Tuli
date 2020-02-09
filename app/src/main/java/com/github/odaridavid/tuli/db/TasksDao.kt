package com.github.odaridavid.tuli.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.github.odaridavid.tuli.tasks.Task

/**
 * Created By David Odari
 * On 07/02/20
 *
 **/
@Dao
interface TasksDao {

    @Query("SELECT * FROM task_table")
    fun loadAllTasks(): LiveData<List<Task>>

    @Query("SELECT * FROM task_table WHERE complete=:status")
    fun queryByCompletionStatus(status: Boolean): LiveData<List<Task>>

    @Insert
    fun insertTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Update
    fun updateTask(task: Task)
}