package com.cassandra.keyspace;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Create_Keyspace {

	public static void main(String[] args) {

		// Query
		String query = "CREATE KEYSPACE tp WITH REPLICATION" + "= {'class':'SimpleStrategy', 'replication_factor':1};";

		// Creating Cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

		// Creating Session object
		Session session = cluster.connect();

		// Executing the query
		session.execute(query);

		// using the KeySpace
		session.execute("USE tp");
		System.out.println("Keyspace created");
	}

}
