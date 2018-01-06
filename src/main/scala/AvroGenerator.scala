import java.io.File
import java.util.UUID

import com.brightmeta.{Data, TestRecord}
import org.apache.avro.file.DataFileWriter
import org.apache.avro.specific.SpecificDatumWriter

object AvroGenerator {

  def main(args: Array[String]) {

    val record = TestRecord.newBuilder()
      .setReferenceId("111122223333")
      .setUuid(UUID.randomUUID().toString)
      .setCreatedOn(1234567L)
      .setRecordName("TestRecordName")
        .setPayload(Data.newBuilder()
          .setProbability(5.0).build()).build()

    println(record.getSchema)
    
    val writer = new SpecificDatumWriter[TestRecord]
    val fileWriter = new DataFileWriter(writer)
    fileWriter.create(record.getSchema, new File("records.avro"))
    fileWriter.append(record)
    fileWriter.close()
  }
}