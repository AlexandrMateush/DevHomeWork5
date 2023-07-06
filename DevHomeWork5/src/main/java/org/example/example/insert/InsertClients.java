package org.example.example.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertClients {
    public static void insertClients(Connection conn) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO client (ID, NAME) VALUES (?,?);");

        stmt.setInt(1, 1);
        stmt.setString(2, "ABC Company");
        stmt.addBatch();

        stmt.setInt(1, 2);
        stmt.setString(2, "XYZ Corporation");
        stmt.addBatch();

        stmt.setInt(1, 3);
        stmt.setString(2, "FFG Company");
        stmt.addBatch();

        stmt.setInt(1, 4);
        stmt.setString(2, "GHJ Corporation");
        stmt.addBatch();

        stmt.setInt(1, 5);
        stmt.setString(2, "LKI Company");
        stmt.addBatch();

        stmt.executeBatch();
    }
}
