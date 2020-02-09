package com.github.odaridavid.tuli.di.modules

import com.github.odaridavid.tuli.MainActivity
import com.github.odaridavid.tuli.di.scopes.ActivityScope
import com.github.odaridavid.tuli.tasks.AddTasksActivity
import com.github.odaridavid.tuli.tasks.TasksModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created By David Odari
 * On 02/02/20
 *
 * Creates Sub Components for each activity and includes specified modules which are also
 * bound to an [ActivityScope]
 *
 **/
@Module
internal abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [TasksModule::class, ViewModelModule::class])
    internal abstract fun contributeMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [TasksModule::class, ViewModelModule::class])
    internal abstract fun contributeAddTasksActivity(): AddTasksActivity

}