package com.es.k_maad_firetodo.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.es.k_maad_firetodo.R
import com.es.k_maad_firetodo.data.model.Note
import com.es.k_maad_firetodo.ui.viewholders.NoteViewHolder

class NoteAdapter(
    private var context: Context,
    private var noteList: List<Note>

) : RecyclerView.Adapter<NoteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_note, parent, false)

        return NoteViewHolder(view)


    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val item = noteList[position]
        holder.itemName.text = item.noteText
        holder.itemAmount.text = item.priority

    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}