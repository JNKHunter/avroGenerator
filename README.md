1. Edit/Update schema located in src/main/avro/insight.avsc
2. on the command line run `sbt avro:generate`
3. Edit the "AvroGenerator" class to output the avro you'd like
4. on the command line run `sbt run` to run the program and output avro into the root project directory.
