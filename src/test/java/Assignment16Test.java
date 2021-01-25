import com.assignment.SumMethodClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.assignment.*;

public class Assignment16Test {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testSumUsingAbstract() {
        int integerToSum = 1;
        SumMethodClass sumMethodClass = new SumMethodClass();
        logger.info(Integer.toString(sumMethodClass.getSum(integerToSum)));
        Assertions.assertEquals (sumMethodClass.getSum(integerToSum),3,
                "Sum is not correct");
    }
}