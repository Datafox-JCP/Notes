package mx.datafox.notes.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mx.datafox.notes.notes.data.repository.NoteRepositoryImpl
import mx.datafox.notes.notes.data.source.NoteDatabase
import mx.datafox.notes.notes.domain.repository.NoteRepository
import mx.datafox.notes.notes.domain.use_case.AddNoteUseCase
import mx.datafox.notes.notes.domain.use_case.DeleteNoteUseCase
import mx.datafox.notes.notes.domain.use_case.GetNoteUseCase
import mx.datafox.notes.notes.domain.use_case.GetNotesUseCase
import mx.datafox.notes.notes.domain.use_case.NoteUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotesUseCase(repository),
            deleteNote = DeleteNoteUseCase(repository),
            addNote = AddNoteUseCase(repository),
            getNote = GetNoteUseCase(repository)
        )
    }
}