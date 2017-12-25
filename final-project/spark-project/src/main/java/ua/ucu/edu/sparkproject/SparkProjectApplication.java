package ua.ucu.edu.sparkproject;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ResourceLoader;
import ua.ucu.edu.sparkproject.data.RawData;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootApplication
public class SparkProjectApplication implements CommandLineRunner {

    @Autowired
    private JavaSparkContext sparkContext;
    @Autowired
    private SparkSession sparkSession;
    @Autowired
    private ResourceLoader resourceLoader;

    @Resource(name = "codesProperties")
    private Map<String, String> codesProperties;
    @Resource(name = "footballColumnsProperties")
    private Map<String, String> footballColumnsProperties;
    @Resource(name = "teamsProperties")
    private Map<String, String> teamsProperties;

    public static void main(String[] args) {
        SpringApplication.run(SparkProjectApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("=======> Start execution..");

        String rawDataPath = resourceLoader.getResource("classpath:data/rawData.txt").getFile().getPath();

        Dataset<Row> ds = sparkSession.read().csv(rawDataPath);
        ds.show();


        System.out.println("loaded raw data lines count: " + ds.count());
        System.out.println("loaded code properties: " + codesProperties.size());
        System.out.println("loaded football columns properties: " + footballColumnsProperties.size());
        System.out.println("loaded teams properties: " + teamsProperties.size());

        System.out.println("<======= End execution");
    }

    private RawData toRawData(String line) {
        String[] parts = line.split(";");
        RawData rawData = new RawData();
        rawData.setCode(Integer.valueOf(getPart(parts, 0)));
        rawData.setFrom(getPart(parts, 1));
        rawData.setTo(getPart(parts, 1));
        return rawData;
    }

    private static String getPart(String[] parts, int index) {
        return parts[index] != null ? parts[index].trim() : null;
    }
}