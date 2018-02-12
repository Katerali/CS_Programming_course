package ua.ucu.edu.sparkcourse.evaluate;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ucu.edu.sparkcourse.model.Event;
import ua.ucu.edu.sparkcourse.model.Team;

import java.util.Arrays;
import java.util.List;

@Service
public class DataFrameBuilder {

    @Autowired
    private JavaSparkContext sc;

    @Autowired
    private SQLContext sqlContext;


    public DataFrame loadEventData() {
        JavaRDD<String> rdd = sc.textFile("data/rawData.txt");
        JavaRDD<Row> rowJavaRDD = rdd
                .filter(StringUtils::isNotBlank)
                .map(line -> {
                    String[] data = line.split(";");
                    data = Arrays.stream(data).map(kv -> StringUtils.substringAfterLast(kv, "=")).toArray(String[]::new);
                    return RowFactory.create(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4]);
                });

        return sqlContext.createDataFrame(rowJavaRDD, createSchema());
    }

    public List<Event> loadEvents() {
        JavaRDD<String> rdd = sc.textFile("data/codes.properties");
        return rdd.map(line -> {
            String[] data = line.split("=");
            return new Event(Integer.parseInt(data[0]), data[1]);
        }).collect();
    }

    public List<Team> loadPlayers(){
        JavaRDD<String> rdd = sc.textFile("data/teams.properties");
        return rdd.map(line -> {
            String[] data = line.split("=");
            String[] players = data[1].split(",");
            String country = data[0];
            return new Team(country, Sets.newHashSet(players));
        }).collect();
    }


    private static StructType createSchema() {
        return DataTypes.createStructType(new StructField[]{
                DataTypes.createStructField("event code", DataTypes.IntegerType, false),
                DataTypes.createStructField("player from", DataTypes.StringType, false),
                DataTypes.createStructField("player to", DataTypes.StringType, false),
                DataTypes.createStructField("event time", DataTypes.StringType, false),
                DataTypes.createStructField("stadion", DataTypes.StringType, false)
        });
    }


}
