enablePlugins(AwsLambdaPlugin)

lazy val root = (project in file(".")).
  settings(
    name := "vss-alexa-sample",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.12.2"
  ).
  settings(
    libraryDependencies ++= dependencies
  )

lazy val dependencies = Seq(
    "com.amazon.alexa" % "alexa-skills-kit" % "1.8.1",
    "com.fasterxml.jackson.module" % "jackson-module-scala_2.12" % "2.9.2",
    "org.apache.logging.log4j" % "log4j-core" % "2.10.0",
    "org.slf4j" % "slf4j-api" % "1.7.25",
    "org.apache.commons" % "commons-lang3" % "3.7",
    "commons-io" % "commons-io" % "2.6",
    "com.amazonaws" % "aws-lambda-java-core" % "1.2.0",
    "org.skinny-framework" %% "skinny-http-client" % "2.5.2"
)

region := Some("ap-northeast-1")
