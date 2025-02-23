package pavel.demo.map;

import pavel.demo.map.enums.BuildingType;
import pavel.demo.map.enums.Color;
import pavel.demo.map.enums.Geometry;
import pavel.demo.map.enums.PointMarker;

public class Building implements Mappable{

    private String name;
    private BuildingType type;

    public Building(String name, BuildingType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getLabel() {
        return name + " (" + type + ")";
    }

    @Override
    public String getMarker() {
        return switch(type){
            case ENTERTAINMENT -> Color.GREEN + " " + PointMarker.TRIANGLE;
            case GOVERNMENT -> Color.RED + " " + PointMarker.STAR;
            case RESIDENTIAL -> Color.BLUE + " " + PointMarker.SQUARE;
            case SPORTS -> Color.ORANGE + " " + PointMarker.PUSH_PIN;
            default -> Color.BLACK + " " + PointMarker.CIRCLE;
        };
    }

    @Override
    public Geometry getShape() {
        return Geometry.POINT;
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                , "name": "%s", "type": "%s" """.formatted(name, type);
    }
}
