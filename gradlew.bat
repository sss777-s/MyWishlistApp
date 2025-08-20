@echo off
REM Gradle wrapper batch file
SETLOCAL
if not defined JAVA_HOME (
  echo JAVA_HOME not set. Please install Java 17+ and set JAVA_HOME.
) 
java -cp "%~dp0\gradle\wrapper\gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain %*
ENDLOCAL
