package org.example.frontend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.backend.Video;
import org.example.backend.VideoDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Video> videos = VideoDAO.getRandomVideos(2); // Fetch 2 random videos
//        request.setAttribute("video", videos.get(0));
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
