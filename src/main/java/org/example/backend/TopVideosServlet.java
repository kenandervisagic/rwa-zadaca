package org.example.backend;

import jakarta.servlet.annotation.WebServlet;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/topVideosServlet")
public class TopVideosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch data from your database or other source
        List<Video> videos = VideoDAO.getTopFive(); // Assuming you have a method to fetch top videos

        // Convert the data to JSON format
        String jsonData = new Gson().toJson(videos);

        // Set response content type to JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Write JSON data to response
        PrintWriter out = response.getWriter();
        out.write(jsonData);
        out.close();
    }
}