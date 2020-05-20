name := "sbtSrossScalaVersions"

version := "0.1"

scalaVersion := "2.13.2"

crossScalaVersions := List("2.12.11", "2.11.12", "2.13.2")

Compile / unmanagedSourceDirectories ++= {
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, x)) if x == 11 || x == 12 =>
      Seq(file(sourceDirectory.value.getPath + "/main/scala-2.11-2.12"))
    case _ =>
      Seq(file(sourceDirectory.value.getPath + "/main/scala-2.13"))
  }
}
