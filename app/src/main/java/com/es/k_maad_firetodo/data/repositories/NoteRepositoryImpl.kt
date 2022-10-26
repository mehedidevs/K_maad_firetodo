package com.es.k_maad_firetodo.data.repositories

import android.util.Log
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




    override fun getAllTask(result: (UiState<List<Note>>) -> Unit) {

        val notes = arrayListOf<Note>()

        database.collection(Constants.NOTE)
            .get()
            .addOnSuccessListener { snapshot ->

                for (document in snapshot) {
                    val note = document.toObject(Note::class.java)
                    notes.add(note)
                }

                result.invoke(
                    UiState.Success(notes)
                )

                // allNotes.value = notes




            }.addOnFailureListener {

                Log.i("TAG", "getAllTask:${it.localizedMessage} ")
                result.invoke(
                    UiState.Failure("Error ${it.localizedMessage}")
                )

            }


    }

    override fun delete(note: Note) {

    }
}