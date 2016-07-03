/*
 * The UPDATE statement writes one or more columns for a given row in a table. The <where-clause> is used to select the row to update and must include all 
 * columns composing the PRIMARY KEY. Other columns values are specified through <assignment> after the SET keyword.

Note that unlike in SQL, UPDATE does not check the prior existence of the row by default (except through the use of <condition>, see below): 
the row is created if none existed before, and updated otherwise. Furthermore, there are no means to know whether a creation or update occurred.

It is however possible to use the conditions on some columns through IF, in which case the row will not be updated unless the conditions are met. 
But, please note that using IF conditions will incur a non-negligible performance cost (internally, Paxos will be used) so this should be used sparingly.

In an UPDATE statement, all updates within the same partition key are applied atomically and in isolation.

The c = c + 3 form of <assignment> is used to increment/decrement counters. 
The identifier after the ‘=’ sign must be the same than the one before the ‘=’ sign (Only increment/decrement is supported on counters, not the assignment 
of a specific value).

The id = id + <collection-literal> and id[value1] = value2 forms of <assignment> are for collections. Please refer to the relevant section for more details.

The id.field = <term> form of <assignemt> is for setting the value of a single field on a non-frozen user-defined types.
<options>

The UPDATE and INSERT statements support the following options:

    TIMESTAMP: sets the timestamp for the operation. If not specified, the coordinator will use the current time (in microseconds) at the start of 
    statement execution as the timestamp. This is usually a suitable default.
    
    TTL: specifies an optional Time To Live (in seconds) for the inserted values. If set, the inserted values are automatically removed from the 
    database after the specified time. Note that the TTL concerns the inserted values, not the columns themselves. This means that any subsequent update of 
    the column will also reset the TTL (to whatever TTL is specified in that update). By default, values never expire. A TTL of 0 is equivalent to no TTL. 
    If the table has a default_time_to_live, a TTL of 0 will remove the TTL for the inserted or updated values.
 */

package com.cassandra.update;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Update_Data {

	public static void main(String[] args) {
		// Query
		String query = "UPDATE emp SET emp_city = 'Delhi', emp_sal = 50000" + " WHERE emp_id = 1;";

		// Creating Cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

		// Creating Session object
		Session session = cluster.connect("tp");

		// Executing the query
		session.execute(query);

		// using the KeySpace
		System.out.println("Data updated");
	}

}
