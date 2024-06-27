package org.example.backend;

import com.github.javafaker.Faker;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VideoDataGenerator {
    private static final String URL = "jdbc:mysql://localhost:3305/video_database"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "keno"; 
    private static final int VIDEO_COUNT = 100; 
    static String[] embedCodes = {
            "gtTVuebS-Ss",
            "BY_XwvKogC8",
            "-GxsoWX-Nr4",
            "RRj1WOkE9P0",
            "d5gf9dXbPi0",
            "VMT50KhLlRw",
            "iv8tu2qemP0",
            "QREab0kaAGU",
            "LYGPfakosCs",
            "d7tpYyAnopA",
            "ks2-b3dUDKw",
            "XQv3FL5I6RY",
            "_qBnBbJyNug",
            "02HYSqHrCZQ",
            "X-UTfyUbLUw",
            "1gyUQXVna-8",
            "6u_cgKR_D3w",
            "0fhrf-BMPxY"
    };

    public static void main(String[] args) {
        Faker faker = new Faker();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO videos (title, description, positive_votes, total_votes, embed_code) VALUES (?, ?, 0, 0, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            for (int i = 1; i <= VIDEO_COUNT; i++) {
                String title = "Video " + i;
                String description = faker.lorem().paragraph();
                String embedCode = embedCodes[i % embedCodes.length];

                statement.setString(1, title);
                statement.setString(2, description);
                statement.setString(3, embedCode);
                statement.addBatch();

                if (i % 10 == 0) { 
                    statement.executeBatch();
                }
            }

            statement.executeBatch(); 
            System.out.println("Database populated with " + VIDEO_COUNT + " videos.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}