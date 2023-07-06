package org.example.example.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertProjectWorkers {
    public static void insertProjectWorkers(Connection conn) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (?,?);");

        // Project 1
        stmt.setInt(1, 1);
        stmt.setInt(2, 2);
        stmt.addBatch();
        stmt.setInt(1, 1);
        stmt.setInt(2, 5);
        stmt.addBatch();
        stmt.setInt(1, 1);
        stmt.setInt(2, 4);
        stmt.addBatch();

        // Project 2
        stmt.setInt(1, 2);
        stmt.setInt(2, 2);
        stmt.addBatch();
        stmt.setInt(1, 2);
        stmt.setInt(2, 3);
        stmt.addBatch();
        stmt.setInt(1, 2);
        stmt.setInt(2, 4);
        stmt.addBatch();

        // Project 3
        stmt.setInt(1, 3);
        stmt.setInt(2, 2);
        stmt.addBatch();
        stmt.setInt(1, 3);
        stmt.setInt(2, 3);
        stmt.addBatch();
        stmt.setInt(1, 3);
        stmt.setInt(2, 4);
        stmt.addBatch();

        // Project 4
        stmt.setInt(1, 4);
        stmt.setInt(2, 1);
        stmt.addBatch();
        stmt.setInt(1, 4);
        stmt.setInt(2, 2);
        stmt.addBatch();
        stmt.setInt(1, 4);
        stmt.setInt(2, 3);
        stmt.addBatch();

        // Project 5
        stmt.setInt(1, 5);
        stmt.setInt(2, 3);
        stmt.addBatch();
        stmt.setInt(1, 5);
        stmt.setInt(2, 4);
        stmt.addBatch();
        stmt.setInt(1, 5);
        stmt.setInt(2, 5);
        stmt.addBatch();

        // Project 6
        stmt.setInt(1, 6);
        stmt.setInt(2, 1);
        stmt.addBatch();
        stmt.setInt(1, 6);
        stmt.setInt(2, 2);
        stmt.addBatch();
        stmt.setInt(1, 6);
        stmt.setInt(2, 4);
        stmt.addBatch();

        // Project 7
        stmt.setInt(1, 7);
        stmt.setInt(2, 1);
        stmt.addBatch();
        stmt.setInt(1, 7);
        stmt.setInt(2, 2);
        stmt.addBatch();
        stmt.setInt(1, 7);
        stmt.setInt(2, 3);
        stmt.addBatch();

        // Project 8
        stmt.setInt(1, 8);
        stmt.setInt(2, 4);
        stmt.addBatch();
        stmt.setInt(1, 8);
        stmt.setInt(2, 5);
        stmt.addBatch();
        stmt.setInt(1, 8);
        stmt.setInt(2, 3);
        stmt.addBatch();

        // Project 9
        stmt.setInt(1, 9);
        stmt.setInt(2, 1);
        stmt.addBatch();
        stmt.setInt(1, 9);
        stmt.setInt(2, 5);
        stmt.addBatch();
        stmt.setInt(1, 9);
        stmt.setInt(2, 4);
        stmt.addBatch();

        // Project 10
        stmt.setInt(1, 10);
        stmt.setInt(2, 1);
        stmt.addBatch();
        stmt.setInt(1, 10);
        stmt.setInt(2, 3);
        stmt.addBatch();
        stmt.setInt(1, 10);
        stmt.setInt(2, 4);
        stmt.addBatch();

        stmt.executeBatch();
    }
}
