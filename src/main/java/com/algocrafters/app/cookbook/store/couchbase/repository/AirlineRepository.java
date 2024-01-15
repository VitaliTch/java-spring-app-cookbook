package com.algocrafters.app.cookbook.store.couchbase.repository;

import com.algocrafters.store.couchbase.entity.travel.Airline;
import com.couchbase.client.java.query.QueryScanConsistency;
import org.springframework.data.couchbase.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Provides data access methods to the sample Travel bucket in Couchbase Sever.
 *
 * @author Vitali Tchalov (<a href="https://github.com/VitaliTch">VitaliTch</a>)
 * @since 0.1
 */
@Repository("airlineRepository")
@Scope("inventory")
@Collection("airline")
@ScanConsistency(query = QueryScanConsistency.NOT_BOUNDED)
public interface AirlineRepository extends CouchbaseRepository<Airline, String> {
}
