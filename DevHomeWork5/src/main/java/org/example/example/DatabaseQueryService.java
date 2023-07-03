package org.example.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<MaxProjectCountClient> findMaxProjectsClient(String name,int projectCount) {
        String sqlFile = "sql/find_max_projects_client.sql+(?,?)";
        String sqlContent = readFileContent(sqlFile);

        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlContent)){
                 stmt.setString(1,name);
                 stmt.setInt(2,projectCount);

                 try(ResultSet rs = stmt.executeQuery()) {

            List<MaxProjectCountClient> clients = new ArrayList<>();

            while (rs.next()) {
                String n = rs.getString("name");
                int pC = rs.getInt("projectCount");
                MaxProjectCountClient client = new MaxProjectCountClient(n, pC);
                clients.add(client);
            }

            return clients;
        }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<LongestProjectDuration> findLongestProjectDuration(String id,int duration) {
        String sqlFile = "sql/find_longest_project.sql+(?,?)";
        String sqlContent = readFileContent(sqlFile);

        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlContent)){
                 stmt.setString(1,id);
                 stmt.setInt(2,duration);

                 try(ResultSet rs = stmt.executeQuery()) {

                     List<LongestProjectDuration> clients = new ArrayList<>();

                     while (rs.next()) {
                         String name = rs.getString("ID");
                         int dur = rs.getInt("TIMESTAMPDIFF");
                         LongestProjectDuration client = new LongestProjectDuration(name, dur);
                         clients.add(client);
                     }

                     return clients;
                 }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<MaxSalaryWorker> findMaxSalaryWorkers(int salary, String name) {
        String sqlFile = "sql/find_max_salary_worker.sql +(?,?)";
        String sqlContent = readFileContent(sqlFile);

        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlContent)) {

            pstmt.setInt(1, salary);
            pstmt.setString(2, name);

            try (ResultSet rs = pstmt.executeQuery()) {
                List<MaxSalaryWorker> workers = new ArrayList<>();

                while (rs.next()) {
                    String workerName = rs.getString("NAME");
                    int sal = rs.getInt("SALARY");
                    MaxSalaryWorker worker = new MaxSalaryWorker(workerName, sal);
                    workers.add(worker);
                }

                return workers;
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<YoungestEldestWorker> findYoungestEldestWorkers(String type, String name, String birthday) {
        String sqlFile = "sql/find_youngest_eldest_workers.sql+(?,?,?)";
        String sqlContent = readFileContent(sqlFile);

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sqlContent)) {

            pstmt.setString(1, type);
            pstmt.setString(2, name);
            pstmt.setString(3, birthday);

            try (ResultSet rs = pstmt.executeQuery()) {
                List<YoungestEldestWorker> workers = new ArrayList<>();

                while (rs.next()) {
                    String workerType = rs.getNString("TYPE");
                    String workerName = rs.getString("NAME");
                    String workerBirthday = rs.getString("BIRTHDAY");

                    YoungestEldestWorker worker = new YoungestEldestWorker(workerType, workerName, workerBirthday);
                    workers.add(worker);
                }

                return workers;
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<ProjectPrice> printProjectPrices(String id, int price) {
        String sqlFile = "sql/print_project_prices.sql +(?,?)";
        String sqlContent = readFileContent(sqlFile);

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sqlContent)) {

            pstmt.setString(1, id);
            pstmt.setInt(2, price);

            try (ResultSet rs = pstmt.executeQuery()) {
                List<ProjectPrice> projectPrices = new ArrayList<>();

                while (rs.next()) {
                    String projectId = rs.getString("ID");
                    int projectP = rs.getInt("PRICE");

                    ProjectPrice projectPrice = new ProjectPrice(projectId, projectP);
                    projectPrices.add(projectPrice);
                }

                return projectPrices;
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
            return new ArrayList<>();
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
