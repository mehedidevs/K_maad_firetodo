package com.es.k_maad_firetodo.data.repositories

import com.es.k_maad_firetodo.data.model.Note
import com.es.k_maad_firetodo.utils.Constants
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class NoteRepositoryImpl : NoteRepository {


    override fun add(note: Note) {

        val document = FirebaseFirestore.getInstance().collection(Constants.NOTE).document("note")
            .set(note).addOnSuccessListener {

            }.addOnFailureListener {

            }


    }
}