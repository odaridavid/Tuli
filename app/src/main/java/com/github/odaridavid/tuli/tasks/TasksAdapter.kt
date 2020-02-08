package com.github.odaridavid.tuli.tasks;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.odaridavid.tuli.R

/**
 * Created By David Odari
 * On 07/02/20
 *
 **/
class TasksAdapter(val deleteOperation: (Task) -> Unit) :
    ListAdapter<Task, RecyclerView.ViewHolder>(TasksDiffUtil) {

    fun deleteItem(position: Int) {
        val task = getItem(position)
        deleteOperation(task)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = createView(parent, R.layout.item_task)
        return TasksViewHolder(view)
    }

    private fun createView(viewGroup: ViewGroup, @LayoutRes itemLayout: Int): View {
        val context = viewGroup.context
        val inflater = LayoutInflater.from(context)
        return inflater.inflate(itemLayout, viewGroup, false)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TasksViewHolder)
            getItem(position).let { holder.bind(it) }
    }

    inner class TasksViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: Task) {
            with(view) {
                val tasksTitleTextView = findViewById<TextView>(R.id.task_title_text_view)
                val tasksTimelineTextView = findViewById<TextView>(R.id.task_timeline_text_view)

                tasksTitleTextView.text = item.title
                tasksTimelineTextView.text =
                    context.getString(R.string.placeholder_timeline, item.startTime, item.endTime)
            }
        }
    }

    companion object {
        val TasksDiffUtil = object : DiffUtil.ItemCallback<Task>() {
            override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem == newItem
            }
        }
    }
}