package ua.ucu.edu.sparkcourse.udf.enricher;

import org.apache.commons.lang.StringUtils;
import org.apache.spark.sql.api.java.UDF1;
import ua.ucu.edu.sparkcourse.evaluate.Context;
import ua.ucu.edu.sparkcourse.udf.ContextAwareUDF;
import ua.ucu.edu.sparkcourse.udf.RegisterUDF;
import ua.ucu.edu.sparkcourse.udf.validator.EventTimeValidatorUDF;

import java.io.Serializable;

@RegisterUDF
public class EventTimeEnricherUDF implements ContextAwareUDF, UDF1<String, String>, Serializable {

    private static final String DIVIDER = ":";
    private Context context;

    @Override
    public void setContext(Context context) {
        this.context = context;
    }


    @Override
    public String call(String value) throws Exception {
        if (!EventTimeValidatorUDF.isTimeValid(value)) {
            return StringUtils.EMPTY;
        }
        return half(value);
    }

    public String half(String value) {
        String[] timeParts = value.split(DIVIDER);
        int minutes = Integer.valueOf(timeParts[0]);
        return minutes <= 45 ? "1" : "2";
        }
    }