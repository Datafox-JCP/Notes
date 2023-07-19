package mx.datafox.notes.notes.data.source

import androidx.room.Database
import mx.datafox.notes.notes.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase {

    abstract val noteDao: NoteDao
}