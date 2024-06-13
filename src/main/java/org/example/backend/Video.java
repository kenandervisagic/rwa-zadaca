package org.example.backend;

public class Video {
    private int id;
    private String title;
    private String description;
    private String url;
    private int positiveVotes;
    private int totalVotes;


    public Video(int id, String title, String description, String url, int positiveVotes, int totalVotes) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.positiveVotes = positiveVotes;
        this.totalVotes = totalVotes;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
