/*
 * SELECT name, occupation FROM users WHERE userid IN (199, 200, 207);

SELECT JSON name, occupation FROM users WHERE userid = 199;

SELECT name AS user_name, occupation AS user_occupation FROM users;

SELECT time, value
FROM events
WHERE event_type = 'myEvent'
  AND time > '2011-02-03'
  AND time <= '2012-01-01'

SELECT COUNT(*) FROM users;

SELECT COUNT(*) AS user_count FROM users;


The SELECT statements reads one or more columns for one or more rows in a table. It returns a result-set of rows, where each row contains the collection of 
columns corresponding to the query. If the JSON keyword is used, the results for each row will contain only a single column named “json”. 
See the section on SELECT JSON for more details.

<select-clause>

The <select-clause> determines which columns needs to be queried and returned in the result-set. It consists of either the comma-separated list of or 
the wildcard character (*) to select all the columns defined for the table.

A <selector> is either a column name to retrieve or a <function> of one or more @@s. The function allowed are the same as for <term> and are described 
in the function section. In addition to these generic functions, the WRITETIME (resp. TTL) function allows to select the timestamp of when the column was 
inserted (resp. the time to live (in seconds) for the column (or null if the column has no expiration set)) and the CAST function can be used to convert one 
data type to another.

Any <selector> can be aliased using AS keyword (see examples). Please note that <where-clause> and <order-by> clause should refer to the columns by their 
original names and not by their aliases.

The COUNT keyword can be used with parenthesis enclosing *. If so, the query will return a single result: the number of rows matching the query. 
Note that COUNT(1) is supported as an alias.

<where-clause>

The <where-clause> specifies which rows must be queried. It is composed of relations on the columns that are part of the PRIMARY KEY and/or have a secondary 
index defined on them.
 */

package com.cassandra.select;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

public class Read_Data {

	public static void main(String[] args) {
		// Query
		String query = "SELECT * FROM emp;";

		// Creating Cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

		// Creating Session object
		Session session = cluster.connect("tp");

		// Getting the ResultSet
		ResultSet resultSet = session.execute(query);

		// using the KeySpace
		System.out.println(resultSet.all());
	}

}
