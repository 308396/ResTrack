
package com.group7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResearchData {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "eddy";
        String password = "";

        String sql = "SELECT rp.research_id, " +
                "rp.research_title, " +
                "gt.grant_type_name, " +
                "r.researcher_name, " +
                "rp.research_status, " +
                "rp.start_date, " +
                "rp.expected_date, " +
                "rp.end_date " +
                "FROM research_projects rp " +
                "JOIN grant_types gt " +
                "ON rp.grant_type_id = gt.grant_type_id " +
                "JOIN researchers r " +
                "ON rp.staff_no = r.staff_no " +
                "ORDER BY rp.research_id";

        try (
                Connection conn = DriverManager.getConnection(
                        url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {

            System.out.println("==============================================");
            System.out.println("         RESEARCH PROJECT RECORDS");
            System.out.println("==============================================");

            while (rs.next()) {

                System.out.println("\n----------------------------------------------");
                System.out.println("Research ID    : " + rs.getInt("research_id"));

                System.out.println("Research Title : " + rs.getString("research_title"));

                System.out.println("Grant Type     : " + rs.getString("grant_type_name"));

                System.out.println("Researcher     : " + rs.getString("researcher_name"));

                System.out.println("Status         : " + rs.getString("research_status"));

                System.out.println("Start Date     : " + rs.getDate("start_date"));

                System.out.println("Expected Date  : " + rs.getDate("expected_date"));

                System.out.println("End Date       : " + rs.getDate("end_date"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
