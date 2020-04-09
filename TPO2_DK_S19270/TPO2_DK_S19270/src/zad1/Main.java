/**
 *
 *  @author Domański Krzysztof S19270
 *
 */

package zad1;

import java.io.IOException;
import org.json.JSONException;

public class Main {
  public static void main(String[] args) throws IOException, JSONException  {
    Service s = new Service("Poland");
    String weatherJson = s.getWeather("Warsaw");
    Double rate1 = s.getRateFor("EUR");
    Double rate2 = s.getNBPRate();
    System.out.println(weatherJson);
    System.out.println(rate1);
    System.out.println(rate2);
    // ...
    // część uruchamiająca GUI
  }
}
