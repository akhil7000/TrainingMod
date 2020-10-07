package emipage;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$x;



public class EmiPage {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
String bank_xpath="//table[3]/tbody/tr[%s]/td[1]";
    String tenure_xpath="//table[3]/tbody/tr[%s]/td[2]";
    public EmiPage getBankDetails() throws Exception {
        for (int i = 1; i <= 9; i++) {
            Thread.sleep(4000);
            SelenideElement bank_element = $x(String.format(bank_xpath, i));
            SelenideElement tenure_element = $x(String.format(tenure_xpath, i));
            logger.info("banks======" + bank_element.getText());
            logger.info("tenure"+tenure_element.getText());
//            if (bank_element.getText().equals("SBI")) {
//                logger.info("Bank name:" + bank_element.getText() + "is found");
//                if (tenure_element.getText().equals("No")) {
//                    logger.info(tenure_element.getText() + " no tenure found");
//                }
//            }
//            if (bank_element.getText().equals("HSBC")) {
//                logger.info("Bank name:" + bank_element.getText() + "is found");
//                if (tenure_element.getText().equals("No")) {
//                    logger.info(tenure_element.getText() + " no tenure found");
//                }
//            }
        }
        return this;
    }

}

//table[3]/tbody/tr[7]/td[1]  ---Bank                                                //table[3]/tbody/tr[7]/td[2]---7th no
//table[3]/tbody/tr[7]/td[1]                                                       //table[3]/tbody/tr[9]/td[2]---9th  no