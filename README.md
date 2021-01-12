# Technical Task #
This project is UI automated test for automationpractice.com using Selenium and Cucumber.

## Installation ##
You need to have [Java 8 JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) installed along with [maven](https://maven.apache.org/download.cgi).

To install all dependencies, run 

```console
$ mvn clean install
```

## Running tests ##

```console
$ mvn test
```

To run the test from IDE right click testng.xml file and click Run.

Tests will run in Chrome. ChromeDriver will be installed and configured automatically. Make sure you have chrome browser installed on your local machine.

## Report ##

A report can be viewed at:

```console
target/surefire-reports/All Test Suite/Answer Digital.html
```


## Screenshots ##

Screenshot taken during will be located at:
```console
output/imgs
```