package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Assignment7Test {
    Assignment7 assignment7 = new Assignment7();

    @Test
    void testNatureIsGood() {
        Assertions.assertEquals("Good people should go to heaven", assignment7.getNature("Good"));
    }

    @Test
    void testNatureIsVeryGood() {
        Assertions.assertEquals("Very good people should go to heaven with dogs", assignment7.getNature("Very good"));
    }

    @Test
    void testNatureIsBad() {
        Assertions.assertEquals("bad people should go to hell", assignment7.getNature("Bad people"));
    }

    @Test
    void testNatureIsVeryBad() {
        Assertions.assertEquals("Very bad people should go to hell with cats", assignment7.getNature("Very bad people"));
    }

    @Test
    void invalidOptionShouldReturnRuntimeException() {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            assignment7.getNature("invalid option");
        });

    }
}