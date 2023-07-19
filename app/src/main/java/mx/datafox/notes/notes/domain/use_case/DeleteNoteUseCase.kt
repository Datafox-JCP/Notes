package mx.datafox.notes.notes.domain.use_case

import mx.datafox.notes.notes.domain.model.Note
import mx.datafox.notes.notes.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}