package ua.ucu.edu.sparkcourse.evaluate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DataLoader {

    @Autowired
    private DataFrameBuilder dataFrameBuilder;

    public Context createDataContext() {
        Map<Integer, String> events = dataFrameBuilder.loadEvents().stream()
                .collect(Collectors.toMap(event -> event.getCode(), event -> event.getDescription()));

        Map<String, Set<String>> teams = dataFrameBuilder.loadPlayers().stream()
                .collect(Collectors.toMap(ateam -> ateam.getCountry(), ateam -> ateam.getPlayers()));

        Context context = new Context();
        context.setEvents(events);
        context.setTeams(teams);

        return context;
    }
}
