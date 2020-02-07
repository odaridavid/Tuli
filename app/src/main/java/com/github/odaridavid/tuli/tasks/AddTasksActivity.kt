package com.github.odaridavid.tuli.tasks

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.viewModels
import com.github.odaridavid.tuli.MainActivity
import com.github.odaridavid.tuli.R
import com.github.odaridavid.tuli.base.BaseActivity
import com.github.odaridavid.tuli.commons.navigateTo
import com.github.odaridavid.tuli.commons.requireNotBlank
import dagger.android.AndroidInjection

class AddTasksActivity : BaseActivity() {

    override val toolbarId: Int
        get() = R.id.add_task_toolbar

    lateinit var taskTitleEditText: EditText

    private val tasksViewModel: TasksViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_tasks)
        setSupportActionBar(toolbar)
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        taskTitleEditText = findViewById(R.id.task_title_edit_text)

    }

    fun onStartTask(view: View) {
        //TODO Get Current Time and End Time
        //TODO Setup Alarm Manager and work manager
        val title = requireNotBlank(taskTitleEditText.text.toString())
        val task = Task(startTime = "", endTime = "", title = title, date = "")
        tasksViewModel.insert(task)
        taskTitleEditText.setText("")
        navigateTo<MainActivity>()
        finish()
    }
}
