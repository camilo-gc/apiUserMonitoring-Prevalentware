package com.example.apiusermonitoring.adapters.driving.http.utils;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import lombok.extern.apachecommons.CommonsLog;

import java.io.StringReader;
import java.util.Base64;
import java.util.StringTokenizer;

@CommonsLog
public class TokenUtils {

    private TokenUtils() {
        throw new IllegalStateException("Utility class");
    }

    private static JsonObject getClaim(String token){
        StringTokenizer tokenizer = new StringTokenizer(token.substring(7), ".");

        tokenizer.nextToken();
        String payload = new String(Base64.getUrlDecoder().decode(tokenizer.nextToken()));
        return convertStringToJson(payload);
    }

    public static String getEmail(String token) {
        return getClaim(token).getString("Email");
    }

    public static String getRoleId(String token) {
        return getClaim(token).getString("Role");
    }

    private static JsonObject convertStringToJson(String jsonString) {
        try (JsonReader jsonReader = Json.createReader(new StringReader(jsonString))) {
            return jsonReader.readObject();
        }
    }

}
