package org.assignement.one;
import java.sql.*;

public class DBClass {

    public static void main(String[] args) throws SQLException {
        System.out.println("*********Lets connect to database***********");
        Connection connect= null;
        Statement statement;
        String DB_URL = "jdbc:mysql://localhost/student";
        String DB_USER= "root";
        String DB_PASSWORD= "admin";
        String DB_Driver= "com.mysql.jdbc.Driver";

        try {
            Class.forName(DB_Driver).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connect= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD );
        statement= connect.createStatement();
        //Query 1: show the entire student_details table
        String query1 ="SELECT * FROM student_details";
        ResultSet result1=  statement.executeQuery(query1);

        while(result1.next()==true) {
            System.out.print(result1.getString(1)+ " ");
            System.out.print(result1.getString(2)+ " ");
            System.out.print(result1.getString(3)+ " ");
            System.out.print(result1.getString(4)+ " ");
            System.out.print(result1.getString(5)+ " ");

        System.out.println();
        }
        //Query 2: find all students whose name start with A

        String query2= "SELECT * FROM student_details WHERE Name like 'A%'";
        ResultSet result2 = statement.executeQuery(query2);

        while(result2.next()){
            System.out.print(result2.getString(1)+ " ");
            System.out.print(result2.getString(2)+ " ");
            System.out.println();
        }
        statement.close();
        connect.close();
    }
}
