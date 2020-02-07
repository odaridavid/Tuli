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
class TasksAdapter : ListAdapter<Task, RecyclerView.ViewHolder>(TasksDiffUtil) {

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_HEADER else TYPE_ITEM
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> {
                val view = createView(parent, R.layout.item_task)
                TasksHeaderViewHolder(view)
            }
            TYPE_ITEM -> {
                val view = createView(parent, R.layout.item_tasks_header)
                TasksViewHolder(view)
            }
            else -> throw IllegalStateException("Unknown View Type")
        }

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

    inner class TasksHeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //Leave Blank
    }

    companion object {

        const val TYPE_HEADER = 0
        const val TYPE_ITEM = 1

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