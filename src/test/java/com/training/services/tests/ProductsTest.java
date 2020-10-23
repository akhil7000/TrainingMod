package com.training.services.tests;

import com.training.base.BaseTest;
import com.training.services.products.Response;
import com.training.utilities.RestEngine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductsTest extends BaseTest {
    Map<String, Object> headerMap;
    Map<String, Object> queryParam;
    String baseURL;
    Response response;

    @BeforeEach
    public void setData() {
        baseURL = map.get("url_base") + "/en/royal/mobile/v3/products";

        headerMap = new HashMap();
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));
        headerMap.put(map.get("AppKeyHeader"), map.get("AppKeyValue"));

        queryParam = new HashMap();
        queryParam.put(map.get("shipIdParam"), map.get("sailingIdParamValue"));
        queryParam.put(map.get("categoryParam"), map.get("categoryParamValue"));
    }

    /**
     * Shorex test, checking the response, checking total hits is 52 or not.
     */
    @Test
    public void testShorexTotalHitsValidate() {
        response = new RestEngine().getResponseGet(baseURL, headerMap, queryParam)
                .as(Response.class);

        Assertions.assertThat(response.getStatus()).isEqualTo(200)
                .as("Json response status is not 200");

        softAssert.assertThat(response.getPayload().getSummary().getTotalHits())
                .isEqualTo("52")
                .as("Inside Summary, Total hit is not 52");
    }

    /**
     * Checking if total number of shorex is 52 or not.
     */
    @Test
    public void testShorexProductTypeValidate() {
        response = new RestEngine().getResponseGet(baseURL, headerMap, queryParam)
                .as(Response.class);

        Assertions.assertThat(response.getStatus()).isEqualTo(200)
                .as("Json response status is not 200");

        for (int i = 0; i < response.getPayload().getProducts().size(); i++) {
            softAssert.assertThat(
                    response.getPayload().getProducts().get(i).getProductType().getProductType()
                            .equalsIgnoreCase("SHOREX"))
                    .as("Product id " + response.getPayload().getProducts().get(i).getProductID() + " is not SHOREX")
                    .isTrue();
        }
    }

    /**
     * Checking if offeringDate, day  should be less than or equal to 10 days, from sailing date 20200809
     *
     * @throws ParseException
     */
    @Test
    public void testShorexOfferingDateValidate() throws ParseException {
        response = new RestEngine().getResponseGet(baseURL, headerMap, queryParam)
                .as(Response.class);

        Map<String, Integer> day_Month_daysInMonthFromLink = getDay_Month_daysInMonth(map.get("sailingIdParamValue").split("AL")[1]);

        for (int index = 0; index < response.getPayload().getProducts().size(); index++) {
            for (int getDateOffering = 0; getDateOffering < response.getPayload().getProducts().get(index).getOffering().size(); getDateOffering++) {

                Map<String, Integer> day_Month_daysInMonth = getDay_Month_daysInMonth(response.getPayload().getProducts().get(index).getOffering().get(getDateOffering).getOfferingDate());

                /**
                 * If query paramter link date and offeringDate are from same month
                 */
                if (day_Month_daysInMonthFromLink.get("month") == day_Month_daysInMonth.get("month")) {
                    if (!((day_Month_daysInMonth.get("day") - day_Month_daysInMonthFromLink.get("day")) <= 10)) {
                        softAssert.fail("Product ID = " + response.getPayload().getProducts()
                                .get(index).getOffering().get(getDateOffering)
                                .getProductID() + " offering date is greater than 10 days = "
                                + response.getPayload().getProducts().get(index).getOffering().get(getDateOffering).getOfferingDate());
                    }
                } else {
                    softAssert.assertThat(
                            (day_Month_daysInMonthFromLink.get("daysInMonth") - day_Month_daysInMonthFromLink.get("day")) + day_Month_daysInMonth.get("day") <= 10)
                            .as("Product ID = "
                                    + response.getPayload().getProducts().get(index).getOffering().get(getDateOffering)
                                    .getProductID() + " offeringDate is greater than 10 days = "
                                    + response.getPayload().getProducts().get(index).getOffering().get(getDateOffering)
                                    .getOfferingDate())
                            .isTrue();
                }
            }
        }
    }

    /**
     * Returning segregate day, month and number of days in a month
     *
     * @param actualDateFromResponse
     * @return
     * @throws ParseException
     */
    public Map<String, Integer> getDay_Month_daysInMonth(String actualDateFromResponse) throws ParseException {
        Map<String, Integer> dateMap = new HashMap<>();

        /**
         * actualDateInWholeText =  = Sun Aug 09 00:00:00 IST 2020
         */
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
        Date actualDateWholeText = originalFormat.parse(actualDateFromResponse);

        /**
         * Segregate date = 2020-08-09
         */
        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
        String segregateDate = newFormat.format(actualDateWholeText);
        String dateSplit[] = segregateDate.split("-");
        int getYear = Integer.parseInt(dateSplit[0]);
        int getMonth = Integer.parseInt(dateSplit[1]);
        int getDay = Integer.parseInt(dateSplit[2]);

        /**
         * Number of days in month
         */
        YearMonth yearMonthObject = YearMonth.of(getYear, getMonth);
        int daysInMonth = yearMonthObject.lengthOfMonth();

        dateMap.put("day", getDay);
        dateMap.put("month", getMonth);
        dateMap.put("daysInMonth", daysInMonth);

        return dateMap;
    }
}