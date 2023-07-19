package mx.datafox.notes.notes.data.repository

import kotlinx.coroutines.flow.Flow
import mx.datafox.notes.notes.data.source.NoteDao
import mx.datafox.notes.notes.domain.model.Note
import mx.datafox.notes.notes.domain.repository.NoteRepository

class NoteRepositoryImpl(
    private val dao: NoteDao
): NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteId(id)
    }

    override suspend fun addNote(note: Note) {
        return dao.addNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        return dao.deleteNote(note)
    }


}