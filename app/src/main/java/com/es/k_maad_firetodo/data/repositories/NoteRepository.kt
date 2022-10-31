package com.es.k_maad_firetodo.data.repositories

import com.es.k_maad_firetodo.data.model.Note
import com.es.k_maad_firetodo.utils.UiState

interface NoteRepository {

    fun add(note: Note)
    fun getAllTask( )
    fun  delete(note: Note)

}