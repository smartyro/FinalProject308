package View;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import org.json.*;

public class Chat extends JPanel {
    String urlStr = "https://api.openai.com/v1/chat/completions";
    String apiKey = "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";
    String model = "gpt-4";

    public Chat(String input) {
        try {
            getResponse(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getResponse(String input) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer " + apiKey);

        JSONObject data = new JSONObject();
        data.put("model", model);
        data.put("prompt", input);
        data.put("max_tokens", 4000);

        con.setDoOutput(true);
        con.getOutputStream().write(data.toString().getBytes());
        OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
        writer.write(data.toString());
        writer.flush();

        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String response = "";
        String line;
        while ((line = reader.readLine()) != null) {
            response += (line);
        }
        reader.close();

        JSONObject responseJSON = new JSONObject(response.toString());
        JSONArray choices = responseJSON.getJSONArray("choices");
        String text = choices.getJSONObject(0).getString("text");
        return text.trim();
        } else {
        throw new Exception("HTTP request failed with error code: " + responseCode);
        }
    }
}
