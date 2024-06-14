package org.example.backend;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.backend.Video;
import org.example.backend.VideoDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String votedVideoId = request.getParameter("votedVideoId");
        String otherVideoId = request.getParameter("otherVideoId");

        if (votedVideoId != null && otherVideoId != null) {
            int votedId = Integer.parseInt(votedVideoId);
            int otherId = Integer.parseInt(otherVideoId);

            VideoDAO.incrementPositiveVotes(votedId);
            VideoDAO.incrementTotalVotes(votedId);
            VideoDAO.incrementTotalVotes(otherId);

            List<Video> videos = VideoDAO.getRandomVideos(2);
            String json = new Gson().toJson(videos);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.write(json);
            out.close();
        }
    }
}
