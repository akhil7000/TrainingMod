**Purpose:**
-
The purpose of this repo is to have a basic training template. 
This branch - release/0.5 deals with basic Java training.

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

Everything related to data/drivers needs to be inside - `test/resources`

Everything related to assignments needs to be inside - `com/training/assignments`