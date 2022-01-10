data class DocumentAttachment(val document: Document) : Attachment {
    override val type = "document"
}