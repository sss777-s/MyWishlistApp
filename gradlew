#!/usr/bin/env sh
set -e

# path to script dir
DIRNAME="$(cd "$(dirname "$0")" && pwd)"

# try find java
if [ -n "${JAVA_HOME}" ] && [ -x "${JAVA_HOME}/bin/java" ]; then
  JAVACMD="${JAVA_HOME}/bin/java"
else
  JAVACMD=java
fi

CLASSPATH="${DIRNAME}/gradle/wrapper/gradle-wrapper.jar"

exec "${JAVACMD}" -cp "${CLASSPATH}" org.gradle.wrapper.GradleWrapperMain "$@"
