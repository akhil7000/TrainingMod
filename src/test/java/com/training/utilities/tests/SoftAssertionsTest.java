package com.training.utilities.tests;

import com.training.base.BaseTest;
import org.junit.jupiter.api.Test;

public class SoftAssertionsTest extends BaseTest {
    @Test
    public void sampleTest(){
        softAssert.assertThat(100<30).isTrue();
        softAssert.assertThat(8).isEqualTo(3);
        softAssert.assertThat(Boolean.FALSE).isTrue();
    }
}