package com.es.k_maad_firetodo.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.es.k_maad_firetodo.data.model.Note
import com.es.k_maad_firetodo.utils.Constants
import com.es.k_maad_firetodo.utils.UiState
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val database: FirebaseFirestore) :
    NoteRepository {


    override fun add(note: Note) {

        val document = database.collection(Constants.NOTE).document()

        note.id = document.id

        document.set(note).addOnSuccessListener {


        }.addOnFailureListener {

        }


    }


    private var _allTask = MutableLiveData<UiState<List<Note>>>()
    val allTask: LiveData<UiState<List<Note>>>
        get() = _allTask


    override fun getAllTask() {

        val notes = arrayListOf<Note>()

        _allTask.postValue(UiState.Loading())

        database.collection(Constants.NOTE)
            .get()
            .addOnSuccessListener { snapshot ->

                for (document in snapshot) {
                    val note = document.toObject(Note::class.java)
                    notes.add(note)
                }

                _allTask.postValue(UiState.Success(notes))


            }.addOnFailureListener {
                _allTask.postValue(
                    it.localizedMessage?.let { msg ->
                        UiState.Failure(message = msg)
                    })

            }


    }

    override fun delete(note: Note) {

    }
}