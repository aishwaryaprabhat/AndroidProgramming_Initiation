package sutd.apptravel;

import com.google.android.gms.maps.model.LatLng;

public enum attractions {
    marinaBaySands("(.*)(marina|mbs|infinity|pool)(.*)", 1.2838, 103.8593, "Marina Bay Sands"),
    singaporeFlyer("(.*)(flyer|flier|wheel)(.*)",1.2893,103.8631,"Singapore Flyer"),
    vivoCity("(.*)(vivo)(.*)", 1.2642, 103.8223,"Vivo City"),
    resortsWorldSentosa("(.*)(sentosa|sentozza|sentossa|RWS)(.*)", 1.2552, 103.8218,"Resorts World Sentosa"),
    buddhaToothRelicTemple("(.*)(relic|buddha|tooth)(.*)", 1.2815,  103.8443,"Buddha Relic Tooth Temple"),
    zoo("(.*)(zoo|zoological|mandai)(.*)", 1.4043, 103.7930,"Singapore Zoo");

    private final String regex;

    private final double latitude;

    private final double longitude;

    private final String name;

    private final LatLng latLang;

    attractions(String attractionRegex, double lati, double longi, String nameA){
        regex = attractionRegex;
        latitude = lati;
        longitude = longi;
        name = nameA;
        latLang = new LatLng(latitude,longitude);
    }

    public  String getRegex(){
        return regex;
    }

    public  String getNames(){
        return name;
    }

    public LatLng getLatLang() {
        return latLang;
    }

}
