package com.es.k_maad_firetodo.ui.task

import androidx.lifecycle.ViewModel
import com.es.k_maad_firetodo.data.model.Note
import com.es.k_maad_firetodo.data.repositories.NoteRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(var repositoryImpl: NoteRepositoryImpl) : ViewModel() {


    fun addNote(note: Note) = repositoryImpl.add(note)

    fun getAllTaskData() = repositoryImpl.getAllTask()

    val allNotes= repositoryImpl.allNotes



}