package nl.learningtocode.noteapp.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import nl.learningtocode.noteapp.model.Note
import nl.learningtocode.noteapp.repository.NoteRepository
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository : NoteRepository) : ViewModel() {
//    private var noteList = mutableStateListOf<Note>()
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()


    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes(noteList).distinctUntilChanged()
                .collect{ listOfNotes ->
                    if (listOfNotes.isNullOrEmpty()){
                        Log.d("List", "List is Empty")
                    } else {
                        _noteList.value = listOfNotes
                    }
                }
        }
    }

    fun addNote(note: Note) = viewModelScope.launch{ repository.addNote(note) }
    fun updateNote(note: Note) =viewModelScope.launch{ repository.updateNote(note) }
    fun deleteNote(note: Note) = viewModelScope.launch{ repository.deleteNote(note) }


}