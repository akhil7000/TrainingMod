package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Assignment15Test {
    String firstName = "Naviya";
    String lastName = "K";
    String middleName = "Dayanand";

    @Test
    void testGetFullName() {
        Assertions.assertEquals("NA", new Assignment15().getFullName(), "Its not full name");
        Assertions.assertEquals("Naviya", new Assignment15().getFullName(firstName), "wrong firstname");
        Assertions.assertEquals("Naviya K", new Assignment15().getFullName(firstName, lastName), "wrong first and last name");
        Assertions.assertEquals("Naviya K Dayanand", new Assignment15().getFullName(firstName, lastName, middleName), "wrong full name");

    }
}