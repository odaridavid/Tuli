package com.github.odaridavid.tuli.tasks

import androidx.lifecycle.LiveData
import com.github.odaridavid.tuli.db.TasksDao
import javax.inject.Inject

/**
 * Created By David Odari
 * On 07/02/20
 *
 **/
class TasksRepository @Inject constructor(private val tasksDao: TasksDao) : ITasksRepository {

    override fun getByCompletion(isComplete: Boolean): LiveData<List<Task>> {
        return tasksDao.queryByCompletionStatus(isComplete)
    }

    override fun insert(task: Task) = tasksDao.insertTask(task)


    override fun delete(task: Task) = tasksDao.deleteTask(task)

    override fun getAll(): LiveData<List<Task>> = tasksDao.loadAllTasks()

}

interface ITasksRepository {
    fun getByCompletion(isComplete: Boolean): LiveData<List<Task>>

    fun getAll(): LiveData<List<Task>>

    fun insert(task: Task)

    fun delete(task: Task)
}