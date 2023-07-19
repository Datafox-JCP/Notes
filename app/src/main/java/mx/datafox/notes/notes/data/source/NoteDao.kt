package mx.datafox.notes.notes.data.source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import mx.datafox.notes.notes.domain.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>> // Flow no puede usarse desde una función suspendida

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteId(id: Int): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}