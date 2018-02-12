package ua.ucu.edu.sparkcourse.udf.validator;

import org.apache.spark.sql.api.java.UDF1;
import ua.ucu.edu.sparkcourse.evaluate.Context;
import ua.ucu.edu.sparkcourse.udf.ContextAwareUDF;
import ua.ucu.edu.sparkcourse.udf.RegisterUDF;

import java.io.Serializable;

@RegisterUDF(isValidator = true)
public class PlayerValidatorUDF implements ContextAwareUDF, UDF1<String, Boolean>, Serializable {

    private Context context;

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public Boolean call(String player) throws Exception {
        return !isPlayerFound(player);
    }

    protected boolean isPlayerFound(String player) {
        return context.getAllPlayers().contains(player);
    }

}