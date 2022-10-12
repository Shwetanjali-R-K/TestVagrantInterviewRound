# TestVagrantInterviewRound
# TestVagrantInterviewTask
The tool stack used for the framework design is Selenium, JAVA and TestNG.
---------------------------------------------------------
It is a Maven project, Used this tool as it helps to arrange dependencies required for building, testing and executinng code with the help of pom.xml file.
----------------------------------------------------------
* The main test script class "interview.java" is available under the com.interview.driver.
* Class which stores the URL of website is available in the com.interview.methods-->AppDependentMethods.java
* The classes which stores the methods of all the web pages we come across during script execution are available in the pages package this is done to implement POM pattern.
-->GooglePage.java class contains all the required methods of Google search results page.
-->Wikipage.java class contains all the required methods of wikipedia page.
-->Imdbpage.java class contains all the required methods of IMDB page.
* The testdata package has the TestData.java class which stores the all the data required as a input to execute test class. This file is created seperately inorder to customise the data
in clear manner while user wants to extract ReleaseDate, CountryName details of any movie.
* The Utilities package has the AppInependentMethods.java class having all the locators and methods to fetch ReleaseDate, CountryNmae details of movie being searched.
------------------------------------------------------------
* pom.xml file contains the required dependencies.
* TestNG.xml has the configuration of of tests.
* Test-output folder has the index.html report of execution.
