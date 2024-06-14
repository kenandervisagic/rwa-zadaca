package org.example.backend;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jakarta.servlet.annotation.WebServlet;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/topVideosServlet")
public class TopVideosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Read the JSON data from the request body
        BufferedReader reader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String jsonData = stringBuilder.toString();

        // Parse the JSON data to extract the count value
        JsonObject jsonObject = JsonParser.parseString(jsonData).getAsJsonObject();
        int videoCount = jsonObject.get("count").getAsInt();

        // Fetch data from your database or other source
        List<Video> videos = VideoDAO.getTop(videoCount); // Assuming you have a method to fetch top videos

        // Convert the data to JSON format
        String jsonResponse = new Gson().toJson(videos);

        // Set response content type to JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Write JSON data to response
        PrintWriter out = response.getWriter();
        out.write(jsonResponse);
        out.close();
    }
}
