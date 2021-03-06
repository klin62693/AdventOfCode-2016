# AdventOfCode-2016

This repository is created for AdventOfCode 2016.

Before Run
----------
The language I used is Java and this is a Maven project. 

Outside the input from AoC, I added some test cases by using [_**@JUnit**_](https://github.com/junit-team/junit5/).

So to run this project, you may need to set up the environment first, download and install _**Java**_ and _**Maven**_ first.

Download and Install Java
-------------------------
- [**Window**](https://java.com/en/download/help/windows_manual_download.xml)
- [**Mac OS**](https://java.com/en/download/help/mac_install.xml)
- [**Linux**](https://java.com/en/download/help/linux_install.xml)

Download and Install Maven
-------------
> Make sure you install Java before install Maven
- [**Window**](https://mkyong.com/maven/how-to-install-maven-in-windows/)
- [**Mac OS**](https://mkyong.com/maven/install-maven-on-mac-osx/)
- [**Linux**](https://mkyong.com/maven/how-to-install-maven-in-ubuntu/?utm_source=mkyong.com&utm_medium=referral&utm_campaign=sidebar-related&utm_content=link0)

Clone
-----
After you set up the environment, clone this repository to your local.

`clone https://github.com/klin62693/AdventOfCode-2016.git`

Run
---
If you have any IDE such as [IntelliJ](https://www.jetbrains.com/idea/) or [Eclipse](https://www.eclipse.org/), it is simple to run with your IDE.

If you don't have any IDE on your computer, here is the instruction to run with the [_Maven commands_](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html).
### Maven Commands
**Open your teminal and go the directionary of this repository**

To run and install the program, use this command `mvn clean install`

If you only wanna see the result of the test cases, run this command `mvn test`

If you wanna see the result of program, run with this command `java -cp target/AdventOfCode-2016-1.0-SNAPSHOT.jar main.java.ApplicationStarter`

Project
-------
### Structure
I did Day 1, Day 4 and Day 10 challenges.

For each day challenge, there are two parts question to solve. 

I seperate each day into different files and Each file is a class.

Inside each class, since there are two parts of question, I created two method to solve the question which are _partOne()_ and _partTwo()_

Each method will print out the result.

### Test Case
- For each day challenge, I have _two_ test cases for each part. 

- One is for testing the success case and anothor one is testing for the fail case such as invalid input.

Contact
-------
If you have any question about this repository, please contact me by klin62693@gmail.com.

Looking forward to hear from you!
