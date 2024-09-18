@echo off
set /P suiteName="Enter suite name: "
set /P testName="Enter test name: "
set /P className="Enter class name: "
set /P fileName="Enter file name: "
(
echo ^<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd"^>
echo ^<suite name="%suiteName%"^>
echo ^<test name="%testName%"^>
echo 	^<classes^>
echo 		^<class name="%className%"^>^</class^>
echo 	^</classes^>
echo 	^</test^>
echo	^</suite^>
) > ./%fileName%.xml