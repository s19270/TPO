/**
 *
 *  @author Domański Krzysztof S19270
 *
 */

package zad1;

import java.io.*;
import java.util.Currency;
import java.util.Locale;
import java.util.Map;
import java.net.URL;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.json.JSONObject;
import org.json.JSONException;

public class Service {
	String country;
	String city;
    Map<String, Currency> mapCurr;
    String symbol;
    String curr;
	private String api;
	Service(String c){
		this.country = c;
		this.api = "13d5c2e2a9b7be33d60414e8e049b52b";
		String[] arr = Locale.getISOCountries();
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            Locale loc = new Locale("", s);
            this.mapCurr.put(loc.getDisplayCountry(new Locale("ENGLISH", "US")), Currency.getInstance(loc));
        }
        this.symbol = mapCurr.get(this.country).toString();
        this.curr = mapCurr.get(this.country).toString();
	}
	public String getWeather(String city) throws IOException, JSONException {
        String s;
        this.city = city;
        s = read("http://api.openweathermap.org/data/2.5/weather?q=" + city
                + "&appid=" + this.api);
        return s;
	}
	public double getRateFor(String cur) throws IOException, JSONException {
		String s = read("https://api.exchangeratesapi.io/latest?base=" + this.curr);
        if (s == null) {
            return 0;
        }
        double kurs = 0;
        JSONObject json = new JSONObject(s);
        kurs = json.getJSONObject("rates").optDouble(cur);
        return kurs;
	}
	public double getNBPRate() throws IOException{
        String ka = "http://www.nbp.pl/kursy/kursya.html";
        String kb = "http://www.nbp.pl/kursy/kursyb.html";
        String s = read(ka);
        s += read(kb);
        Pattern pat = Pattern.compile("<td class=\"bgt2 right\">1 (\\w\\w\\w)</td>\\s*<td class=\"bgt2 right\">(\\d*,?\\d*)</td>");
        Matcher mat = pat.matcher(s);
        while (mat.find()) {
        	if (mat.group(1).equals(this.mapCurr.get(this.country).toString()))
            {
            	double result = Double.parseDouble(mat.group(2).replace(',', '.'));
                return result;
            }
        }
        return 1;
	}
	String read(String adres) throws IOException {
        String result = "";
        URL u = new URL(adres);
        InputStream is = u.openStream();
        BufferedReader bf = new BufferedReader(new InputStreamReader(is));
        String s;
        while ((s = bf.readLine()) != null){
                result += s;
        }
        return result;
    }
}  
