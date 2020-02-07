package com.github.odaridavid.tuli.tasks

import androidx.lifecycle.ViewModel
import com.github.odaridavid.tuli.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created By David Odari
 * On 07/02/20
 *
 **/
@Module
internal abstract class TasksModule {

    @Binds
    @IntoMap
    @ViewModelKey(TasksViewModel::class)
    internal abstract fun bindViewModel(viewModel: TasksViewModel): ViewModel

    @Binds
    internal abstract fun bindTasksRepository(tasksRepository: TasksRepository): ITasksRepository

}