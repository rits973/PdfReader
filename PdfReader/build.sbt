name := """PdfReader"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)
scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
 javaJdbc,
 cache,
 javaWs,
 "org.postgresql" % "postgresql" % "9.3-1100-jdbc41",
 "net.sf.jasperreports" % "jasperreports" % "3.7.6",
 "org.json" % "json" % "20131018",
 "org.apache.pdfbox" % "pdfbox" % "2.0.1",
 "com.itextpdf" % "itextpdf" % "5.5.9"
)
routesGenerator := InjectedRoutesGenerator