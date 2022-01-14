package nl.learningtocode.noteapp.data

import nl.learningtocode.noteapp.model.Note
import java.time.LocalDateTime
import java.util.*

class NoteDataSource{

    fun loadNotes(): List <Note>{
        return listOf(
            Note(UUID.randomUUID(),"TestInput ","firstTestInput"),
            Note(UUID.randomUUID(),"SecondInput", "HowtoSetThisTime")

        )
    }
}