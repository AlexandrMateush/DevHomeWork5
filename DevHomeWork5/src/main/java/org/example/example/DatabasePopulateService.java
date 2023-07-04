package org.example.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;


public class DatabasePopulateService {
    public static void main(String[] args) {

        String sqlFile = "sql/populate_db.sql";
        String placeholders = "INSERT INTO worker (ID, NAME, BIRTHDAY, LEVEL, SALARY)\n" +
                "VALUES (?,?,?,?,?)";
        String sqlContent = readFileContent(sqlFile);
        int id = 0;
        String name = "";
        Timestamp birthday = null;
        String level = "";
        int salary=0;

        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlContent+placeholders)) {
            stmt.setInt(1,id);
            stmt.setString(2,name);
            stmt.setTimestamp(3,birthday);
            stmt.setString(4,level);
            stmt.setInt(5,salary);
            stmt.executeUpdate();
            System.out.println("Database populated successfully.");
        } catch (SQLException e) {
            System.out.println("Error populating database: " + e.getMessage());
        }
    }

    private static String readFileContent(String filePath) {
        try {
            Path path = Paths.get(filePath);
            byte[] bytes = Files.readAllBytes(path);
            return new String(bytes);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return "";
        }
    }
}

