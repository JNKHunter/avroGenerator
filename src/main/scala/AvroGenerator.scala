import java.io.File
import java.util.UUID

import com.capitalone.eci.insights.{Data, NoveltyMerchant}
import org.apache.avro.file.DataFileWriter
import org.apache.avro.specific.SpecificDatumWriter

object AvroGenerator {

  def main(args: Array[String]) {

    val insight = NoveltyMerchant.newBuilder()
      .setProfileReferenceId("111122223333")
      .setUuid(UUID.randomUUID().toString)
      .setCreatedOn(1234567L)
      .setInsightName("NoveltyMerchant")
        .setPayload(Data.newBuilder()
          .setNoveltyMerchantPercentage(5.0).build()).build()

    println(insight.getSchema)


    val writer = new SpecificDatumWriter[NoveltyMerchant]
    val fileWriter = new DataFileWriter(writer)
    fileWriter.create(insight.getSchema, new File("insight.avro"))
    fileWriter.append(insight)
    fileWriter.close()
  }
}