/*
 * he INSERT statement writes one or more columns for a given row in a table. Note that since a row is identified by its PRIMARY KEY, 
 * at least the columns composing it must be specified. The list of columns to insert to must be supplied when using the VALUES syntax. 
 * When using the JSON syntax, they are optional. See the section on INSERT JSON for more details.

 * Note that unlike in SQL, INSERT does not check the prior existence of the row by default: the row is created if none existed before, 
 * and updated otherwise. Furthermore, there is no mean to know which of creation or update happened.

 * It is however possible to use the IF NOT EXISTS condition to only insert if the row does not exist prior to the insertion. 
 * But please note that using IF NOT EXISTS will incur a non negligible performance cost (internally, Paxos will be used) so this should be used sparingly.

 * All updates for an INSERT are applied atomically and in isolation.

 * Please refer to the UPDATE section for information on the <option> available and to the collections section for use of <collection-literal>. 
 * Also note that INSERT does not support counters, while UPDATE does.
 */

package com.cassandra.insert;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Insert_Data {

	public static void main(String[] args) {
		// Query
		String query1 = "INSERT INTO emp (emp_id, emp_name, emp_city, emp_phone,  emp_sal)"
				+ " VALUES(1,'ram', 'Hyderabad', 9848022338, 50000);";

		String query2 = "INSERT INTO emp (emp_id, emp_name, emp_city, emp_phone, emp_sal)"
				+ " VALUES(2,'robin', 'Hyderabad', 9848022339, 40000);";

		String query3 = "INSERT INTO emp (emp_id, emp_name, emp_city, emp_phone, emp_sal)"
				+ " VALUES(3,'rahman', 'Chennai', 9848022330, 45000);";

		// Creating Cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

		// Creating Session object
		Session session = cluster.connect("tp");

		// Executing the query
		session.execute(query1);
		session.execute(query2);
		session.execute(query3);

		// using the KeySpace
		System.out.println("Data created");
	}

}
