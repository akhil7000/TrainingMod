**Purpose:**
-
The purpose of this repo is to have a basic training template for streams API.

### Stream API Exercises : Part III
In the following exercises you will use a dictionary file: **main/resources/dictionary.txt**.

**Q.1)** Find the words starting with letters **a** to **m**.

**Q.2)** Find the words starting with the letter **n** to the end of the dictionary

**Q.3)** Group the dictionary words by their first three letters

**Q.4)** Find the palindromes in the dictionary. A palindrome is a word, number, phrase, or other
sequence of characters which reads the same backward as forward, such as madam or racecar

**Q.5)** Count the vowels used in words.

**Q.6)** Find the words starting with the letter **a**, and ends with the letter **z**.

**Q.7)** Find the longest word in the dictionary

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