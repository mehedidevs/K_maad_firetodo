package com.es.k_maad_firetodo.ui.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.es.k_maad_firetodo.R


class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    public var itemName: TextView = itemView.findViewById(R.id.title)
    public var itemAmount: TextView = itemView.findViewById(R.id.description)


}