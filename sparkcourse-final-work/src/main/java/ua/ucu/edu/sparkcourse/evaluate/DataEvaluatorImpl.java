package ua.ucu.edu.sparkcourse.evaluate;

import org.apache.spark.sql.DataFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.ucu.edu.sparkcourse.udf.enricher.EventNameEnricherUDF;
import ua.ucu.edu.sparkcourse.udf.enricher.EventTimeEnricherUDF;
import ua.ucu.edu.sparkcourse.udf.enricher.TeamNameEnricherUDF;
import ua.ucu.edu.sparkcourse.udf.validator.EventCodeValidatorUDF;
import ua.ucu.edu.sparkcourse.udf.validator.EventTimeValidatorUDF;
import ua.ucu.edu.sparkcourse.udf.validator.PlayerValidatorUDF;

import static org.apache.spark.sql.functions.callUDF;
import static org.apache.spark.sql.functions.col;

@Component
public class DataEvaluatorImpl implements DataEvaluator {


    @Autowired
    private DataFrameBuilder dataFrameBuilder;

    public void evaluate() {
        System.out.println("Start code evaluation..");


        DataFrame dataFrame = dataFrameBuilder.loadEventData();

        dataFrame = dataFrame
                .withColumn("error_event_code", callUDF(EventCodeValidatorUDF.class.getName(),
                col("event code")))
                .withColumn("error_player_from", callUDF(PlayerValidatorUDF.class.getName(),
                        col("player from")))
                .withColumn("error_player_to", callUDF(PlayerValidatorUDF.class.getName(),
                        col("player to")))
                .withColumn("error_event_time", callUDF(EventTimeValidatorUDF.class.getName(),
                        col("event time")))
                .withColumn("player from team", callUDF(TeamNameEnricherUDF.class.getName(),
                        col("player from")))
                .withColumn("player to team", callUDF(TeamNameEnricherUDF.class.getName(),
                        col("player to")))
                .withColumn("event name", callUDF(EventNameEnricherUDF.class.getName(),
                        col("event code")))
                .withColumn("event half", callUDF(EventTimeEnricherUDF.class.getName(),
                        col("event time")));


        dataFrame.show();
    }
}
