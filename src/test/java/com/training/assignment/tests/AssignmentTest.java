package com.training.assignment.tests;

import com.training.assignments.Assignment;
import com.training.assignments.Operations;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AssignmentTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    Assignment assignment = new Assignment();
    Operations operation = new Operations();

    @Test
    public void testDataConversion() {
        logger.info("double from int->" + assignment.getDoubleFromInt(55));
        softAssert.assertThat(assignment.getDoubleFromInt(55))
                .as("int number not converted to double").isEqualTo(55.0);

        logger.info("int from double->" + assignment.getIntFromDouble(55.0));
        softAssert.assertThat(assignment.getIntFromDouble(55.0))
                .as("double number not converted to int").isEqualTo(55);

        logger.info("float from double->" + assignment.getFloatFromDouble(55.0555558888888888888));
        softAssert.assertThat(assignment.getFloatFromDouble(55.0555558888888888888))
                .as("double number not converted to float").isEqualTo(55.055557f);

        logger.info("double from float->" + assignment.getDoubleFromFloat((float) 55.00589001231313450));
        softAssert.assertThat(assignment.getDoubleFromFloat((float) 55.00589001231313450))
                .as("float number not converted to double").isEqualTo(55.005889892578125);

        logger.info("byte from long->" + assignment.getByteFromLong(11005987L));
        softAssert.assertThat(assignment.getByteFromLong(11005987L))
                .as("long number not converted to byte").isEqualTo((byte) 35);

        logger.info("long from byte->" + assignment.getLongFromByte((byte) 32));
        softAssert.assertThat(assignment.getLongFromByte((byte) 32))
                .as("byte number not converted to long").isEqualTo(32);
    }

    @Test
    public void testOperationString() {
        for (char characters : assignment.getCharacterFromString("rccl")) {
            logger.info("converted in character format-->" + characters);
        }

        softAssert.assertThat(assignment.getCharacterFromString("rccl"))
                .as("doesn't contains r,c,c,l characters").contains('r', 'c', 'c', 'l');

        logger.info("converted Ram to Sam-->" + assignment.getReplacedString("Ram", "Ram", "Sam"));
        softAssert.assertThat(assignment.getReplacedString("Ram", "Ram", "Sam"))
                .as("is not equal to Sam").isEqualTo("Sam");

        logger.info("converted Tendulkar to Masterrrr-->" +
                assignment.getReplacedString("Sachin Tendulkar", "Tendulkar", "Masterrrr"));
        softAssert.assertThat(assignment.getReplacedString("Sachin Tendulkar", "Tendulkar", "Masterrrr"))
                .as("is not equal to Sachin Masterrrr").isEqualTo("Sachin Masterrrr");

        logger.info("converted Dell to Depp-->" +
                assignment.getReplacedString("Dell", "Dell", "Depp"));
        softAssert.assertThat(assignment.getReplacedString("Dell", "Dell", "Depp"))
                .as("String not Replaced to Depp").isEqualTo("Depp");

        logger.info("index of X is-->" + assignment.getIndexOf("Xioami", 'X'));
        softAssert.assertThat(assignment.getIndexOf("Xioami", 'X'))
                .as("index not correct").isEqualTo(0);

        logger.info("index of a is-->" + assignment.getIndexOf("Xioami", 'a'));
        softAssert.assertThat(assignment.getIndexOf("Xioami", 'a'))
                .as("index not correct").isEqualTo(3);

        logger.info("index of o is-->" + assignment.getIndexOf("Xioami", 'o'));
        softAssert.assertThat(assignment.getIndexOf("Xioami", 'o'))
                .as("index not correct").isEqualTo(2);

        logger.info("after using subString name-->" +
                assignment.getNameUsingSubString("Indian Oil Corporation Ltd", 11, 22));
        softAssert.assertThat(assignment.getNameUsingSubString("Indian Oil Corporation Ltd", 11, 22))
                .as("String not found").isEqualTo("Corporation");

        logger.info("index value-->" + assignment.getIndex(new String[]{"Paulo Dybala", "Federico", "Gianluigi", "Ronaldo", "Messi"}, "Ronaldo"));
        softAssert.assertThat(assignment.getIndex(new String[]{"Paulo Dybala", "Federico", "Gianluigi", "Ronaldo", "Messi"}, "Ronaldo"))
                .as("Ronaldo string not found in list").isEqualTo(3);
    }

    @Test
    public void testOperationWithLoops() {
        softAssert.assertThat(operation.printCompanyReviews("Google")).
                as("review not found").isEqualTo("Best platform where u will get solution for everything");

        softAssert.assertThat(operation.conditionCheckUsingIf("Very Bad"))
                .as("wrong decision").isEqualTo("go to hell");

        logger.info("Middle number of 500 is-->"+operation.getMiddleNumber(500));
        softAssert.assertThat(operation.getMiddleNumber(500))
                .as("not a middle number").isEqualTo(250);

        for(int evenNumbers: operation.getEvenNumbers(1)){
          if(!(evenNumbers%2==0)){
              softAssert.fail("Not even number"+evenNumbers);
          }
        }

        for (int oddNumbers : operation.printOddNumbers(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})) {
            logger.info(oddNumbers + " ");
            softAssert.assertThat(operation.printOddNumbers(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}))
                    .as("not an odd number").isEqualTo(new int[]{1, 3, 5, 7, 9});
        }
    }

    @Test
    public void testOopsOperations(){

    }
}