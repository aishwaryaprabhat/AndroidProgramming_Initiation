package sutd.apptravel;

import com.google.android.gms.maps.model.LatLng;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypoHandler {
    static String currentLoc;

    public static void main(String[]args){

    }

    public static LatLng typoChecker(String input){
        for(attractions place: attractions.values()){
            Pattern p = Pattern.compile(place.getRegex(), Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(input);
            if(m.matches()) {
                currentLoc = place.getNames();
                return place.getLatLang();
            }
        }
        return null;
    }

    public static String getName(){
        return currentLoc;
    }

}
