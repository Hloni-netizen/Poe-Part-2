/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Part2;

import java.util.*;
import java.io.*;

/**
 * Manages the list of messages and system-level operations.
 */
public class MessageManager {

    private final List<Message> messages;
    private int totalMessages;

    public MessageManager() {
        messages = new ArrayList<>();
        totalMessages = 0;
    }

    // 1. Boolean: checkMessageID()
    public boolean checkMessageID(String id) {
        return id != null && id.length() <= 10;
    }

    // 2. Int: checkRecipientCell()
    public int checkRecipientCell(String cell) {
        if (cell != null && cell.startsWith("+") && cell.length() <= 10) {
            return 1;
        }
        return 0;
    }

    // 3. String: createMessageHash()

    /**
     *
     * @param message
     * @return
     */
    public String createMessageHash(Message message) {
        return message.getContentHash();
    }

    // 4. String: SentMessage()
    public String SentMessage(Scanner scanner) {
        System.out.println("Choose one of the following:");
        System.out.println("1. Send Message");
        System.out.println("2. Disregard Message");
        System.out.println("3. Store Message to send later");

        String input = scanner.nextLine();

        switch (input) {
            case "1":
                return "Sent";
            case "2":
                return "Discarded";
            case "3":
                return "Stored";
            default:
                System.out.println("Invalid option. Defaulting to Disregarded.");
                return "Discarded";
        }
    }

    // 5. String: printMessages()
    public String printMessages() {
        StringBuilder sb = new StringBuilder();
        for (Message msg : messages) {
            sb.append(msg.toString()).append("\n-------------------\n");
        }
        return sb.toString();
    }

    // 6. Int: returnTotalMessages()
    public int returnTotalMessages() {
        return totalMessages;
    }

    // 7. Store Message to JSON file
    public void storeMessage(Message message) {
        JSONArray messageList = new JSONArray();

        JSONObject msgJson = new JSONObject();
        msgJson.put("messageId", message.getMessageId());
        msgJson.put("messageNumber", message.getMessageNumber());
        msgJson.put("recipient", message.getRecipient());
        msgJson.put("content", message.getContent());
        msgJson.put("status", message.getStatus());
        msgJson.put("contentHash", message.getContentHash());

        messageList.add(msgJson);

        try (FileWriter file = new FileWriter("messages.json", true)) {
            file.write(messageList.toJSONString());
            file.flush();
            System.out.println("Message stored to messages.json");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to JSON file: " + e.getMessage());
        }
    }

    // Add new message
    public void addMessage(Message message) {
        messages.add(message);
        totalMessages++;
    }

    private static class Message {

        public Message() {
        }

        private String getContentHash() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String getMessageId() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String getMessageNumber() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String getRecipient() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String getContent() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String getStatus() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    private static class JSONArray {

        public JSONArray() {
        }

        private void add(JSONObject msgJson) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private char[] toJSONString() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    private static class JSONObject {

        public JSONObject() {
        }

        private void put(String contentHash, String contentHash0) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}

