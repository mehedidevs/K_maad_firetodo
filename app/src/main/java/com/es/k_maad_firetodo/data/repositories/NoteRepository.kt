package com.es.k_maad_firetodo.data.repositories

import androidx.lifecycle.LiveData
import com.es.k_maad_firetodo.data.model.Note
import com.es.k_maad_firetodo.utils.UiState

interface NoteRepository {

    fun add(note: Note)

    fun getAllTask( result: (UiState<List<Note>>) -> Unit)


    fun  delete(note: Note)

}