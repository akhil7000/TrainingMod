**Purpose:**
-
The purpose of this repo is to have a basic training template for streams API.

### Stream API Exercises : Part II
Stream API Exercises : Part II

`List<Animal> animals= List.of(
        new Spider(),
        new Cat(),
        new Fish("Free Willy"),
        new Cat("Tekir"),
        new Fish("Jaws"),
        new Spider()
);`

**Q.1)** Take a list of wild animals

**Q.2)** Take a list of pets

**Q.3)** Find the animal with the highest number of legs

**Q.4)** Take a list of 100 random animals

**Q.5)** Find the total number of legs

**Q.6)** Group the animals by their number of legs

**Q.7)** Count the number of animals in each specie

**Q.8)** Count the number of species

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

Everything related to data/drivers needs to be inside - `test/resources/streams`

For streams all the tests/exercises would go inside- `com/training/streams/tests/`

All the domain classes for streams api are inside - `com/training/streams`
