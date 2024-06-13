package org.example.backend;

import com.github.javafaker.Faker;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VideoDataGenerator {
    private static final String URL = "jdbc:mysql://localhost:3305/video_database"; // Ažurirano s portom 3305
    private static final String USER = "root"; // Zamijenite s novim korisničkim imenom
    private static final String PASSWORD = "keno"; // Zamijenite s novom lozinkom
    private static final int VIDEO_COUNT = 100; // Broj videa koje želite generirati

    public static void main(String[] args) {
        Faker faker = new Faker();
        String[] embedCodes = {
                "9bZkp7q19f0",
                "gtTVuebS-Ss",
                "-GxsoWX-Nr4",
                "RRj1WOkE9P0",
                "VMT50KhLlRw",
                "LnrTDS85rC8",
                "iv8tu2qemP0",
                "QREab0kaAGU",
                "LYGPfakosCs",
        };

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

                if (i % 10 == 0) { // Execute batch every 10 inserts
                    statement.executeBatch();
                }
            }

            statement.executeBatch(); // Execute remaining batches
            System.out.println("Database populated with " + VIDEO_COUNT + " videos.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}