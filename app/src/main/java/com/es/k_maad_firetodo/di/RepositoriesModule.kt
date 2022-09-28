package com.es.k_maad_firetodo.di

import com.es.k_maad_firetodo.data.repositories.NoteRepository
import com.es.k_maad_firetodo.data.repositories.NoteRepositoryImpl
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoriesModule {

    @Provides
    @Singleton
    fun provideNoteRepo( database: FirebaseFirestore): NoteRepository {
        // val  repo:NoteRepository= NoteRepositoryImpl(database)
      //  val  database= FirebaseFirestore.getInstance()

         return NoteRepositoryImpl(database)

    }


}