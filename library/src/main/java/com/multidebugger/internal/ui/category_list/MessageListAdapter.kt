package com.multidebugger.internal.ui.category_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.multidebugger.internal.data.entity.DebugMessage
import com.multidebugger.library.R

internal class MessageListAdapter : ListAdapter<DebugMessage, MessageViewHolder>(DebugMessageDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    class DebugMessageDiffUtil : DiffUtil.ItemCallback<DebugMessage>() {
        override fun areItemsTheSame(oldItem: DebugMessage, newItem: DebugMessage): Boolean {
            return oldItem.messageId == newItem.messageId
        }

        override fun areContentsTheSame(oldItem: DebugMessage, newItem: DebugMessage): Boolean {
            return oldItem == newItem
        }
    }
}

