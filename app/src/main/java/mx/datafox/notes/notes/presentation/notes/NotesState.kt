package mx.datafox.notes.notes.presentation.notes

import mx.datafox.notes.notes.domain.model.Note
import mx.datafox.notes.notes.domain.util.NoteOrder
import mx.datafox.notes.notes.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
