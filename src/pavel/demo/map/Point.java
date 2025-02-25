package pavel.demo.map;

import java.util.Arrays;

public abstract class Point implements GMappable {

    private double[] location;

    public Point(String location) {
        this.location = GMappable.stringToLatLon(location);
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as POINT (" + location() + ")");
    }

    private String location(){
        return Arrays.toString(location);
    }
}
