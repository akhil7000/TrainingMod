package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Assignment15Test {
    String firstName="Naviya";
    String lastName="K";
    String middleName="Dayanand";

    @Test
    void testGetFullName() {
        Assertions.assertEquals("NA",new Assignment15().getFullName(),"Its not full name");
    }

    @Test
    void testFirstName() {
        Assertions.assertEquals("Naviya",new Assignment15().getFullName(firstName),"wrong firstname");
    }

    @Test
    void testFirstAndLastName() {
        Assertions.assertEquals("Naviya K",new Assignment15().getFullName(firstName, lastName),"wrong first and last name");
    }

    @Test
    void testFirstLastAndMiddle() {
        Assertions.assertEquals("Naviya K Dayanand",new Assignment15().getFullName(firstName, lastName, middleName),"wrong full name");
    }
}