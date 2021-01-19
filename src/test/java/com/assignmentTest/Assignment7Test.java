package com.assignmentTest;
import com.assignment.Assignment7;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment7Test {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test

    public void will_go_to_heaven_or_hell(){
    Assignment7 assignment7 =new Assignment7();
    logger.info(assignment7.return_where_user_will_Go("very good"));
    Assertions.assertEquals(assignment7.return_where_user_will_Go("very good"),"Go to heaven with dogs","Please enter proper parameters");
    }
}
