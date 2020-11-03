package com.training.assignment.tests;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    public SoftAssertions softAssert;

    @BeforeEach
    public void setUp() {
        softAssert = new SoftAssertions();
    }

    @AfterEach
    public void tearDown() {
        softAssert.assertAll();
    }
}