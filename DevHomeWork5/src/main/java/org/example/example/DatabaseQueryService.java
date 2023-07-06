package org.example.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<MaxProjectCountClient> findMaxProjectsClient() throws IOException {
        String sqlFile = "sql/find_max_projects_client.sql";
        String sqlInfo = "sql/find_max_projects_client_1.sql";
        List<MaxProjectCountClient> clients = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of(sqlFile));
            String sqlPrepare = Files.readString(Path.of(sqlInfo));
            Database.getInstance();
            Statement statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);


            int max = 0;
            while (resultSet.next()) {
                max = resultSet.getInt(1);
            }
            Database.getInstance();
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(sqlPrepare);
            preparedStatement.setInt(1,max);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int projectCount = resultSet.getInt("projectCount");

                MaxProjectCountClient client = new MaxProjectCountClient(name, projectCount);
                clients.add(client);
                System.out.println("Name: " + name + ", Project count: " + projectCount);
            }
            return clients;


        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<LongestProjectDuration> findLongestProjectDuration() throws IOException {
        String sqlFile = "sql/find_longest_project.sql";
        String sqlInfo = "sql/find_longest_project_1.sql";
        List<LongestProjectDuration> clients = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of(sqlFile));
            String sqlPrepare = Files.readString(Path.of(sqlInfo));
            Database.getInstance();
            Statement statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);


            int count = 0;
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            Database.getInstance();
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(sqlPrepare);
            preparedStatement.setInt(1,count);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("ID");
                int projectDuration  = resultSet.getInt("TIMESTAMPDIF");

                LongestProjectDuration client = new LongestProjectDuration(name, projectDuration);
                clients.add(client);
                System.out.println("Project: " + name + ", Project Duration: " + projectDuration);
            }
            return clients;
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<MaxSalaryWorker> findMaxSalaryWorkers() {
        String sqlFile = "sql/find_max_salary_worker.sql";
        String sqlInfo = "sql/find_max_salary_worker_1.sql";
        List<MaxSalaryWorker> workers = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of(sqlFile));
            String sqlPrepare = Files.readString(Path.of(sqlInfo));
            Database.getInstance();
            Statement statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);


            int count = 0;
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            Database.getInstance();
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(sqlPrepare);
            preparedStatement.setInt(1,count);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int salary  = resultSet.getInt("SALARY");

                MaxSalaryWorker worker = new MaxSalaryWorker(name, salary);
                workers.add(worker);
                System.out.println("Worker: " + name + ", Worker salary: " + salary);
            }
            return workers;
        } catch (SQLException | IOException e) {
            System.out.println("Error executing query: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<YoungestEldestWorker> findYoungestEldestWorkers() {
        String sqlFile = "sql/find_youngest_eldest_workers.sql";
        String sqlInfo = "sql/find_youngest_eldest_workers_1.sql";
        List<YoungestEldestWorker> workers = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of(sqlFile));
            String sqlPrepare = Files.readString(Path.of(sqlInfo));
            Database.getInstance();
            Statement statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            String birthday1 = "";
            String birthday2 = "";

            while (resultSet.next()) {
                birthday1 = resultSet.getString(1);
                birthday2 = resultSet.getString(2);

            }
            Database.getInstance();
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(sqlPrepare);
            preparedStatement.setString(1,birthday1);
            preparedStatement.setString(2,birthday2);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                String workerType = resultSet.getNString("TYPE");
                String workerName = resultSet.getString("NAME");
                String workerBirthday = resultSet.getString("BIRTHDAY");

                YoungestEldestWorker worker = new YoungestEldestWorker(workerType, workerName,workerBirthday);
                workers.add(worker);
            }
            return workers;
        } catch (SQLException | IOException e) {
            System.out.println("Error executing query: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<ProjectPrice> printProjectPrices(String id) {
        String sqlFile = "sql/print_project_prices.sql";
        String sqlInfo = "sql/print_project_prices_1.sql";
        List<ProjectPrice> projectPrices = new ArrayList<>();


        try {
            String sql = Files.readString(Path.of(sqlFile));
            String sqlPrepare = Files.readString(Path.of(sqlInfo));
            Database.getInstance();
            Statement statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            int price = 0;


            while (resultSet.next()) {
                price = resultSet.getInt(1);
            }
            Database.getInstance();
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(sqlPrepare);
            preparedStatement.setInt(1,price);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                String projectId = resultSet.getString("ID");
                int projectP = resultSet.getInt("PRICE");

                ProjectPrice worker = new ProjectPrice(projectId, projectP);
                projectPrices.add(worker);
            }
            return projectPrices;
        } catch (SQLException | IOException e) {
            System.out.println("Error executing query: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}
