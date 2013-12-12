An Xtext Language Built with Maven
==================================

A small example to show how to configure a Maven build for an Xtext language. It includes:

Language Example (my.mavenized.herolanguage)
 - Language plug-ins, updatesite and Eclipse feature built via Maven/Tycho
 - Xtext Code Generation (Language infrastructure generated from grammar)
 - Xtend Code Generation
 
Example Usage (example-project)
 - Built via Maven (no Tycho!)
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

### 3. Build the example project

```
 cd ../example-project/
 mvn clean install
```
