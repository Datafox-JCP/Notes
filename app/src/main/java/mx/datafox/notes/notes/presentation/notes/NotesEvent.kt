package mx.datafox.notes.notes.presentation.notes

import mx.datafox.notes.notes.domain.model.Note
import mx.datafox.notes.notes.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
