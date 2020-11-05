package com.training.assignments;

import java.util.HashMap;
import java.util.List;

public class Operations {

    public String getCompanyReviews(String companyName) {
        HashMap<String, String> company = new HashMap<>();

        company.put("Endee engineers", "good company for production of portable and online instrument of gas analyzer");
        company.put("Aaion automation", "installation of GPS tracker");
        company.put("Thermolab", "good company for production of stabilizers and incubator");
        company.put("Shreeji solution and services", "provide solutions of fire alarm system");
        company.put("Google", "Best platform where u will get solution for everything");

        return company.get(companyName);
    }

    public String getCompanysFeedback(String company) {
        switch (company) {
            case "Endee engineers":
                return "good company for production of portable and online instrument of gas analyzer";

            case "Aaion automation":
                return "installation of GPS tracker";

            case "Thermolab":
                return "good company for production of stabilizers and incubator";

            case "Shreeji solution and services":
                return "provide solutions of fire alarm system";

            case "Google":
                return "Best platform where u will get solution for everything";

            default:
                return "All companies are good";
        }
    }

    public String getBehaviour(String people) {
        HashMap<String, String> behaviour = new HashMap();

        behaviour.put("good", "go to heaven");
        behaviour.put("very good", "go to heaven with dog");
        behaviour.put("Bad", "go to hell");
        behaviour.put("Very Bad", "go to hell");

        return behaviour.get(people);
    }

    public String getPlaceBehaviourBased(String people) {
        if (people.equals("good")){
            return "go to heaven";
        } else if (people.equals("very good")) {
            return "go to heaven with dog";
        } else if (people.equals("Bad")) {
            return "go to hell";
        } else if (people.equals("Very Bad")) {
            return "go to hell";
        }
        return "";
    }

    public int getMiddleNumber(int number) {
        for (int index = 1; index < number; index++) {
            if (number / index == number / 2) {
                return number / index;
            }
        }
        return 0;
    }

    public int[] getEvenNumbers(int fromIndex, int toIndex) {
        int arrayOfEvenNum[] = new int[toIndex / 2];
        int number = 0;
        while (fromIndex <= toIndex) {
            if (fromIndex % 2 == 0) {
                arrayOfEvenNum[number] = fromIndex;
                number++;
            }
            fromIndex++;
        }
        return arrayOfEvenNum;
    }

    public int[] getOddNumbers(int from, int to) {
        int arrayOfOddNum[] = new int[to / 2];
        int number = 0;
        for (int index = from; index <= to; index++) {
            if ((index % 2) != 0) {
                arrayOfOddNum[number] = index;
                number++;
            }
            index++;
        }
        return arrayOfOddNum;
    }

    public List<String> getSportsName(List<String> sportsList, String eliminateSportName) {
        sportsList.remove(eliminateSportName);

        return sportsList;
    }
}