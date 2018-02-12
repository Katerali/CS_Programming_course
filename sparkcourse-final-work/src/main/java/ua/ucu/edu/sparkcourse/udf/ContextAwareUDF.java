package ua.ucu.edu.sparkcourse.udf;

import ua.ucu.edu.sparkcourse.evaluate.Context;

public interface ContextAwareUDF {

    void setContext(Context context);
}
