# DKatalisLabAssignments 1
 Script is written in Selenium with java language
## **Steps run the scripts from command line**

**Do Maven Setup(If not available)**

### Step 1: Install JDK and Add 'JAVA_HOME' environment variable	

Install Java from [Download JDK Installer](https://www.oracle.com/java/technologies/javase-downloads.html) and add/update JAVA_HOME variable to JDK installation folder.
![JAVA_HOME](https://user-images.githubusercontent.com/8327438/76708159-bd3e2a80-671a-11ea-9a57-b49c8a760794.png)
		 
### Step 2: Download Maven and add ‘MAVEN_HOME’ and ‘M2_HOME’ Environment Variables
Download maven from [here](https://maven.apache.org/download.cgi) and extract to your local directory

Set the M2_HOME and MAVEN_HOME variable to maven installation folder

![image](https://user-images.githubusercontent.com/8327438/76708305-d1365c00-671b-11ea-8554-6b4c806cd0fa.png)
	 
### Step 3: Include ‘maven/bin’ directory in ‘PATH’ variable
To run maven from command prompt, this is necessary. Update the PATH variable with 'Maven-installation/bin' directory.

![image](https://user-images.githubusercontent.com/8327438/76708393-6f2a2680-671c-11ea-94e2-2426ee55b822.png)

### Step 4: Verify maven in Console
    Go to Command prompt and type mvn -version
		C:\Users\xxx>mvn -version
     Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
     Maven home: C:\Ranjit\Software\apache-maven-3.6.3\bin\..
     Java version: 13.0.2, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-13.0.2
     Default locale: en_US, platform encoding: Cp1252
    OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"

### Step 5: Compile Project
* Open the command prompt 
* Navigate to the project folder
* Run mvn compile command. it will compile the project and download required jar files of selenium and testng to local repository folder. Make sure build is SUCCESS.

### Step 6: Run Selenium Script
   In Command prompt , run either '**mvn package**' or '**mvn test**' command to run the selenium test. 
   It will validate and compile maven project and then run selenium webdriver test cases. 
   
   ![image](https://user-images.githubusercontent.com/8327438/76708595-1a87ab00-671e-11ea-84e9-4ac5f77376b0.png)
	 
	 
