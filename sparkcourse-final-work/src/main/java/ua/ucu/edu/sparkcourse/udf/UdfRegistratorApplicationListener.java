package ua.ucu.edu.sparkcourse.udf;

import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.types.DataTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ua.ucu.edu.sparkcourse.evaluate.Context;
import ua.ucu.edu.sparkcourse.evaluate.DataLoader;

import java.util.Collection;

@Component
public class UdfRegistratorApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private SQLContext sqlContext;

    @Autowired
    private DataLoader dataLoader;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Context dataContext = dataLoader.createDataContext();
        Collection<Object> udfObjects = context.getBeansWithAnnotation(RegisterUDF.class).values();
        for (Object udfObject : udfObjects) {
            setDataContext(dataContext, udfObject);

            if (isValidator(udfObject.getClass())) {
                registerValidator(udfObject);
            } else {
                registerEnricher(udfObject);
            }
        }
    }

    private void setDataContext(Context context, Object bean) {
        if (bean instanceof ContextAwareUDF) {
            ContextAwareUDF udfBean = (ContextAwareUDF) bean;
            udfBean.setContext(context);
        }
    }

    private static boolean isValidator(Class clazz) {
        RegisterUDF registerUDF = (RegisterUDF) clazz.getAnnotation(RegisterUDF.class);
        return registerUDF.isValidator();
    }

    private void registerValidator(Object udfObject) {
        sqlContext.udf().register(udfObject.getClass().getName(), (UDF1<?, ?>) udfObject, DataTypes.BooleanType);
    }

    private void registerEnricher(Object udfObject) {
        sqlContext.udf().register(udfObject.getClass().getName(), (UDF1<?, ?>) udfObject, DataTypes.StringType);
    }
}
