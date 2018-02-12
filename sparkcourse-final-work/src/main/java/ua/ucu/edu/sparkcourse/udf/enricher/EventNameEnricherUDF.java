package ua.ucu.edu.sparkcourse.udf.enricher;

import org.apache.commons.lang3.StringUtils;
import org.apache.spark.sql.api.java.UDF1;
import ua.ucu.edu.sparkcourse.evaluate.Context;
import ua.ucu.edu.sparkcourse.udf.ContextAwareUDF;
import ua.ucu.edu.sparkcourse.udf.RegisterUDF;

import java.io.Serializable;

@RegisterUDF
public class EventNameEnricherUDF implements ContextAwareUDF, UDF1<Integer, String>, Serializable {

    private Context context;

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public String call(Integer code) throws Exception {
        return context.getEvents().containsKey(code) ? context.getEvents().get(code) : StringUtils.EMPTY;
    }

}
