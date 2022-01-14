package nl.learningtocode.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import nl.learningtocode.noteapp.model.Note


@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDataBase : RoomDatabase() {

    abstract fun noteDao(): NoteDataBaseDao
}