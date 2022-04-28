package com.example.personsapp.presentation.ui.person

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.personsapp.databinding.ItemPersonBinding
import com.example.personsapp.domain.model.Person

class PersonAdapter(
    private val listOnItemClick: OnItemClick
): ListAdapter<Person, PersonAdapter.ViewHolder>(PersonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPersonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemPersonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Person) {
            binding.apply {
                ivIpImage.load(item.photo)
                tvIpName.text = "${item.name.title} ${item.name.first} ${item.name.last}"
                root.setOnClickListener {
                    listOnItemClick.onClick(item)
                }
            }
        }
    }
}

interface OnItemClick {
    fun onClick(item: Person)
}

private class PersonDiffCallback : DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean =
        oldItem.name == newItem.name
}