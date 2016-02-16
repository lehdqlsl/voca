package com.example.slidingsimplesample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.res.AssetManager.AssetInputStream;
import android.util.Log;

public class JSONParser {

	static InputStream is = null;
	static JSONArray jarray = null;
	static String json = "";

	// constructor
	public JSONParser() {

	}

	public JSONArray getJSONFromUrl(AssetInputStream ais) {

		StringBuilder builder = new StringBuilder();
		// HttpClient client = new DefaultHttpClient();
		// HttpGet httpGet = new HttpGet(ais);
		try {
			// HttpResponse response = client.execute(httpGet);
			// StatusLine statusLine = response.getStatusLine();
			// int statusCode = statusLine.getStatusCode();
			// if (statusCode == 200) {
			// HttpEntity entity = response.getEntity();
			InputStream content = ais; // entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(content));
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			// } else {
			Log.e("==>", "Failed to download file");
			// }
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// try parse the string to a JSON object
		try {
			jarray = new JSONArray(builder.toString());
		} catch (JSONException e) {
			Log.e("JSON Parser", "Error parsing data " + e.toString());
		}

		// return JSON String
		return jarray;

	}
}