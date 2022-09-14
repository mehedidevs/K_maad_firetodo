package com.es.k_maad_firetodo.data.repositories

import com.es.k_maad_firetodo.data.model.Note

interface NoteRepository {

    fun add(note: Note)
}