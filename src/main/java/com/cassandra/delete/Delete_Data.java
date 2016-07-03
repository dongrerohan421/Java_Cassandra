/*
 * The DELETE statement deletes columns and rows. If column names are provided directly after the DELETE keyword, only those columns are deleted from the row indicated by the <where-clause>. The id[value] syntax in <selection> is for non-frozen collections 
 * (please refer to the collection section for more details). The id.field syntax is for the deletion of non-frozen user-defined types. 
 * Otherwise, whole rows are removed. The <where-clause> specifies which rows are to be deleted. Multiple rows may be deleted with one statement by using an 
 * IN clause. A range of rows may be deleted using an inequality operator (such as >=).

 * DELETE supports the TIMESTAMP option with the same semantics as the UPDATE statement.

 * In a DELETE statement, all deletions within the same partition key are applied atomically and in isolation.

 * A DELETE operation can be conditional through the use of an IF clause, similar to UPDATE and INSERT statements. However, as with INSERT and UPDATE statements,
 *  this will incur a non-negligible performance cost (internally, Paxos will be used) and so should be used sparingly.
 */

package com.cassandra.delete;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Delete_Data {

	public static void main(String[] args) {
		// Query
		String query = "DELETE FROM emp WHERE emp_id = 3;";

		// Creating Cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

		// Creating Session object
		Session session = cluster.connect("tp");

		// Executing the query
		session.execute(query);

		// using the KeySpace
		System.out.println("Data deleted");
	}

}
