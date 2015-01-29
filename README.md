# name-parser-cli
Java command line interface for GBIF scientific name parser library
#General Information

#NameParser Implementation
A Package named Impl is created in which there will be a class which will use nameparser libarary and will create the required json output from the argument passed.

#Developers
  Install jdk 1.7.0
  
  Install Maven
http://maven.apache.org/download.cgi#Installation

To compile the project into an executable JAR file after the successful installation of maven open the  folder where the POM.xml is located using command prompt.
Then execute the command  "mvn package"


jar files will be created under target folder.
cd target

Execute the command 
java -jar name-parser-cli.jar "Poa pratensis L. subsp. sergievskajae (Probat.) Tzvelev"
