set projectLocation=C:\Users\kiit\mars\workspace\MyProject\src\Appium
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause