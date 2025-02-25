package pavel.demo.map;

import java.util.Arrays;

public abstract class Line implements GMappable {

    private final double[][] locations;

    public Line(String... locations) {
        this.locations = new double[locations.length][];
        int index = 0;

        for (var l : locations) {
            this.locations[index++] = GMappable.stringToLatLon(l);
        }
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as LINE (" + locations() + ")");
    }

    private String locations(){
        return Arrays.deepToString(this.locations);
    }
}
