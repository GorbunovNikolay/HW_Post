data class LinkAttachment(val link: Link) : Attachment {
    override val type = "link"
}