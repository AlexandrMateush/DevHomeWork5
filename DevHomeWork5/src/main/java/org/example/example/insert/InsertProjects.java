package org.example.example.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class InsertProjects {
    public static void insertProjects(Connection conn) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO project (ID, CLIENT_ID, START_DATE, FINISH_DATE) VALUES (?,?,?,?);");

        stmt.setInt(1, 1);
        stmt.setInt(2, 1);
        stmt.setTimestamp(3, Timestamp.valueOf("2023-01-01 00:00:00"));
        stmt.setTimestamp(4, Timestamp.valueOf("2023-02-27 00:00:00"));
        stmt.addBatch();

        stmt.setInt(1, 2);
        stmt.setInt(2, 2);
        stmt.setTimestamp(3, Timestamp.valueOf("2023-03-15 00:00:00"));
        stmt.setTimestamp(4, Timestamp.valueOf("2024-06-30 00:00:00"));
        stmt.addBatch();

        stmt.setInt(1, 3);
        stmt.setInt(2, 3);
        stmt.setTimestamp(3, Timestamp.valueOf("2023-04-10 00:00:00"));
        stmt.setTimestamp(4, Timestamp.valueOf("2023-05-20 00:00:00"));
        stmt.addBatch();

        stmt.setInt(1, 4);
        stmt.setInt(2, 4);
        stmt.setTimestamp(3, Timestamp.valueOf("2022-04-21 00:00:00"));
        stmt.setTimestamp(4, Timestamp.valueOf("2023-06-21 00:00:00"));
        stmt.addBatch();

        stmt.setInt(1, 5);
        stmt.setInt(2, 5);
        stmt.setTimestamp(3, Timestamp.valueOf("2022-05-15 00:00:00"));
        stmt.setTimestamp(4, Timestamp.valueOf("2023-08-22 00:00:00"));
        stmt.addBatch();

        stmt.setInt(1, 6);
        stmt.setInt(2, 2);
        stmt.setTimestamp(3, Timestamp.valueOf("2022-07-20 00:00:00"));
        stmt.setTimestamp(4, Timestamp.valueOf("2023-09-23 00:00:00"));
        stmt.addBatch();

        stmt.setInt(1, 7);
        stmt.setInt(2, 3);
        stmt.setTimestamp(3, Timestamp.valueOf("2022-05-21 00:00:00"));
        stmt.setTimestamp(4, Timestamp.valueOf("2023-10-24 00:00:00"));
        stmt.addBatch();

        stmt.setInt(1, 8);
        stmt.setInt(2, 4);
        stmt.setTimestamp(3, Timestamp.valueOf("2022-04-22 00:00:00"));
        stmt.setTimestamp(4, Timestamp.valueOf("2023-11-25 00:00:00"));
        stmt.addBatch();

        stmt.setInt(1, 9);
        stmt.setInt(2, 3);
        stmt.setTimestamp(3, Timestamp.valueOf("2022-08-23 00:00:00"));
        stmt.setTimestamp(4, Timestamp.valueOf("2023-12-26 00:00:00"));
        stmt.addBatch();

        stmt.setInt(1, 10);
        stmt.setInt(2, 1);
        stmt.setTimestamp(3, Timestamp.valueOf("2022-09-24 00:00:00"));
        stmt.setTimestamp(4, Timestamp.valueOf("2023-11-27 00:00:00"));
        stmt.addBatch();

        stmt.executeBatch();
    }
}
