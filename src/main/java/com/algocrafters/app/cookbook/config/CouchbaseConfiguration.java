package com.algocrafters.app.cookbook.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

/**
 * The Couchbase database configuration facility.
 *
 * @since 0.1
 *
 * @author Vitali Tchalov (github.com/VitaliTch)
 * @author {name}
 */
@Configuration
@EnableCouchbaseRepositories("com.algocrafters.app.cookbook.store.couchbase.repository")
//@EnableCouchbaseAuditing // TODO: add auditing fields into a base class
public class CouchbaseConfiguration { // extends AbstractCouchbaseConfiguration {

}
