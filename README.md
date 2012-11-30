For run tests you should install firefox in directory by default and maybe Selenium IDE (embeded in firefox).

Also you should install:
JDK 6
Maven

Configure JDK and Maven to run it from command line.
Command for run tests:

mvn clean test -DParameter1=value1 -Dparameter2=value2 -DparameterN=valueN

List of parameters:
site.url - url to test (for example: http://localhost:8080)
browser.name - name of browser for test (for example (default): firefox)
browser.version - version browser for test (for example: 17.0)
browser.platform - platform (for example (default): windows)
groupdocs.clientid - your client ID from groupdocs site (for example: jghydt6ndhblgj6l)
groupdocs.privatekey - your private key from groupdocs site (for example: 65fdlk48936ljh0gs8g4y34oih08ds4h)
groupdocs.fileid - ID of your file in groupdocs (for example: 36uy3o6huo3463o754k7gk475gk547h47hk5jg37kj75gk4j7gk3j5g7k45j74k5)
groupdocs.document - Local file for upload during signature test (for example: C:\\test_document.doc)
groupdocs.signature - Local file for upload during signature test (for example: C:\\test_signature.jpg)

You can write this values in file settings.xml and run tests with command:

mvn -s settings.xml clean test

Example settings.xml file:

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <proxies/>
	<profiles>
		<profile>
			<id>dev</id>
			<properties>
				<env>dev</env>
				<grid2.hub></grid2.hub>
				<site.url>http://localhost:8080</site.url>
				<browser.name>firefox</browser.name>
				<browser.version>17.0</browser.version>
				<browser.platform>windows</browser.platform>
				<groupdocs.clientid>jghydt6ndhblgj6l</groupdocs.clientid>
				<groupdocs.privatekey>65fdlk48936ljh0gs8g4y34oih08ds4h</groupdocs.privatekey>
				<groupdocs.fileid>36uy3o6huo3463o754k7gk475gk547h47hk5jg37kj75gk4j7gk3j5g7k45j74k5</groupdocs.fileid>
				<groupdocs.document>C:\\test_document.doc</groupdocs.document>
				<groupdocs.signature>C:\\test_signature.jpg</groupdocs.signature>
			</properties>
			<activation>
				<activeByDefault>true</activeByDefault>
			</activation>
		</profile>
	</profiles>
</settings>
```



