package com.multidebugger.internal.ui.category_list

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.multidebugger.library.R
import com.multidebugger.internal.data.entity.DebugMessage

internal class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvMessageTitle: TextView = itemView.findViewById(R.id.tvMessageTitle)
    private val tvMessageDescription: TextView = itemView.findViewById(R.id.tvMessageDescription)

    fun bindData(debugMessage: DebugMessage) {
        tvMessageTitle.text = debugMessage.title
        tvMessageDescription.text = debugMessage.message
    }

}
