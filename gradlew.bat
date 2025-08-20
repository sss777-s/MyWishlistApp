@echo off
setlocal
set DIRNAME=%~dp0
if defined JAVA_HOME (
  set "JAVACMD=%JAVA_HOME%\bin\java"
) else (
  set "JAVACMD=java"
)
set "CLASSPATH=%DIRNAME%gradle\wrapper\gradle-wrapper.jar"
"%JAVACMD%" -cp "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*
