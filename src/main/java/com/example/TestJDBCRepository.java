package com.example;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.time.Instant;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface TestJDBCRepository extends CrudRepository<TestEntity, Long> {

    @Query(value = "select now()" ,nativeQuery = true)
    Instant getTime();
}
