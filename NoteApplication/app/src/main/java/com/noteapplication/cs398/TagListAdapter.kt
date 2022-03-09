package com.noteapplication.cs398

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.noteapplication.cs398.databinding.CourseItemBinding
import com.noteapplication.cs398.databinding.NoteItemBinding
import com.noteapplication.cs398.databinding.TagItemBinding

class TagListAdapter(private val viewModel: TagViewModel, private val activity: AppCompatActivity) :
    RecyclerView.Adapter<TagListAdapter.ViewHolder>() {

    private var allTag: ArrayList<Tag> = ArrayList()

    init {
        // *** need to optimize note updates because
        // *** copying entire database for a single changed note is
        // *** unacceptable!
        // maybe keep reference from viewModel.allNotes as the source
        // and call notifyItem*(int) for every add/edit/update calls on it

        viewModel.allTags.observe(activity){
            allTag.clear()
            allTag.addAll(it)
            notifyDataSetChanged()
        }
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(val binding: TagItemBinding) : RecyclerView.ViewHolder(binding.root)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TagListAdapter.ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = TagItemBinding.inflate(LayoutInflater.from(viewGroup.context))

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.binding.itemTitle.text = allTag[position].name

        // delete button
//        viewHolder.binding.deleteButton.setOnClickListener { _ ->
//            viewModel.deleteNote(allFolder[position])
//        }

        // read note navigation
        viewHolder.binding.noteItem.setOnClickListener{ _ ->
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = allTag.size

}