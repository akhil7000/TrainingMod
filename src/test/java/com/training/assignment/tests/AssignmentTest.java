package com.training.assignment.tests;

import com.training.assignments.Assignment;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AssignmentTest extends BaseTest{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    Assignment assignment = new Assignment();

    @Test
    public void testDataConversion() {
        logger.info("double from int->" + assignment.getDoubleFromInt(55));
        softAssert.assertThat(assignment.getDoubleFromInt(55)).isEqualTo(55.0)
                .as("int number not converted to double");
        logger.info("int from double->" + assignment.getIntFromDouble(55.0));
       softAssert.assertThat(assignment.getIntFromDouble(55.0)).isEqualTo(55)
                .as("double number not converted to int");
        logger.info("float from double->" + assignment.getFloatFromDouble(55.0555558888888888888));
        softAssert.assertThat(assignment.getFloatFromDouble(55.0555558888888888888)).isEqualTo(55.055557f)
                .as("double number not converted to float");
        logger.info("double from float->" + assignment.getDoubleFromFloat((float) 55.00589001231313450));
        softAssert.assertThat(assignment.getDoubleFromFloat((float) 55.00589001231313450)).isEqualTo(55.005889892578125)
                .as("float number not converted to double");
        logger.info("byte from long->" + assignment.getByteFromLong(11005987L));
        softAssert.assertThat(assignment.getByteFromLong(11005987L)).isEqualTo(35(Byte@23))
                .as("long number not converted to byte");
        logger.info("long from byte->" + assignment.getLongFromByte((byte) 32));
        softAssert.assertThat(assignment.getLongFromByte((byte) 32)).isEqualTo(32)
                .as("byte number not converted to long");
    }

    @Test
    public void testOperationString() {
        char[] getcharacter = assignment.getCharacterFromString("rccl");
        for (char characters : getcharacter) {
            logger.info("converted in character format-->" + characters);
        }
        softAssert.assertThat(assignment.getCharacterFromString("rccl")).contains('q','p','y','z')
                .as("doesn't contains r,c,c,l characters");
        logger.info("converted ram to sam-->" +
                assignment.getReplacedString("Ram", "Ram", "Sam"));
        logger.info("converted Tendulkar to Masterrrr-->" +
                assignment.getReplacedString("Sachin Tendulkar", "Tendulkar", "Masterrrr"));
        logger.info("converted ram to sam-->" +
                assignment.getReplacedString("Dell", "Dell", "Depp"));
        logger.info("index of X is-->" + assignment.getIndexOf("Xioami", 'X'));
        logger.info("index of a is-->" + assignment.getIndexOf("Xioami", 'a'));
        logger.info("index of o is-->" + assignment.getIndexOf("Xioami", 'o'));
        logger.info("after using subString name-->" +
                assignment.getNameUsingSubString("Indian Oil Corporation Ltd", 11, 22));
        logger.info("index value-->" + assignment.
                getIndex(new String[]{"Paulo Dybala", "Federico", "Gianluigi", "Ronaldo", "Messi"}, "Ronaldo"));
    }
}