package mx.datafox.notes.notes.domain.use_case

import mx.datafox.notes.notes.domain.model.InvalidNoteException
import mx.datafox.notes.notes.domain.model.Note
import mx.datafox.notes.notes.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNoteUseCase(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("El título no puede estar en blanco")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("La nota debe tener contenido")
        }
        repository.addNote(note)
    }
}