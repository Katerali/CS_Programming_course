package ua.ucu.edu.sparkcourse.udf.enricher;

import org.apache.commons.lang3.StringUtils;
import org.apache.spark.sql.api.java.UDF1;
import ua.ucu.edu.sparkcourse.evaluate.Context;
import ua.ucu.edu.sparkcourse.udf.ContextAwareUDF;
import ua.ucu.edu.sparkcourse.udf.RegisterUDF;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

@RegisterUDF
public class TeamNameEnricherUDF implements ContextAwareUDF, UDF1<String, String>, Serializable {

    private Context context;

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public String call(String player) throws Exception {
        for (Map.Entry<String, Set<String>> teamEntry : context.getTeams().entrySet()) {
            String teamName = teamEntry.getKey();
            Set<String> teamPlayers = teamEntry.getValue();
            if (teamPlayers.contains(player)) {
                return teamName;
            }
        }
        return StringUtils.EMPTY;
    }

}
