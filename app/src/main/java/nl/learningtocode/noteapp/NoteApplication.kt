package nl.learningtocode.noteapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Creating a dependency container on the top level of the application
@HiltAndroidApp
class NoteApplication : Application() {

}