package assignment;

import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy;
import org.junit.jupiter.api.Test;

public class Assignment1 {
    @Test
    public void main(){
        String a ="Ram";
        String b = "Sam";
        String v = a.replaceAll(a,b);
        System.out.println(v);
    }
}
