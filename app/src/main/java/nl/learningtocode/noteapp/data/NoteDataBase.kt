package nl.learningtocode.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import nl.learningtocode.noteapp.model.Note
import nl.learningtocode.noteapp.util.DateConverter
import nl.learningtocode.noteapp.util.UUIDConverter


@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDataBase : RoomDatabase() {
    abstract fun noteDao(): NoteDataBaseDao
}