package com.github.odaridavid.tuli.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created By David Odari
 * On 07/02/20
 *
 **/
class TasksViewModel @Inject constructor(private val tasksRepository: TasksRepository) :
    ViewModel() {

    var tasks: LiveData<List<Task>> = tasksRepository.getByCompletion(isComplete = false)

    fun insert(task: Task) = tasksRepository.insert(task)

}