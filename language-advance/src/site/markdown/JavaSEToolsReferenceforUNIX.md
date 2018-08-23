# java unix 命令行工具

This section lists and describes the Java Platform Standard Edition, Java SE) commands.

The Java SE commands provide a way for developers to handle development tasks such as compiling and running a program, packaging source files in to a JAR file, applying security policies to a JAR file, and more.

## Command Reference Pages
This command reference describes the full set of JDK commands. The JDK commands that perform related functions are grouped into parts, as follows.

## Create and Build Applications
appletviewer: Runs applets outside of a web browser.

extcheck: Detects version conflicts between a target Java Archive (JAR) file and currently installed extension JAR files.

jar: Combines multiple files into a single JAR file.

java: Starts a Java application.

javac: Reads Java class and interface definitions and compiles them into bytecode and class files.

javadoc: Generates HTML pages of API documentation from Java source files.

javah: Generates C header and source files from a Java class.

javap: Disassembles one or more class files.

jdb: Finds and fixes bugs in Java platform programs.

## Security
These commands set security policies on your local system and create applications that can work within the scope of the security policies set at remote sites.

keytool: Manages a keystore (database) of cryptographic keys, X.509 certificate chains, and trusted certificates.

jarsigner: Signs and verifies JAR files.

policytool: Reads and writes a plain text policy file based on user input through the utility GUI.

## Internationalization
native2ascii: Creates localizable applications by converting a file with characters in any supported character encoding to one with ASCII and/or Unicode escapes (\uxxxx) notation for all characters that are not part of the ASCII character set, or vice versa.

## Remote Method Invocation (RMI)
These commands create applications that interact over the web or with another network.

rmic: Generates stub, skeleton, and tie classes for remote objects that use the Java Remote Method Protocol (JRMP) or Internet Inter-Orb protocol (IIOP). Also generates Object Management Group (OMG) Interface Definition Language (IDL).

rmiregistry: Starts a remote object registry on the specified port on the current host.

rmid: Starts the activation system daemon that enables objects to be registered and activated in a Java Virtual Machine (JVM).

serialver: Returns the serial version UID for specified classes.

## Java IDL and RMI-IIOP
These commands create applications that use OMG-standard IDL and CORBA/IIOP.

tnameserv: Starts the Java Interface Definition Language (IDL) name server.

idlj: Generates Java bindings for a given Interface Definition Language (IDL) file.

orbd: Enables clients to locate and call persistent objects on servers in the CORBA environment.

servertool: Provides an easy-to-use interface for the application programmers to register, unregister, start up, and shut down a server.

## Deploy Applications and Applets
pack200: Packages a JAR file into a compressed pack200 file for web deployment.

unpack200: Transforms a packed file produced by pack200(1) into a JAR file for web deployment.

## Java Web Start
javaws: Starts Java Web Start.

Monitor Java Applications
jconsole: Starts a graphical console that lets you monitor and manage Java applications.

jvisualvm: Visually monitors, troubleshoots, and profiles Java applications.

## Monitor the Java Virtual Machine
Most of these these commands are unsupported and experimental and might not be available in future JDK release.

jps: Experimental. Lists the instrumented Java Virtual Machines (JVMs) on the target system.

jstat: Experimental. Monitors JVM statistics

jstatd: Experimental. Monitors JVMs and enables remote monitoring tools to attach to JVMs.

jmc: Starts Java Mission Controla tool for monitoring and managing running Java applications and JVMs.

## Web Services
schemagen: Generates a schema for every name space that is referenced in your Java classes.

wsgen: Reads a web service endpoint implementation (SEI) class and generates all of the required artifacts for web service deployment, and invocation.

wsimport: Generates JAX-WS portable artifacts that can be packaged in a web application archive (WAR) file and provides an Ant task.

xjc: Compiles an XML schema file into fully annotated Java classes.

## Troubleshooting
Most of these commands are unsupported and experimental and might not be available in future JDK releases.

jcmd: Sends diagnostic command requests to a running JVM.

jinfo: Experimental. Generates configuration information.

jhat: Experimental. Analyzes the Java heap.

jmap: Experimental. Prints shared object memory maps or heap memory details for a process, core file, or remote debug server.

jsadebugd: Experimental. Attaches to a Java process or core file and acts as a debug server.

jstack: Experimental. Prints Java thread stack traces for a Java process, core file, or remote debug server.

## Scripting
This command is unsupported and experimental and might not be available in future JDK releases.

jrunscript: Experimental. Runs a command-line script shell that supports interactive and batch modes.




参考：
> * [Java SE Tools Reference for UNIX](https://docs.oracle.com/javase/8/docs/technotes/tools/unix/index.html)
> * []()
> * []()
> * []()
> * []()