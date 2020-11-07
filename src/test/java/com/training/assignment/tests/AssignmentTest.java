package com.training.assignment.tests;

import com.training.assignments.Assignment;
import com.training.assignments.Operations;
import com.training.assignments.abstraction.Yes1;
import com.training.assignments.inheritance.ParentChild;
import com.training.assignments.miniproject.Employee1;
import com.training.assignments.miniproject.EmployeeOperation;
import com.training.assignments.miniproject.Student;
import com.training.assignments.oopsinterface.Yes2;
import com.training.assignments.polymorphism.overloading.Employee;
import com.training.assignments.polymorphism.overriding.Director;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

public class AssignmentTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Assignment assignment = new Assignment();
    private Operations operation = new Operations();

    @Test
    public void testDataConversion() {
        logger.info("double from int->" + assignment.getDoubleFromInt(55));
        softAssert.assertThat(assignment.getDoubleFromInt(55))
                .as("int number not converted to double").isEqualTo(55.0);

        logger.info("int from double->" + assignment.getIntFromDouble(55.0));
        softAssert.assertThat(assignment.getIntFromDouble(55.0))
                .as("double number not converted to int").isEqualTo(55);

        logger.info("float from double->" + assignment.getFloatFromDouble(55.0555558888888888888));
        softAssert.assertThat(assignment.getFloatFromDouble(55.0555558888888888888))
                .as("double number not converted to float").isEqualTo(55.055557f);

        logger.info("double from float->" + assignment.getDoubleFromFloat((float) 55.00589001231313450));
        softAssert.assertThat(assignment.getDoubleFromFloat((float) 55.00589001231313450))
                .as("float number not converted to double").isEqualTo(55.005889892578125);

        logger.info("byte from long->" + assignment.getByteFromLong(11005987L));
        softAssert.assertThat(assignment.getByteFromLong(11005987L))
                .as("long number not converted to byte").isEqualTo((byte) 35);

        logger.info("long from byte->" + assignment.getLongFromByte((byte) 32));
        softAssert.assertThat(assignment.getLongFromByte((byte) 32))
                .as("byte number not converted to long").isEqualTo(32);
    }

    @Test
    public void testOperationString() {
        for (char characters : assignment.getCharacterFromString("rccl")) {
            logger.info("converted in character format-->" + characters);
        }

        softAssert.assertThat(assignment.getCharacterFromString("rccl"))
                .as("doesn't contains r,c,c,l characters").contains('r', 'c', 'c', 'l');

        logger.info("converted Ram to Sam-->" + assignment.getReplacedString("Ram", "Ram", "Sam"));
        softAssert.assertThat(assignment.getReplacedString("Ram", "Ram", "Sam"))
                .as("is not equal to Sam").isEqualTo("Sam");

        logger.info("converted Tendulkar to Masterrrr-->" +
                assignment.getReplacedString("Sachin Tendulkar", "Tendulkar", "Masterrrr"));
        softAssert.assertThat(assignment.getReplacedString("Sachin Tendulkar", "Tendulkar", "Masterrrr"))
                .as("is not equal to Sachin Masterrrr").isEqualTo("Sachin Masterrrr");

        logger.info("converted Dell to Depp-->" +
                assignment.getReplacedString("Dell", "Dell", "Depp"));
        softAssert.assertThat(assignment.getReplacedString("Dell", "Dell", "Depp"))
                .as("String not Replaced to Depp").isEqualTo("Depp");

        logger.info("index of X is-->" + assignment.getIndexOf("Xioami", 'X'));
        softAssert.assertThat(assignment.getIndexOf("Xioami", 'X'))
                .as("index not correct").isEqualTo(0);

        logger.info("index of a is-->" + assignment.getIndexOf("Xioami", 'a'));
        softAssert.assertThat(assignment.getIndexOf("Xioami", 'a'))
                .as("index not correct").isEqualTo(3);

        logger.info("index of o is-->" + assignment.getIndexOf("Xioami", 'o'));
        softAssert.assertThat(assignment.getIndexOf("Xioami", 'o'))
                .as("index not correct").isEqualTo(2);

        logger.info("after using subString name-->" +
                assignment.getNameUsingSubString("Indian Oil Corporation Ltd", 11, 22));
        softAssert.assertThat(assignment.getNameUsingSubString("Indian Oil Corporation Ltd", 11, 22))
                .as("String not found").isEqualTo("Corporation");

        logger.info("index value-->" + assignment.getIndex(new String[]{"Paulo Dybala", "Federico", "Gianluigi", "Ronaldo", "Messi"}, "Ronaldo"));
        softAssert.assertThat(assignment.getIndex(new String[]{"Paulo Dybala", "Federico", "Gianluigi", "Ronaldo", "Messi"}, "Ronaldo"))
                .as("Ronaldo string not found in list").isEqualTo(3);
    }

    @Test
    public void testOperationWithLoops() {
        softAssert.assertThat(operation.getCompanyReviews("Google")).
                as("Review of google is not matching with best platform where u will get solution for everything, check other description too.")
                .isEqualTo("Best platform where u will get solution for everything");

        softAssert.assertThat(operation.getCompanysFeedback("Thermolab")).
                as("Company Feedback not matching with good company for production of stabilizers and incubator,check other description too.")
                .isEqualTo("good company for production of stabilizers and incubator");

        softAssert.assertThat(operation.getBehaviour("good"))
                .as("Wrong decision as behaviour contradicts").isEqualTo("go to heaven");

        softAssert.assertThat(operation.getPlaceBehaviourBased("Bad"))
                .as("Wrong place assigned as behaviour contradicts").isEqualTo("go to hell");

        softAssert.assertThat(operation.getPlaceBehaviourBased("good"))
                .as("Wrong place assigned as behaviour contradicts").isEqualTo("go to heaven");

        softAssert.assertThat(operation.getMiddleNumber(500))
                .as("Incorrect Middle number").isEqualTo(250);

        for (int evenNumber : operation.getEvenNumbers(1, 100)) {
            softAssert.assertThat(evenNumber % 2 == 0)
                    .as("Number is not an even number-->" + evenNumber).isTrue();
        }

        for (int oddNumber : operation.getOddNumbers(1, 10)) {
            softAssert.assertThat((oddNumber % 2) != 0)
                    .as("Number is not an odd number-->" + oddNumber).isTrue();
        }
    }

    @Test
    public void testOopsConcept() {
        ParentChild parentChild=new ParentChild();
        Director director = new Director();

        List<String> sportsList = new ArrayList<>(Arrays.asList("Cricket", "Khokho", "Kabaddi", "Batminton", "Hockey", "Football"));

        softAssert.assertThat(operation.getSportsName(sportsList, "Batminton"))
                .as("List should not contains Batminton")
                .isEqualTo(Arrays.asList("Cricket", "Khokho", "Kabaddi", "Hockey", "Football"));

        softAssert.assertThat(parentChild.getName())
                .as("Full name  of parent child is incorrect").isEqualTo("MIKE TYSON");

        softAssert.assertThat(director.getWorkDetail())
                .as("Work of actor and director differs").isEqualTo("Acting Directing");
    }

    @Test
    public void testAbstractInterfaceConcept() {
        Employee employee = new Employee();

        String firstName = "Shrikant";
        String lastName = "Sajjanshetti";

        softAssert.assertThat(employee.getName(firstName))
                .as("Employee name doesn't match,try something else").isEqualTo("Shrikant");

        softAssert.assertThat(employee.getName(firstName, lastName))
                .as("Employee name doesnt match,try something else").isEqualTo("Shrikant Sajjanshetti");

        softAssert.assertThat(employee.getName(firstName, lastName, "Umakant"))
                .as("Employee name doesnt match,try something else").isEqualTo("Shrikant Sajjanshetti Umakant");

        softAssert.assertThat(new Yes1().getSum(3))
                .as("Sum of three number is incorrect").isEqualTo(33);

        softAssert.assertThat(new Yes2().getSum(5))
                .as("Sum of three number is incorrect").isEqualTo(35);
    }

    @Test
    public void testStaticExample() {
        String name = "Shri";
        String lastName = "Shetti";
        int rollNo = 56;
        String schoolName = "SVP";

        Student student1 = new Student();
        Student student2 = new Student();

        student1.setName(name);
        student1.setLastName(lastName);
        student1.setRollNo(rollNo);
        Student.setSchoolName("Anudatt");

        student2.setSchoolName(schoolName);

        softAssert.assertThat(student1.getName()).as("Name is not matching").isEqualTo(name);

        softAssert.assertThat(student1.getLastName()).as("Lastname is not matching").isEqualTo(lastName);

        softAssert.assertThat(student1.getRollNo()).as("Roll number doesn't match").isEqualTo(rollNo);

        softAssert.assertThat(Student.getSchoolName()).as("School name doesn't match").isEqualTo(schoolName);

        softAssert.assertThat(student2.getSchoolName()).as("School name doesn't match").isEqualTo(schoolName);
    }

    @Test
    public void testMiniProject() {

        Employee1 originalEmployee1 =new Employee1();


        originalEmployee1.createEmployee("Shri", "Kandivali", 1000, 1);
        originalEmployee1.createEmployee("Pranav", "Thane", 2000, 2);
        originalEmployee1.createEmployee("Naresh", "Nerul", 3000, 3);
        originalEmployee1.createEmployee("Sunil", "panvel", 4000, 4);

        System.out.println("All Emp = " + originalEmployee1.getEmployee());

        EmployeeOperation empOperation=new EmployeeOperation();
       // empOperation.getDeletedEmployee(1,originalEmployee1.getEmployee());

        System.out.println("All Emp = " + empOperation.getDeletedEmployee(1,originalEmployee1.getEmployee()));

        System.out.println("All Emp = " + empOperation.getDeletedEmployee(1,originalEmployee1.getEmployee(),"Sunil", "panvel", 4000, 4));

        System.out.println("*********= " + originalEmployee1.getEmployee());
        List<Employee1> abc = originalEmployee1.getEmployee();
        Iterator<Employee1> abcI = abc.iterator();
        while(abcI.hasNext()){
            softAssert.assertThat(abcI.next().getName()).as("Delete operation not performed")
                    .doesNotContain("Pranav");
        }


//        originalEmployee1.setName("Shri");
//        originalEmployee1.setAddress("Kandivali");
//        originalEmployee1.setSalary(20000);
//        originalEmployee1.setId(56);
//        originalEmployee1.getCreateEmployee(originalEmployee1);
//
//        com.training.assignments.miniproject.Employee originalEmployee2 =
//                new com.training.assignments.miniproject.Employee();
//
//        originalEmployee2.setName("Ashish");
//        originalEmployee2.setAddress("Malad");
//        originalEmployee2.setSalary(25000);
//        originalEmployee2.setId(84);
//        originalEmployee2.getCreateEmployee(originalEmployee2);
//
//        com.training.assignments.miniproject.Employee originalEmployee3 =
//                new com.training.assignments.miniproject.Employee();
//
//        originalEmployee3.setName("Arnav");
//        originalEmployee3.setAddress("Goregaon");
//        originalEmployee3.setSalary(3000);
//        originalEmployee3.setId(75);
//        originalEmployee3.getCreateEmployee(originalEmployee3);
//
//        com.training.assignments.miniproject.Employee originalEmployee4 =
//                new com.training.assignments.miniproject.Employee();
//        originalEmployee4.setName("Paramveer");
//        originalEmployee4.setAddress("Andheri");
//        originalEmployee4.setSalary(40000);
//        originalEmployee4.setId(420);
//        originalEmployee4.getCreateEmployee(originalEmployee4);
//
//        com.training.assignments.miniproject.Employee cloneEmployee1 =
//                new com.training.assignments.miniproject.Employee();
//
//        cloneEmployee1.setName("Shri");
//        cloneEmployee1.setAddress("Kandivali");
//        cloneEmployee1.setSalary(20000);
//        cloneEmployee1.setId(56);
//        cloneEmployee1.getCreateCloneEmployee(cloneEmployee1);
//
//        com.training.assignments.miniproject.Employee cloneEmployee2 =
//                new com.training.assignments.miniproject.Employee();
//
//        cloneEmployee2.setName("Ashish");
//        cloneEmployee2.setAddress("Malad");
//        cloneEmployee2.setSalary(25000);
//        cloneEmployee2.setId(84);
//        cloneEmployee2.getCreateCloneEmployee(cloneEmployee2);
//
//        com.training.assignments.miniproject.Employee cloneEmployee3 =
//                new com.training.assignments.miniproject.Employee();
//
//        cloneEmployee3.setName("Arnav");
//        cloneEmployee3.setAddress("Goregaon");
//        cloneEmployee3.setSalary(3000);
//        cloneEmployee3.setId(75);
//        cloneEmployee3.getCreateCloneEmployee(cloneEmployee3);
//
//        com.training.assignments.miniproject.Employee cloneEmployee4 =
//                new com.training.assignments.miniproject.Employee();
//
//        cloneEmployee4.setName("Paramveer");
//        cloneEmployee4.setAddress("Andheri");
//        cloneEmployee4.setSalary(40000);
//        cloneEmployee4.setId(420);
//        cloneEmployee4.getCreateCloneEmployee(cloneEmployee4);
//
//        Iterator<com.training.assignments.miniproject.Employee> createdEmployeeIterator =originalEmployee4.getCreatedEmployeeList().iterator();
//        Iterator<com.training.assignments.miniproject.Employee> cloneEmployeeIterator = cloneEmployee4.getCreatedCloneEmployeeList().iterator();
//
//        while (createdEmployeeIterator.hasNext()) {
//            com.training.assignments.miniproject.Employee empDetails = createdEmployeeIterator.next();
//            com.training.assignments.miniproject.Employee cloneEmpDetails = cloneEmployeeIterator.next();
//
//            softAssert.assertThat(empDetails.getName())
//                    .as("Name's inside created list and clone list differs")
//                    .isEqualTo(cloneEmpDetails.getName());
//
//            softAssert.assertThat(empDetails.getAddress())
//                    .as("Address inside created list and clone list differs")
//                    .isEqualTo(cloneEmpDetails.getAddress());
//
//            softAssert.assertThat(empDetails.getId())
//                    .as("Id's inside created list and clone list differs")
//                    .isEqualTo(cloneEmpDetails.getId());
//
//            softAssert.assertThat(empDetails.getSalary())
//                    .as("Salary inside created list and clone list differs")
//                    .isEqualTo(cloneEmpDetails.getSalary());
//        }
//
//        Iterator<com.training.assignments.miniproject.Employee> deletedEmployeeIterator =
//                originalEmployee1.getDeletedEmployee(1).iterator();
//
//        Iterator<com.training.assignments.miniproject.Employee> cloneDeletedEmployeeIterator =
//                cloneEmployee1.getCloneDeletedEmployee(1).iterator();
//
//        while (deletedEmployeeIterator.hasNext() && cloneDeletedEmployeeIterator.hasNext()) {
//            com.training.assignments.miniproject.Employee employee = deletedEmployeeIterator.next();
//            com.training.assignments.miniproject.Employee clonedEmpoyee = cloneDeletedEmployeeIterator.next();
//
//            softAssert.assertThat(employee.getAddress())
//                    .as("Address inside updated list and clone list differs")
//                    .isEqualTo(clonedEmpoyee.getAddress());
//
//            softAssert.assertThat(employee.getName())
//                    .as("Name's inside updated list and clone list differs")
//                    .isEqualTo(clonedEmpoyee.getName());
//
//            softAssert.assertThat(employee.getId())
//                    .as("Id's inside updated list and clone list differs")
//                    .isEqualTo(clonedEmpoyee.getId());
//
//            softAssert.assertThat(employee.getSalary())
//                    .as("Salary inside updated list and clone list differs")
//                    .isEqualTo(clonedEmpoyee.getSalary());
//        }
//
//        //Accessing first index values and updating the same
//        originalEmployee2 = originalEmployee4.getCreatedEmployeeList().get(1);
//        originalEmployee2.setName("Ashwini");
//        originalEmployee2.setAddress("Lokhandwala");
//        originalEmployee2.setSalary(25000);
//
//        Iterator<com.training.assignments.miniproject.Employee> updatedEmployeeIterator =
//                originalEmployee2.getUpdatedEmployee(originalEmployee2, 1).iterator();
//
//        cloneEmployee2 = cloneEmployee4.getCreatedCloneEmployeeList().get(1);
//        cloneEmployee2.setName("Ashwini");
//        cloneEmployee2.setAddress("Lokhandwala");
//        cloneEmployee2.setSalary(25000);
//
//        Iterator<com.training.assignments.miniproject.Employee> updatedClonedEmployeeIterator =
//                cloneEmployee2.getCloneUpdatedEmployee(cloneEmployee2, 2).iterator();
//
//        while (updatedEmployeeIterator.hasNext()) {
//            com.training.assignments.miniproject.Employee updatedEmpDetails = updatedEmployeeIterator.next();
//            com.training.assignments.miniproject.Employee updatedCloneEmpDetails = updatedClonedEmployeeIterator.next();
//
//            softAssert.assertThat(updatedEmpDetails.getName())
//                    .as("Name's inside updated list and clone list differs")
//                    .isEqualTo(updatedCloneEmpDetails.getName());
//
//            softAssert.assertThat(updatedEmpDetails.getAddress())
//                    .as("Address inside updated list and clone list differs")
//                    .isEqualTo(updatedCloneEmpDetails.getAddress());
//
//            softAssert.assertThat(updatedEmpDetails.getId())
//                    .as("Id's inside updated list and clone list differs")
//                    .isEqualTo(updatedCloneEmpDetails.getId());
//
//            softAssert.assertThat(updatedEmpDetails.getSalary())
//                    .as("Salary inside updated list and clone list differs")
//                    .isEqualTo(updatedCloneEmpDetails.getSalary());
//        }
    }
}