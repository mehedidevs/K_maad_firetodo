package com.es.k_maad_firetodo.di

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object FirebaseModule {

    @Provides
    @Singleton
    fun providesFireStore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }


//    fun getNote(): Note()
//    {
//
//        return Note()
//
//    }


}