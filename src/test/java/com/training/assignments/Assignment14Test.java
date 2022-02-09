package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Assignment14Test {

    @Test
    public void testMovie() {
        Assertions.assertEquals("Doing Directing", new Director().getWork(), "he is not directing");
        Assertions.assertEquals("Doing acting", new Actor().getWork(), "no acting");
    }
}