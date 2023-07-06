package org.example.example;


import java.sql.Connection;
import java.sql.SQLException;

import static org.example.example.insert.InsertClients.insertClients;
import static org.example.example.insert.InsertProjectWorkers.insertProjectWorkers;
import static org.example.example.insert.InsertProjects.insertProjects;
import static org.example.example.insert.ІnsertWorkers.insertWorkers;

public class DatabasePopulateService {
    public static void main(String[] args) {

        try (Connection conn = Database.getConnection()) {

            insertWorkers(conn);

            insertClients(conn);

            insertProjects(conn);

            insertProjectWorkers(conn);

            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting data: " + e.getMessage());
        }
    }
}


