package nl.learningtocode.noteapp.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import nl.learningtocode.noteapp.data.NoteDataBaseDao
import nl.learningtocode.noteapp.model.Note
import java.util.*
import javax.inject.Inject

//class for CRUD operations
class NoteRepository @Inject constructor(private val noteDataBaseDao: NoteDataBaseDao){

    suspend fun addNote(note: Note) = noteDataBaseDao.insert(note)
    suspend fun updateNote(note: Note) = noteDataBaseDao.update(note)
    suspend fun deleteNote(note:Note) = noteDataBaseDao.deleteNote(note)
    suspend fun deleteAllNotes() = noteDataBaseDao.deleteAll()
    suspend fun getNotesById(note:Note) = noteDataBaseDao.getNotesById(id = "")
    fun getAllNotes(note: Flow<List<Note>>) = noteDataBaseDao.getNotes().flowOn(Dispatchers.IO).conflate()

}