package com.training.assignment.tests;

import com.training.assignments.Assignment;
import com.training.assignments.Operations;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AssignmentTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    Assignment assignment=new Assignment();
    Operations operation=new Operations();

    @Test
    public void  testDataConversion(){
        logger.info("double from int->"+assignment.getDoubleFromInt(55));
        logger.info("int from double->"+assignment.getIntFromDouble(55.0));
        logger.info("float from double->"+assignment.getFloatFromDouble(55.0555558888888888888));
        logger.info("double from float->"+assignment.getDoubleFromFloat((float)55.00589001231313450));
        logger.info("byte from long->"+assignment.getByteFromLong(11005987L));
        logger.info("long from byte->"+assignment.getLongFromByte((byte)32));
    }

    @Test
    public void testOperationString(){
        char[] character = assignment.getCharacterFromString("rccl");
        for(char afterIteratecharacters:character){
            logger.info("converted String to character-->"+afterIteratecharacters);
        }
        logger.info("converted ram to sam-->"+assignment.getReplacedString("Ram","Ram","Sam"));
        logger.info("converted Tendulkar to Masterrrr-->"+
                assignment.getReplacedString("Sachin Tendulkar","Tendulkar","Masterrrr"));
        logger.info("converted ram to sam-->"+
                assignment.getReplacedString("Dell","Dell","Depp"));
        logger.info("index of X is-->"+assignment.getIndexOf("Xioami",'X'));
        logger.info("index of a is-->"+assignment.getIndexOf("Xioami",'a'));
        logger.info("index of o is-->"+assignment.getIndexOf("Xioami",'o'));
        logger.info("after using subString name-->"+
                assignment.getNameUsingSubString("Indian Oil Corporation Ltd",11,22));
        logger.info("index value-->"+assignment.getIndex(new String[]{"Paulo Dybala", "Federico", "Gianluigi", "Ronaldo", "Messi"},"Ronaldo"));
    }

    @Test
    public void testOperationWithLoops() {
     operation.printCompanyReviews();
//     operation.conditionCheckUsingIf("Bad");
//     operation.printNumbers();
//     operation.printEvenNumbers();
//     operation.printUsingForEach();
    }
}