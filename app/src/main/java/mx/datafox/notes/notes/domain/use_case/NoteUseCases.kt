package mx.datafox.notes.notes.domain.use_case

data class NoteUseCases(
    val getNotes: GetNotesUseCase,
    val deleteNote: DeleteNoteUseCase
)