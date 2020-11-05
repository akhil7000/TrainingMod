package com.training.assignment.tests;

import com.training.assignments.Assignment;
import com.training.assignments.Operations;
import com.training.assignments.abstraction.Yes1;
import com.training.assignments.inheritance.ParentChild;
import com.training.assignments.oopsinterface.Yes2;
import com.training.assignments.polymorphism.overloading.Employee;
import com.training.assignments.polymorphism.overriding.Director;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssignmentTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Assignment assignment = new Assignment();
    private Operations operation = new Operations();

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
        softAssert.assertThat(operation.getCompanyReviews("Google")).
                as("Review of google is not matching with best platform where u will get solution for everything, check other description too.")
                .isEqualTo("Best platform where u will get solution for everything");

        softAssert.assertThat(operation.getCompanysFeedback("Thermolab")).
                as("Company Feedback not matching with good company for production of stabilizers and incubator,check other description too.")
                .isEqualTo("good company for production of stabilizers and incubator");

        softAssert.assertThat(operation.getBehaviour("good"))
                .as("Wrong decision as behaviour contradicts").isEqualTo("go to heaven");

        softAssert.assertThat(operation.getPlaceBehaviourBased("Bad"))
                .as("Wrong place assigned as behaviour contradicts").isEqualTo("go to hell");

        softAssert.assertThat(operation.getPlaceBehaviourBased("good"))
                .as("Wrong place assigned as behaviour contradicts").isEqualTo("go to heaven");

        softAssert.assertThat(operation.getMiddleNumber(500))
                .as("Incorrect Middle number").isEqualTo(250);

        for (int evenNumber : operation.getEvenNumbers(1, 100)) {
            softAssert.assertThat(evenNumber % 2 == 0)
                    .as("Number is not an even number-->" + evenNumber).isTrue();
        }

        for (int oddNumber : operation.getOddNumbers(1, 10)) {
            softAssert.assertThat((oddNumber % 2) != 0)
                    .as("Number is not an odd number-->" + oddNumber).isTrue();
        }
    }

    @Test
    public void testOopsConcept() {
        ParentChild parentChild=new ParentChild();
        Director director = new Director();

        List<String> sportsList = new ArrayList<>(Arrays.asList("Cricket", "Khokho", "Kabaddi", "Batminton", "Hockey", "Football"));

        softAssert.assertThat(operation.getSportsName(sportsList, "Batminton"))
                .as("List should not contains Batminton")
                .isEqualTo(Arrays.asList("Cricket", "Khokho", "Kabaddi", "Hockey", "Football"));

        softAssert.assertThat(parentChild.getName())
                .as("Full name  of parent child is incorrect").isEqualTo("MIKE TYSON");

        softAssert.assertThat(director.getWorkDetail())
                .as("Work of actor and director differs").isEqualTo("Acting Directing");
    }

    @Test
    public void testAbstractInterfaceConcept() {
        Employee employee = new Employee();
        Yes1 yes1 = new Yes1();
        Yes2 yes2 = new Yes2();

        softAssert.assertThat(employee.getName("Shrikant"))
                .as("Employee name doesn't match,try something else").isEqualTo("Shrikant");

        softAssert.assertThat(employee.getName("Shrikant", "Sajjanshetti"))
                .as("Employee name doesnt match,try something else").isEqualTo("Shrikant Sajjanshetti");

        softAssert.assertThat(employee.getName("Shrikant", "Sajjanshetti", "Umakant"))
                .as("Employee name doesnt match,try something else").isEqualTo("Shrikant Sajjanshetti Umakant");

        softAssert.assertThat(yes1.getSum(3))
                .as("Sum of three number is incorrect").isEqualTo(33);

        softAssert.assertThat(yes2.getSum(5))
                .as("Sum of three number is incorrect").isEqualTo(35);
    }
}