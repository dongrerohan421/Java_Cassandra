package com.cassandra.index;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Create_Index {

	public static void main(String[] args) {
		// Query
		String query = "CREATE INDEX name ON emp (emo_name)";

		// Creating Cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

		// Creating Session object
		Session session = cluster.connect("tp");

		// Executing the query
		session.execute(query);

		// using the KeySpace
		System.out.println("Index created");
	}

}
