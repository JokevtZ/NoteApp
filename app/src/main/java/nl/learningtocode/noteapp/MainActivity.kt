package nl.learningtocode.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import nl.learningtocode.noteapp.screen.NoteScreen
import nl.learningtocode.noteapp.screen.NoteViewModel
import nl.learningtocode.noteapp.ui.theme.NoteAppTheme

@ExperimentalComposeUiApi
@AndroidEntryPoint // to direct hilt as the top entry point
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.Black) {
                    val noteViewModel : NoteViewModel by viewModels()
                    NotesApp(noteViewModel)
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun NotesApp(noteViewModel: NoteViewModel = viewModel()){
    val notesList = noteViewModel.getAllNotes()

    NoteScreen(
        notes = notesList,
        onAddNote = {
            noteViewModel.addNote(it)
        },
        onRemoveNote = {
            noteViewModel.removeNote(it)
        })
}
