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
    "com.amazonaws" % "aws-lambda-java-core" % "1.2.0",
    "org.skinny-framework" %% "skinny-http-client" % "2.5.2"
)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", _*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}

region := Some("ap-northeast-1")
