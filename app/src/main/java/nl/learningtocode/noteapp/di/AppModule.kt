package nl.learningtocode.noteapp.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// Used to add all the bindings to Hilt.
// Allowing it to instantiate or create certain dependencies for the database
@InstallIn(SingletonComponent::class)
@Module
object AppModule {
}