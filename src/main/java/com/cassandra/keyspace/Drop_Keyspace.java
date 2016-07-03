package com.cassandra.keyspace;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Drop_Keyspace {

	public static void main(String[] args) {
		// Query
		String query = "DROP KEYSPACE tp;";

		// Creating Cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

		// Creating Session object
		Session session = cluster.connect();

		// Executing the query
		session.execute(query);

		// using the KeySpace
		System.out.println("Keyspace deleted");
	}

}
