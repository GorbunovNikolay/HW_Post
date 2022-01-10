data class NoteAttachment(val note: Note) : Attachment {
    override val type = "note"
}