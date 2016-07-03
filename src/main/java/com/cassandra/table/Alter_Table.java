/*
 * Using ALTER command, you can perform the following operations:

    Add a column

    Drop a column

 */
package com.cassandra.table;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Alter_Table {

	public static void main(String[] args) {
		// Query
		String query = "ALTER TABLE emp ADD emp_email text";
		String query1 = "ALTER TABLE emp DROP emp_email";

		// Creating Cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

		// Creating Session object
		Session session = cluster.connect("tp");

		// Executing the query
		session.execute(query);

		// using the KeySpace
		System.out.println("Column added");

		// Executing the query
		session.execute(query1);

		// using the KeySpace
		System.out.println("Column deleted");
	}

}
