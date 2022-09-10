import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Maps {
    public Map<Integer, String> mapFunction()
    {
        Map<Integer, String> map = new HashMap<>();
        map.put(124, "goktug");
        map.put(234, "pulur");
        map.put(251, "steph");
        map.put(867, "HSila");
        return map;
    }

    public Map<Integer, AggregatedClass> aggregatedMapFunction()
    {
        AggregatedClass goktug = new AggregatedClass(124, "Goktug", "Oner", LocalDate.of(1989, 8, 23));
        AggregatedClass pulur = new AggregatedClass(234, "Nick Arthur", "Price", LocalDate.of(1989, 6, 3));
        AggregatedClass HSila = new AggregatedClass(867, "Helen syla", "Entourage", LocalDate.of(1997, 9, 3));
        AggregatedClass steph = new AggregatedClass(251, "steph christine", "Papercut", LocalDate.of(1990, 12, 28));

        Map<Integer, AggregatedClass> a_map = new HashMap<>();
        a_map.put(goktug.getID(), goktug);
        a_map.put(pulur.getID(), pulur);
        a_map.put(HSila.getID(), HSila);
        a_map.put(steph.getID(), steph);

        return a_map;
    }
}

