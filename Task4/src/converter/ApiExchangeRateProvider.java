

package converter;

import java.io.BufferedReader ; 
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;




public class ApiExchangeRateProvider implements ExchangeRateProvider {
    private static final String API_URL = "https://open.er-api.com/v6/latest/";

    @Override
    public double getExchangeRate(String baseCurrency, String targetCurrency) throws Exception {
        URL url = new URL(API_URL + baseCurrency);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder jsonBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonBuilder.append(line);
        }
        reader.close();

        JSONObject json = new JSONObject(jsonBuilder.toString());

        if (!json.getString("result").equals("success")) {
            throw new RuntimeException("API error: " + json.getString("error-type"));
        }

        JSONObject rates = json.getJSONObject("rates");
        return rates.getDouble(targetCurrency);
    }
}
