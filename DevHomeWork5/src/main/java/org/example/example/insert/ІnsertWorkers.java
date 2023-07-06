package org.example.example.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ІnsertWorkers {
    public static void insertWorkers(Connection conn) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO worker (ID, NAME, BIRTHDAY, LEVEL, SALARY) VALUES (?,?,?,?,?);");


        stmt.setInt(1, 1);
        stmt.setString(2, "John Doe");
        stmt.setTimestamp(3, Timestamp.valueOf("1990-05-15 00:00:00"));
        stmt.setString(4, "Trainee");
        stmt.setInt(5, 800);
        stmt.addBatch();

        stmt.setInt(1, 2);
        stmt.setString(2, "Jane Smith");
        stmt.setTimestamp(3, Timestamp.valueOf("1985-09-20 00:00:00"));
        stmt.setString(4, "Junior");
        stmt.setInt(5, 1200);
        stmt.addBatch();

        stmt.setInt(1, 3);
        stmt.setString(2, "Michael Johnson");
        stmt.setTimestamp(3, Timestamp.valueOf("1982-02-10 00:00:00"));
        stmt.setString(4, "Middle");
        stmt.setInt(5, 2500);
        stmt.addBatch();

        stmt.setInt(1, 4);
        stmt.setString(2, "Genry Smitt");
        stmt.setTimestamp(3, Timestamp.valueOf("1983-05-05 00:00:00"));
        stmt.setString(4, "Trainee");
        stmt.setInt(5, 900);
        stmt.addBatch();

        stmt.setInt(1, 5);
        stmt.setString(2, "Sharlota Smitt");
        stmt.setTimestamp(3, Timestamp.valueOf("1985-08-15 00:00:00"));
        stmt.setString(4, "Middle");
        stmt.setInt(5, 2300);
        stmt.addBatch();

        stmt.setInt(1, 6);
        stmt.setString(2, "Michael Mark");
        stmt.setTimestamp(3, Timestamp.valueOf("1992-05-18 00:00:00"));
        stmt.setString(4, "Middle");
        stmt.setInt(5, 2800);
        stmt.addBatch();

        stmt.setInt(1, 7);
        stmt.setString(2, "Mark Jons");
        stmt.setTimestamp(3, Timestamp.valueOf("1975-02-10 00:00:00"));
        stmt.setString(4, "Senior");
        stmt.setInt(5, 7500);
        stmt.addBatch();

        stmt.setInt(1, 8);
        stmt.setString(2, "Cris Mask");
        stmt.setTimestamp(3, Timestamp.valueOf("1989-07-21 00:00:00"));
        stmt.setString(4, "Junior");
        stmt.setInt(5, 1000);
        stmt.addBatch();

        stmt.setInt(1, 9);
        stmt.setString(2, "Sara Johnson");
        stmt.setTimestamp(3, Timestamp.valueOf("1988-02-10 00:00:00"));
        stmt.setString(4, "Middle");
        stmt.setInt(5, 2700);
        stmt.addBatch();

        stmt.setInt(1, 10);
        stmt.setString(2, "Emily Williams");
        stmt.setTimestamp(3, Timestamp.valueOf("1993-07-02 00:00:00"));
        stmt.setString(4, "Senior");
        stmt.setInt(5, 5000);
        stmt.addBatch();

        stmt.executeBatch();
    }
}
