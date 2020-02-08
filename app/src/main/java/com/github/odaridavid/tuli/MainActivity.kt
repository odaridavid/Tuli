package com.github.odaridavid.tuli

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.github.odaridavid.tuli.base.BaseActivity
import com.github.odaridavid.tuli.commons.navigateTo
import com.github.odaridavid.tuli.tasks.AddTasksActivity
import com.github.odaridavid.tuli.tasks.SwipeToDeleteCallback
import com.github.odaridavid.tuli.tasks.TasksAdapter
import com.github.odaridavid.tuli.tasks.TasksViewModel
import dagger.android.AndroidInjection
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter

class MainActivity : BaseActivity() {

    override val toolbarId: Int
        get() = R.id.main_toolbar

    private val tasksViewModel: TasksViewModel by viewModels { viewModelFactory }

    private val tasksRecyclerView: RecyclerView by lazy { findViewById<RecyclerView>(R.id.tasks_recycler_view) }
    private val backgroundImageView: ImageView by lazy { findViewById<ImageView>(R.id.default_background_image_view) }
    private val defaultInfoTextView: TextView by lazy { findViewById<TextView>(R.id.default_view_info_text) }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        observePendingTasks()
    }

    private fun observePendingTasks() {
        tasksViewModel.tasks.observe(this) { pendingTasks ->
            if (pendingTasks.isNotEmpty()) {
                backgroundImageView.animate().alpha(0.0f)
                defaultInfoTextView.animate().alpha(0.0f)
                val tasksAdapter = init { submitList(pendingTasks) }
                val animatedAdapter = AlphaInAnimationAdapter(tasksAdapter)
                val itemTouchHelper = ItemTouchHelper(SwipeToDeleteCallback(tasksAdapter))
                itemTouchHelper.attachToRecyclerView(tasksRecyclerView)
                tasksRecyclerView.adapter = animatedAdapter
            } else {
                backgroundImageView.animate().alpha(1.0f)
                defaultInfoTextView.animate().alpha(1.0f)
                tasksRecyclerView.animate().alpha(0.0f)
            }
        }
    }

    private inline fun init(block: TasksAdapter.() -> Unit): TasksAdapter {
        return TasksAdapter(deleteOperation = { task -> tasksViewModel.delete(task) })
            .apply { block() }
    }

    fun navigateToAddNewTask(view: View) = navigateTo<AddTasksActivity>()

}
