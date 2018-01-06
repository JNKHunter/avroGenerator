name := "avroToS3"

version := "1.0"

scalaVersion := "2.11.12"


//scalaSource in sbtavro.SbtAvro.avroConfig := sourceManaged.value / "main" / "compiled_avro"
//sbtavrohugger.SbtAvrohugger.scavroSettings

libraryDependencies += "org.apache.avro" % "avro" % "1.8.2"
libraryDependencies += "commons-io" % "commons-io" % "2.5"



        