package com.example;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import java.time.Instant;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

@MicronautTest
class TestcontainersBugTest {
    @Inject
    TestRepository testRepository;

    @Inject
    TestJDBCRepository testJDBCRepository;

    @Test
    void testTime() throws InterruptedException {
        var time = testRepository.getTime();
        Thread.sleep(100);

        var time2 = testRepository.getTime();
        Thread.sleep(100);

        var time3 = testJDBCRepository.getTime();
        assertAll(
                () -> Assertions.assertNotEquals(time, time2),
                () -> Assertions.assertNotEquals(time2, time3)
        );

    }
}
