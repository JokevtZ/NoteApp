package nl.learningtocode.noteapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import nl.learningtocode.noteapp.model.Note

@Dao
interface NoteDataBaseDao {

    @Query("SELECT * FROM `notes.db`")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM `notes.db` WHERE id =:id")
    suspend fun getNotesById(id: String) : Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("DELETE FROM `notes.db`")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(note: Note)
}
