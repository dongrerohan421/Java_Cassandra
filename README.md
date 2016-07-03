# Java_Cassandra
All basic operations of Cassandra database with Java API

Components of Cassandra:

The key components of Cassandra are as follows −

    Node − It is the place where data is stored.

    Data center − It is a collection of related nodes.

    Cluster − A cluster is a component that contains one or more data centers.

    Commit log − The commit log is a crash-recovery mechanism in Cassandra. Every write operation is written to the commit log.

    Mem-table − A mem-table is a memory-resident data structure. After commit log, the data will be written to the mem-table. Sometimes, for a single-column family, there will be multiple mem-tables.

    SSTable − It is a disk file to which the data is flushed from the mem-table when its contents reach a threshold value.

    Bloom filter − These are nothing but quick, nondeterministic, algorithms for testing whether an element is a member of a set. It is a special kind of cache. Bloom filters are accessed after every query.

Cassandra Query Language:

Users can access Cassandra through its nodes using Cassandra Query Language (CQL). CQL treats the database (Keyspace) as a container of tables. Programmers use cqlsh: a prompt to work with CQL or separate application language drivers.

Clients approach any of the nodes for their read-write operations. That node (coordinator) plays a proxy between the client and the nodes holding the data.

Cluster:

Cassandra database is distributed over several machines that operate together. The outermost container is known as the Cluster. For failure handling, every node contains a replica, and in case of a failure, the replica takes charge. Cassandra arranges the nodes in a cluster, in a ring format, and assigns data to them.
Keyspace

Keyspace is the outermost container for data in Cassandra. The basic attributes of a Keyspace in Cassandra are −

    Replication factor − It is the number of machines in the cluster that will receive copies of the same data.

    Replica placement strategy − It is nothing but the strategy to place replicas in the ring. We have strategies such as simple strategy (rack-aware strategy), old network topology strategy (rack-aware strategy), and network topology strategy (datacenter-shared strategy).

    Column families − Keyspace is a container for a list of one or more column families. A column family, in turn, is a container of a collection of rows. Each row contains ordered columns. Column families represent the structure of your data. Each keyspace has at least one and often many column families.

Column Family:

A column family is a container for an ordered collection of rows. Each row, in turn, is an ordered collection of columns. The following table lists the points that differentiate a column family from a table of relational databases.

A Cassandra column family has the following attributes −

    keys_cached − It represents the number of locations to keep cached per SSTable.

    rows_cached − It represents the number of rows whose entire contents will be cached in memory.

    preload_row_cache − It specifies whether you want to pre-populate the row cache.

Note − Unlike relational tables where a column family’s schema is not fixed, Cassandra does not force individual rows to have all the columns.

Column:

A column is the basic data structure of Cassandra with three values, namely key or column name, value, and a time stamp. Given below is the structure of a column.

SuperColumn:

A super column is a special column, therefore, it is also a key-value pair. But a super column stores a map of sub-columns.

Generally column families are stored on disk in individual files. Therefore, to optimize performance, it is important to keep columns that you are likely to query together in the same column family, and a super column can be helpful here.Given below is the structure of a super column.
