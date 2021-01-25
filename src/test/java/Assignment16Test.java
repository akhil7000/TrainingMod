import com.assignment.Yes1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.assignment.*;

public class Assignment16Test {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testAbstractClass() {
        int integerToSum = 1;
        Yes1 yes1 = new Yes1();
        logger.info(Integer.toString(yes1.sum(integerToSum)));
        Assertions.assertTrue(yes1.sum(integerToSum) == (1 + 1 + 1),
                "Sum is not correct");
    }
}