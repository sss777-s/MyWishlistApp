#!/usr/bin/env sh
# Gradle wrapper (standard lightweight script)

##############################################################################
# This file is a standard Gradle wrapper script. Keep it executable.
##############################################################################

prog="$0"
# resolve symlink
while [ -h "$prog" ] ; do
  ls=`ls -ld "$prog"`
  link=`expr "$ls" : '.*-> \(.*\)$'`
  if expr "$link" : '/.*' > /dev/null; then
    prog="$link"
  else
    prog=`dirname "$prog"`/"$link"
  fi
done

basedir=`dirname "$prog"`

# Use realpath-like behavior
if [ -z "$GRADLE_HOME" ] ; then
  GRADLE_HOME=""
fi

# Default Gradle wrapper jar location
WRAPPER_JAR="$basedir/gradle/wrapper/gradle-wrapper.jar"
WRAPPER_PROPS="$basedir/gradle/wrapper/gradle-wrapper.properties"

if [ -x "$basedir/gradlew" ] && [ "$0" != "$basedir/gradlew" ] ; then
  exec "$basedir/gradlew" "$@"
fi

java -version >/dev/null 2>&1 || {
  echo "Java not found. Please set JAVA_HOME or install Java 17+."
  exit 1
}

if [ ! -f "$WRAPPER_JAR" ]; then
  echo "WARNING: gradle-wrapper.jar missing at $WRAPPER_JAR"
  echo "The wrapper may not run. See README."
fi

CLASSPATH="$WRAPPER_JAR"
exec java -cp "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
