package com.example.apelsinclone.ui.fragments.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apelsinclone.databinding.ItemFastEnterBinding
import com.example.apelsinclone.ui.fragments.models.FastEnterObject

class FastEnterListAdapter(private val context: Context) :
    ListAdapter<FastEnterObject, FastEnterListAdapter.ViewHolder>(
        DiffReviewsCallback()
    ) {

    class ViewHolder private constructor(var binding: ItemFastEnterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemFastEnterBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.binding.textView.text = item.name
        holder.binding.imageView.setImageDrawable(ResourcesCompat.getDrawable(context.resources,
            item.imageId,
            null))
    }

}

class DiffReviewsCallback : DiffUtil.ItemCallback<FastEnterObject>() {

    override fun areItemsTheSame(oldItem: FastEnterObject, newItem: FastEnterObject): Boolean {
        return oldItem == newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: FastEnterObject, newItem: FastEnterObject): Boolean {
        return oldItem == newItem
    }

}