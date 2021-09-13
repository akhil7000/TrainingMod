package com.training.sample.tests;

import com.training.sample.pages.Assignment5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Assignment5Test {
    Assignment5 assignment5 = new Assignment5();

    @Test
    public void testGetStringIndex() {
        try {
            Assertions.assertEquals(
                    2,
                    assignment5.getStringIndex(
                            (new String[] {
                                "Paulo Dybala", "Federico", "Gianluigi", "Ronaldo", "Messi"
                            }),
                            "Rot"));
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }
}
