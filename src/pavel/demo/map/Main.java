package pavel.demo.map;

import pavel.demo.map.enums.BuildingType;
import pavel.demo.map.enums.UtilityType;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Mappable> mappables = new ArrayList<>();

        mappables.add(new Building("Sydney Town Hall", BuildingType.GOVERNMENT));
        mappables.add(new Building("Sydney Opera House", BuildingType.ENTERTAINMENT));
        mappables.add(new Building("Stadium Australia", BuildingType.SPORTS));

        mappables.add(new UtilityLine("College St", UtilityType.FIBER_OPTIC));
        mappables.add(new UtilityLine("Olympic Blvd", UtilityType.WATER));

        for(var m: mappables) {
            Mappable.mapIt(m);
        }
    }
}
