name := "code-assignment"

version := "0.1"

scalaVersion := "2.13.5"

lazy val root = (project in file(".")).aggregate(nameScore)

lazy val nameScore = (project in file("nameScore"))
  .settings(
    name := "Name Scoring",
    libraryDependencies ++= Seq(
      "org.scalactic" %% "scalactic" % "3.2.7",
      "org.scalatest" %% "scalatest" % "3.2.7" % Test
    )
  )

