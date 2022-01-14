package nl.learningtocode.noteapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import nl.learningtocode.noteapp.data.NoteDataBase
import nl.learningtocode.noteapp.data.NoteDataBaseDao
import javax.inject.Singleton

// Used to add all the bindings to Hilt.
// Allowing it to instantiate or create certain dependencies for the database
@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideNotesDao(noteDataBase: NoteDataBase) :NoteDataBaseDao = noteDataBase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context : Context): NoteDataBase
    = Room.databaseBuilder(context, NoteDataBase::class.java, "notes.db")
        .fallbackToDestructiveMigration()
        .build()
}