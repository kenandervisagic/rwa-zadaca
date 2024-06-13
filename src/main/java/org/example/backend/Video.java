package org.example.backend;

public class Video {
    private int id;
    private String title;
    private String description;
    private int positiveVotes;
    private int totalVotes;
    private String embedCode;


    public Video(int id, String title, String description,  int positiveVotes, int totalVotes, String embedCode) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.positiveVotes = positiveVotes;
        this.totalVotes = totalVotes;
        this.embedCode = embedCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmbedCode() {
        return embedCode;
    }

    public void setEmbedCode(String embedCode) {
        this.embedCode = embedCode;
    }

    public int getPositiveVotes() {
        return positiveVotes;
    }

    public void setPositiveVotes(int positiveVotes) {
        this.positiveVotes = positiveVotes;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }
}
