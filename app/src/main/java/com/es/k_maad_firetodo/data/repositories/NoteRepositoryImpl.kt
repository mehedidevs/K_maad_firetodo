package com.es.k_maad_firetodo.data.repositories

import androidx.lifecycle.LiveData
import com.es.k_maad_firetodo.data.model.Note
import com.es.k_maad_firetodo.utils.Constants
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
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

    override fun getAllTask(): List<Note> {

        val notes = arrayListOf<Note>()

        database.collection(Constants.NOTE)
            .get()
            .addOnSuccessListener { snapshot ->

            for (document in snapshot) {
                val note = document.toObject(Note::class.java)
                notes.add(note)

            }


        }.addOnFailureListener {


        }




        return notes


    }
}