[![Build Status](https://dhuebner.ci.cloudbees.com/job/maven-xtext-example/badge/icon)](https://dhuebner.ci.cloudbees.com/job/maven-xtext-example/)

An Xtext Language Built with Maven
==================================

A small example to show how to configure a Maven build for an Xtext language and how to use it from Maven and Gradle.


Language Build
--------------
If you use Xtext 2.9 or higher, the Maven build for your language is auto-generated. Just skip ahead to the usage section.

 - see my.mavenized.herolanguage.* projects
 - Language plug-ins, updatesite and Eclipse feature built via Maven/Tycho
 - Xtext Code Generation (Language infrastructure generated from grammar)
 - Xtend Code Generation
 
Language Usage
---------------
 - example-project
 - example-project-gradle
 - Example Language (herolanguage) Code Generation
 - Xtend Code Generation

Try it out!

Steps:
======

### 1. Increase memory.

```
   export MAVEN_OPTS="-Xmx512m -XX:MaxPermSize=256m"
```

### 2. Build the language

```
 cd my.mavenized.herolanguage.releng/
 mvn clean install
```

### 3. Build the example projects

```
 cd ../example-project/
 mvn clean install
```

```
 cd ../example-project-gradle/
 ./gradlew build
```

Builds:
=======

We now have automatic builds:

https://dhuebner.ci.cloudbees.com/job/maven-xtext-example/
