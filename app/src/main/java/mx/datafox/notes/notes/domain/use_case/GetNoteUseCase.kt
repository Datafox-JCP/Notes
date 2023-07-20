package mx.datafox.notes.notes.domain.use_case

import mx.datafox.notes.notes.domain.model.Note
import mx.datafox.notes.notes.domain.repository.NoteRepository

class GetNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}