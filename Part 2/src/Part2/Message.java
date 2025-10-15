package Part2;

import java.util.Locale;

public class Message {
    private long messageNumber;  // Change from int to long
    private String recipient;
    private String content;
    private String status;
    private String messageId;
    private String contentHash;

    // Constructor now accepts a long for messageNumber
    public Message(long messageNumber, String recipient, String content, String status) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.content = content.length() <= 250 ? content : content.substring(0, 250);
        this.status = status;
        this.messageId = generateMessageId(messageNumber);
        this.contentHash = createMessageHash();
    }

    // Generates a 10-digit zero-padded message ID
    private String generateMessageId(long number) {
        return String.format("%010d", number); // 10-digit zero-padded
    }

    // Checks if the message ID length is 10 characters
    public boolean checkMessageID() {
        return this.messageId.length() <= 10;
    }

    // Checks if the recipient phone number starts with +27 and is 12 characters long
    public int checkRecipientCell() {
        if (recipient != null && recipient.startsWith("+27") && recipient.length() == 12) {
            return 1;
        }
        return 0;
    }

    // Creates a message hash based on the messageId and content
    public String createMessageHash() {
        String idStart = messageId.substring(0, 2);
        String firstWord = content.trim().split("\\s+")[0];
        String[] words = content.trim().split("\\s+");
        String lastWord = words[words.length - 1];

        return (idStart + ":" + messageNumber + ":" + firstWord + lastWord).toUpperCase(Locale.ROOT);
    }

    // Returns a string describing the message's status
    public String SentMessage() {
        switch (status.toLowerCase()) {
            case "sent":
                return "Message sent";
            case "stored":
                return "Message stored for later";
            case "discarded":
                return "Message discarded";
            default:
                return "Unknown message status";
        }
    }

    // Returns a formatted string with message details
    public String printMessages() {
        return String.format("ID: %s\nRecipient: %s\nContent: %s\nHash: %s\nStatus: %s\n",
                messageId, recipient, content, contentHash, status);
    }

    // Returns the message number
    public long returnTotalMessages() {
        return messageNumber;
    }

    // === GETTERS ===
    public long getMessageNumber() { return messageNumber; }
    public String getMessageId() { return messageId; }
    public String getRecipient() { return recipient; }
    public String getContent() { return content; }
    public String getContentHash() { return contentHash; }
    public String getStatus() { return status; }

    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }
}
