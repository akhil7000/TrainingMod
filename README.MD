**Purpose:**
-
The purpose of this repo is to have a basic training template for streams API.

### Stream API Exercises : Part I

**Q.1)** Find the most populated city of each continent

**Q.2)** Find the number of movies of each director

**Q.3)** Find the number of genres of each director's movies

**Q.4)** Find the highest populated capital city

**Q.5)** Find the highest populated capital city of each continent

**Q.6)** Sort the countries by number of their cities in descending order

**Q.7)** Find the list of movies having the genres "Drama" and "Comedy" only

**Q.8)** Group the movies by the year and list them

**Q.9)** Sort the countries by their population densities in descending order ignoring zero population
countries

**Q.10)** Find the richest country of each continent with respect to their GNP (Gross National Product)
values.

**Q.11)** Find the minimum, the maximum and the average population of world countries.

**Q.12)** Find the minimum, the maximum and the average population of each continent.

**Q.13)** Find the countries with the minimum and the maximum population.

**Q.14)** Find the countries of each continent with the minimum and the maximum population.

**Q.15)** Group the countries by continent, and then sort the countries in continent by number of cities
in each continent.

**Q.16)** Find the cities with the minimum and the maximum population in countries.

**Q.17)** Find the minimum, the maximum, the average, and the standard deviation of GNP values.

**Q.18)** Find the year where the maximum number of movie is available

**Requirements:**
-
Checkout the repository using the following command: `git clone -b <branchName> https://github.com/akhil7000/TrainingMod.git`

All tests are running using the Junit 5 framework, specifically the runner. This can be verified by ensuring that all the imports are using `import org.junit.jupiter.api.Test;`. To run this use the gradle arguments -> --tests "com.training.sample.tests.SampleTest

The recommended IDE is Intellij with the Lombok plugin installed. In order to install it follow the instructions from the official guide: https://www.jetbrains.com/help/idea/managing-plugins.html and https://projectlombok.org/setup/intellij .
After installing the Lombok plugin, it needs to be enabled as an annotation processor. The easiest way is by clicking the intellij notification that will pop up after restarting the IDE following the Lombok plugin installation. This can also be done in the Settings -> Build, Execution, Deployment -> Compiler -> Annotation Processors -> Enable Annotation Processing

**Usage:**
-
It has a sample test method inside the test package - `com/training/sample/tests/SampleTest.java`. All the tests needs to be inside this package based on - `web, mobile and services`

It has a sample page class inside main package - `com/training/sample/pages/SamplePage.java`. All the pages/screen classes needs to inside this package.

Everything related to data/drivers needs to be inside - `test/resources/`

For streams all the tests/exercises would go inside test package - `com/training/streams/tests/`

All the domain classes for streams api are inside main package - `com/training/streams/`
