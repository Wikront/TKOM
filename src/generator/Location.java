package generator;

/**
 * Created by Wiktor on 07.06.2017.
 */
public class Location implements Condition {

    private float lat;
    private float lon;
    private int range;

    public Location(float lat, float lon, int range){
        this.lat = lat;
        this.lon = lon;
        this.range = range;
    }

    @Override
    public boolean check() {
        LocalisationAPI localisationAPI = new LocalisationAPI();
        if(localisationAPI.getLat() == lat && localisationAPI.getLon() == lon){
            return true;
        } else {
            return false;
        }
    }
}
