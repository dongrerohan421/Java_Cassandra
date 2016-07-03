/*
 * The BATCH statement group multiple modification statements (insertions/updates and deletions) into a single statement. It serves several purposes:

    It saves network round-trips between the client and the server (and sometimes between the server coordinator and the replicas) when batching multiple updates.
    All updates in a BATCH belonging to a given partition key are performed in isolation.
    By default, all operations in the batch are performed as LOGGED, to ensure all mutations eventually complete (or none will). See the notes on UNLOGGED for more details.

Note that:

    BATCH statements may only contain UPDATE, INSERT and DELETE statements.
    Batches are not a full analogue for SQL transactions.
    If a timestamp is not specified for each operation, then all operations will be applied with the same timestamp. Due to Cassandra’s conflict resolution procedure in the case of timestamp ties, operations may be applied in an order that is different from the order they are listed in the BATCH statement. To force a particular operation ordering, you must specify per-operation timestamps.

UNLOGGED

By default, Cassandra uses a batch log to ensure all operations in a batch eventually complete or none will (note however that operations are only isolated within a single partition).

There is a performance penalty for batch atomicity when a batch spans multiple partitions. If you do not want to incur this penalty, you can tell Cassandra to skip the batchlog with the UNLOGGED option. If the UNLOGGED option is used, a failed batch might leave the patch only partly applied.
COUNTER

Use the COUNTER option for batched counter updates. Unlike other updates in Cassandra, counter updates are not idempotent.
<option>

BATCH supports both the TIMESTAMP option, with similar semantic to the one described in the UPDATE statement (the timestamp applies to all the statement inside the batch). However, if used, TIMESTAMP must not be used in the statements within the batch.
 */

package com.cassandra.batch;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Batch {

	public static void main(String[] args) {
		// Query
		String query = "BEGIN BATCH"
				+ "INSERT INTO emp (emp_id,emp_city, emp_name, emp_phone, emp_sal) values (1, 'Irving', 'Alex', 6602542314, 50000);"
				+ "UPDATE emp SET emp_sal = 60000 WHERE emp_id = 1;" + "DELETE emp_city FROM emp WHERE emp_id = 1;"
				+ "APPLY BATCH;";

		// Creating Cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

		// Creating Session object
		Session session = cluster.connect("tp");

		// Executing the query
		session.execute(query);

		// using the KeySpace
		System.out.println("Changes done");
	}

}
