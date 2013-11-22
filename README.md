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

### 1. Use sonatype snapshot repository:

In your .m2/settings.xml (or wherever you prefer) add:
```xml
<settings>
  <profiles>
    <profile>
      <id>snapshots</id>
      <activation>
        <activeByDefault>true</activeByDefault>
      </activation>
      <repositories>
        <repository>
          <id>central snapshots</id>
          <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
        </repository>
      </repositories>
      <pluginRepositories>
          <pluginRepository>
              <id>central snapshots</id>
              <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
          </pluginRepository>
      </pluginRepositories>
    </profile>
  </profiles>
  
</settings>

```

### 2. Increase memory.

```
   export MAVEN_OPTS="-Xmx512m -XX:MaxPermSize=256m"
```

### 3. Build the language

```
 cd my.mavenized.herolanguage.releng/
 mvn clean install
```

### 4. Build the example project

```
 cd ../example-project/
 mvn clean install
```
