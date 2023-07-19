package mx.datafox.notes.notes.domain.repository

import kotlinx.coroutines.flow.Flow
import mx.datafox.notes.notes.domain.model.Note

interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun addNote(note: Note)

    suspend fun deleteNote(note: Note)
}