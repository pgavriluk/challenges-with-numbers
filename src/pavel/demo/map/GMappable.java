package pavel.demo.map;

public interface GMappable {

    void render();

    static double[] stringToLatLon(String location) {
        var splits = location.split(",");
        double lat = Double.parseDouble(splits[0]);
        double lon = Double.parseDouble(splits[1]);

        return new double[]{lat, lon};
    }
}
