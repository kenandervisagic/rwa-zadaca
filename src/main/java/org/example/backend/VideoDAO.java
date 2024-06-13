package org.example.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VideoDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/video_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static List<Video> getRandomVideos(int count) {
        List<Video> videos = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM videos ORDER BY RAND() LIMIT ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, count);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    Video video = new Video(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getString("url"),
                            rs.getInt("positiveVotes"),
                            rs.getInt("totalVotes")
                    );
                    videos.add(video);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return videos;
    }
}
