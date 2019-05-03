package files;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class JsonReader {
	public static JSONObject myresponse;
	
	public String performAction() {
		Client client = ClientBuilder.newClient();
		StringBuffer sb = new StringBuffer();
		sb.append("http://api.openweathermap.org/data/2.5/weather?q=Danang&appid=a964e56bb5140d740392e61252739227&units=metric&cnt=6");
		WebTarget target = client.target(sb.toString());
		System.out.println(target.request().get(String.class));
		return target.request().get(String.class);
	}
	
	
	public static Map<String, Object> jsonToMap(String str) {
		Map<String, Object> map = new Gson().fromJson(
					str, new TypeToken<HashMap<String, Object>>() {}.getType()
				);
		return map;
	}
	public void abc() {
		String API_KEY = "a964e56bb5140d740392e61252739227";
		String LOCATION = "Danang";
		String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + API_KEY + "&units=metric&cnt=6";
		try {
			StringBuilder result = new StringBuilder();
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			rd.close();
			System.out.println(result);
			
			Map<String, Object> respMap = jsonToMap(result.toString());
			Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
			Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());
			
			System.out.println("current temperature: " + mainMap.get("temp"));
			System.out.println("current humidity: " + mainMap.get("humidity"));
			System.out.println("Wind speeds: " + windMap.get("speed"));
			System.out.println("Wind angle: " + windMap.get("deg"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void jjj() {
		try {
			String url = "http://api.openweathermap.org/data/2.5/weather?q=Danang&appid=a964e56bb5140d740392e61252739227&units=metric&cnt=6";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			
			
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL: " + url);
			System.out.println("Response code: " + responseCode);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
//			System.out.println(response.toString());
			
			myresponse = new JSONObject(response.toString());
			System.out.println(myresponse);
			
			System.out.println(myresponse.getString("name"));
			System.out.println(myresponse.getJSONObject("main").getDouble("temp"));
			
			String main_object = myresponse.getJSONArray("weather").getJSONObject(0).getString("description");
			System.out.println(main_object);
			
//			JSONArray list = myresponse.getJSONArray("weather");
//			JSONObject listObject = list.getJSONObject(0);
//			String weatherMain = listObject.getString("main");
//			String weatherDesc = listObject.getString("description");
//			System.out.println(weatherMain + weatherDesc);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	  public static void main(String[] args) {
		  jjj();
		  
//		  JsonReader jr = new JsonReader();
//		  jr.performAction();
		  
		  
//		  String API_KEY = "a964e56bb5140d740392e61252739227";
//			String LOCATION = "Danang";
//			String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + API_KEY + "&units=metric&cnt=6";
//			try {
//				StringBuilder result = new StringBuilder();
//				URL url = new URL(urlString);
//				URLConnection conn = url.openConnection();
//				BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//				String line;
//				while ((line = rd.readLine()) != null) {
//					result.append(line);
//				}
//				rd.close();
//				System.out.println(result);
//				
//				Map<String, Object> respMap = jsonToMap(result.toString());
//				Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
//				Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());
//				
//				System.out.println("current temperature: " + mainMap.get("temp"));
//				System.out.println("current humidity: " + mainMap.get("humidity"));
//				System.out.println("Wind speeds: " + windMap.get("speed"));
//			} catch (IOException e) {
//				System.out.println(e.getMessage());
//			}
	  }
}
