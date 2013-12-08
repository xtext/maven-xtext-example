An Xtext Language Built with Maven
==================================

**!!! This is based on the latest SNAPSHOTS of the upcoming Xtext 2.5 release. To be released on December 11 !!!**

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

Noteworthy changes to make manually to your grammar created by the Xtext Wizard
===============================================================================

At least if you are migrating from a pre-2.5 grammar (unclear if in v2.5 this will be OOB),
please note that you'll have to change the grammarURI in your resp. Generate*.mwe2
from classpath:/ to platform:/ - as per the example GenerateHeroLanguage.mwe2,
otherwise you'll hit:

   ERROR mf.mwe2.launch.runtime.Mwe2Launcher  - Problems instantiating module ...Generate*
   Caused by: org.eclipse.xtext.resource.ClasspathUriResolutionException: org.eclipse.xtext.resource.FileNotFoundOnClasspathException: Couldn't find resource on classpath. URI was 'classpath:/.../*.xtext'
