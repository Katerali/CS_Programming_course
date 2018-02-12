package ua.ucu.edu.sparkcourse.udf.validator;

import org.apache.commons.lang.StringUtils;
import org.apache.spark.sql.api.java.UDF1;
import ua.ucu.edu.sparkcourse.udf.RegisterUDF;

import java.io.Serializable;

@RegisterUDF(isValidator = true)
public class EventTimeValidatorUDF implements UDF1<String, Boolean>, Serializable {

    private static final int MATCH_TIME = 90;
    private static final String DIVIDER = ":";


    @Override
    public Boolean call(String value) throws Exception {
        return !isTimeValid(value);
    }

    public static boolean isTimeValid(String value) {
        if (StringUtils.isBlank(value) || !value.contains(DIVIDER)) {
            return false;
        }
        String[] timeParts = value.split(DIVIDER);
        int minutes = Integer.valueOf(timeParts[0]);
        int seconds = Integer.valueOf(timeParts[1]);
        return matchesMatchTime(minutes, seconds) && seconds < 60;
    }

    private static boolean matchesMatchTime(int minutes, int seconds) {
        return minutes < MATCH_TIME || (minutes == MATCH_TIME && seconds == 0);
    }
}
