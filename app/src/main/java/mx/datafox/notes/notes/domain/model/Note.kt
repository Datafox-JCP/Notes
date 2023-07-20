package mx.datafox.notes.notes.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import mx.datafox.notes.ui.theme.BabyBlue
import mx.datafox.notes.ui.theme.LightGreen
import mx.datafox.notes.ui.theme.RedOrange
import mx.datafox.notes.ui.theme.RedPink
import mx.datafox.notes.ui.theme.Violet

@Entity
data class Note(
    @PrimaryKey val id: Int? = null,
    val title: String,
    val content: String,
    val dateCreated: Long,
    val color: Int,
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, RedPink, BabyBlue)
    }
}

class InvalidNoteException(message: String): Exception(message)
