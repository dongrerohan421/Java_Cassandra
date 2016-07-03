package com.cassandra.table;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Drop_Table {

	public static void main(String[] args) {
		// Query
		String query = "DROP TABLE emp";

		// Creating Cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

		// Creating Session object
		Session session = cluster.connect("tp");

		// Executing the query
		session.execute(query);

		// using the KeySpace
		System.out.println("Table dropped");
	}

}
