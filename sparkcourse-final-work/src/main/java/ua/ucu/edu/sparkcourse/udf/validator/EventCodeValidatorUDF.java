package ua.ucu.edu.sparkcourse.udf.validator;

import com.google.common.collect.Sets;
import org.apache.spark.sql.api.java.UDF1;
import ua.ucu.edu.sparkcourse.evaluate.Context;
import ua.ucu.edu.sparkcourse.model.EventType;
import ua.ucu.edu.sparkcourse.udf.ContextAwareUDF;
import ua.ucu.edu.sparkcourse.udf.RegisterUDF;

import java.io.Serializable;
import java.util.Set;

@RegisterUDF(isValidator = true)
public class EventCodeValidatorUDF implements ContextAwareUDF, UDF1<Integer, Boolean>, Serializable {

    private static final Set<EventType> MULTIPLE_PLAYER_EVENTS = Sets.newHashSet(EventType.PASS_SENT, EventType.PASS_RECEIVED);

    private Context context;

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public Boolean call(Integer code) throws Exception {
        return !isValid(code);
    }

    private boolean isValid(Integer code) {
        return hasCode(code) && isMultiplePlayerRequires(code);
    }

    protected boolean hasCode(Integer code) {
        return context.getEvents().containsKey(code);
    }

    protected boolean isMultiplePlayerRequires(Integer code) {
        return MULTIPLE_PLAYER_EVENTS.contains(EventType.fromCode(code));
    }

}
