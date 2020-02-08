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
import com.github.odaridavid.tuli.commons.showToast
import dagger.android.AndroidInjection
import org.threeten.bp.ZonedDateTime

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

        showToast(getCurrentTime())

    }

    fun onStartTask(view: View) {
        //Create Task Object
        val startTime = getCurrentTime()
        val endTime = "04:00"
        val date = getDateToday()
        val title = requireNotBlank(taskTitleEditText.text.toString())
        val task = Task(startTime = startTime, endTime = endTime, title = title, date = date)
        //Save Task
        tasksViewModel.insert(task)
        //Clear Fields
        taskTitleEditText.setText("")
        //Navigate Back
        navigateTo<MainActivity>()
        finish()
    }

    private fun getCurrentTime(): String = ZonedDateTime.now().run { "$hour:$minute" }

    private fun getDateToday(): String = ZonedDateTime.now().run { "$dayOfMonth-$monthValue-$year" }

}
