package com.example;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.time.Instant;

@Repository
public interface TestRepository extends CrudRepository<TestEntity, Long> {

    @Query(value = "select now()" ,nativeQuery = true)
    Instant getTime();
}
