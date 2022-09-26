package com.es.k_maad_firetodo.data.repositories

import androidx.lifecycle.LiveData
import com.es.k_maad_firetodo.data.model.Note

interface NoteRepository {

    fun add(note: Note)

    fun getAllTask(): List<Note>

}