package com.nangokuman.databindingrecycleviewsample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.nangokuman.databindingrecycleviewsample.databinding.CaptionItemBinding
import com.nangokuman.databindingrecycleviewsample.databinding.CategoryItemBinding
import com.nangokuman.databindingrecycleviewsample.databinding.SubCaptionItemBinding

class MainListRecycleViewAdapter(private var items: List<MainListViewModel.ListItem>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(MainListViewModel.ListItem.Type.from(viewType)) {
            MainListViewModel.ListItem.Type.Caption -> {
                val binding = CaptionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return CaptionItemViewHolder(binding)
            }
            MainListViewModel.ListItem.Type.SubCaption -> {
                val binding = SubCaptionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return SubCaptionItemViewHolder(binding)
            }
            MainListViewModel.ListItem.Type.Category -> {
                val binding = CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return CategoryItemViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when {
            holder is CaptionItemViewHolder && item is MainListViewModel.ListItem.CaptionItem -> {
                holder.binding.item = item
            }
            holder is SubCaptionItemViewHolder && item is MainListViewModel.ListItem.SubCaptionItem -> {
                holder.binding.item = item
            }
            holder is CategoryItemViewHolder && item is MainListViewModel.ListItem.CategoryItem -> {
                holder.binding.item = item
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        return item.getType().id
    }

    private inner class CaptionItemViewHolder(val binding: CaptionItemBinding): RecyclerView.ViewHolder(binding.root)
    private inner class SubCaptionItemViewHolder(val binding: SubCaptionItemBinding): RecyclerView.ViewHolder(binding.root)
    private inner class CategoryItemViewHolder(val binding: CategoryItemBinding): RecyclerView.ViewHolder(binding.root)

}