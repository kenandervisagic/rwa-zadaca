package org.example.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VideoDAO {
    private static final String URL = "jdbc:mysql://localhost:3305/video_database"; 
    private static final String USER = "root";
    private static final String PASSWORD = "keno";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


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
                            rs.getInt("positive_votes"),
                            rs.getInt("total_votes"),
                            rs.getString("embed_code")
                    );
                    videos.add(video);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return videos;
    }

    public static List<Video> getTop(int page, int pageSize) {
        List<Video> videos = new ArrayList<>();
        int offset = (page - 1) * pageSize;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM videos ORDER BY ((positive_votes + 1.9208) / (positive_votes + total_votes) - " +
                    "1.96 * SQRT((positive_votes * total_votes) / (positive_votes + total_votes) + 0.9604) / " +
                    "(positive_votes + total_votes)) / (1 + 3.8416 / (positive_votes + total_votes)) DESC LIMIT ? OFFSET ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, pageSize);
                statement.setInt(2, offset);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    Video video = new Video(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getInt("positive_votes"),
                            rs.getInt("total_votes"),
                            rs.getString("embed_code")
                    );
                    videos.add(video);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return videos;
    }

    public static int getTotalVideoCount() {
        int totalVideoCount = 0;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT COUNT(*) AS total FROM videos";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    totalVideoCount = resultSet.getInt("total");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalVideoCount;
    }

    public static void incrementPositiveVotes(int videoId) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "UPDATE videos SET positive_votes = positive_votes + 1 WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, videoId);
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void incrementTotalVotes(int videoId) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "UPDATE videos SET total_votes = total_votes + 1 WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, videoId);
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
