[![Build Status](https://github.com/xtext/maven-xtext-example/workflows/Build/badge.svg?branch=master)](https://github.com/xtext/maven-xtext-example/actions?query=workflow%3ABuild)

# An Xtext Language Built with Maven

A small example to show how to configure a Maven build for an Xtext language and how to use it from Maven and Gradle.

## Language Build

If you use Xtext 2.9 or higher, the Maven build for your language is auto-generated. Just skip ahead to the usage section.

- see my.mavenized.herolanguage.* projects
- Language plug-ins, updatesite and Eclipse feature built via Maven/Tycho
- Xtext Code Generation (Language infrastructure generated from grammar)
- Xtend Code Generation

## Language Usage

- example-project
- example-project-gradle
- Example Language (herolanguage) Code Generation
- Xtend Code Generation

Try it out!

# Steps

## 1. Increase memory

```bash
   export MAVEN_OPTS="-Xmx512m -XX:MaxPermSize=256m"
```

## 2. Build the language

```bash
 mvn clean install
```

## 3. Build the example projects

```bash
 cd ../example-project/
 mvn clean install
```

```bash
 cd ../example-project-gradle/
 ./gradlew build
```

# Builds

We now have automatic builds:

https://github.com/xtext/maven-xtext-example/actions?query=workflow%3ABuild

# Maven Archetype

There is also a Maven Archetype available that automatically creates your new project based on this example:
https://github.com/fuinorg/emt-xtext-archetype

# Known Issues

## 1. Build fails due to version conflicts

The build will fail immediately because of version conflicts. A possible error might look similar to the following: 

* ```No versions available for org.eclipse.emf:org.eclipse.emf.mwe2.runtime:jar:[2.9.1.201705291010] within specified range```

Even if the specified version (see pom) is available on the central maven repository, updating related snapshots will most likely help the problem.

* ```mvn clean install -U```

