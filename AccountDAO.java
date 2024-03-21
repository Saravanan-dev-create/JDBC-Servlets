package com.saara.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * This demo explains JDBC connection with Postgres SQL Database.
 */
public class AccountDAO {

	public static void main(String[] args) {
		/*
		 * URL: jdbc:postgresql://localhost:5432/account
		 * Username: postgres
		 * Password: root
		 * 
		 * 1. Establish the connection using JDBC Driver Manager
		 * 2. Create Statement
		 * 3. Execute statement - executeUpdate / executeQuery
		 */
		try (
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Account", "postgres", "root");
				Statement createStatement = connection.createStatement();
				ResultSet resultSet = createStatement.executeQuery("select * from account");
        ) {

//			int result = createStatement.executeUpdate("insert into account values(101455, 'Vanmathi', 'Sathyamoorthy', 15000)");
//			int result = createStatement.executeUpdate("update account set balance = 50000 where lastname = 'Sathyamoorthy'");
//			int result = createStatement.executeUpdate("delete from account where lastname = 'Sathyamoorthy'");

			while (resultSet.next()) {
				System.out.println("Account First Name: " + resultSet.getString(2));
				System.out.println("Account Last Name: " + resultSet.getString(3));
				System.out.println("Account Balance: " + resultSet.getString(4));
				System.out.println();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
