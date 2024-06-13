package org.example.backend;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/randomVideos")
public class RandomVideoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Video> randomVideos = VideoDAO.getRandomVideos(2);
        String json = new Gson().toJson(randomVideos);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}
