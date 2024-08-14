package com.kh.api.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

import netscape.javascript.JSObject;

public class JsonParsing {

	public static void main(String[] args) {
		String serviceKey = "L6kAuNH9cshbOofaVUQ0yP2YLErUVNV4AixaDbTiAgDDmg8OvkSjPx9Ayj6uBXxEihEl%2B1oRc%2FpR8ihynEusIg%3D%3D";
		String url = "https://apis.data.go.kr/6260000/FoodService/getFoodKr?serviceKey=" + serviceKey
				+ "&numOfRows=10&resultType=json";
		
		try {
			URL requestUrl = new URL(url);
			HttpsURLConnection urlConnection = (HttpsURLConnection) requestUrl.openConnection();
			urlConnection.setRequestMethod("GET");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line = null;
			
			StringBuffer responseBuffer = new StringBuffer();
			
			while((line=br.readLine())!=null) {
				responseBuffer.append(line);
			}
			br.close();
			urlConnection.disconnect();
			
			String responeseData = responseBuffer.toString();
			System.out.println(responeseData);
			
			JSONObject jsonResponse = new JSONObject(responeseData);
			
			JSONObject jsonData = jsonResponse.getJSONObject("getFoodKr");

			
			JSONArray items = jsonData.getJSONArray("item");
			
			for(int i=0; i<items.length(); i++) {
				JSONObject result = items.getJSONObject(i);
				System.out.println(result.getString("MAIN_TITLE"));
				System.out.println(result.getDouble("LNG"));
				System.out.println(result.getDouble("LAT"));
				System.out.println("-------------------");
			}
			
		} catch (Exception e) {
		}

	}

}
