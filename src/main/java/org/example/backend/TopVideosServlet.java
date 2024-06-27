package org.example.backend;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static org.example.backend.VideoDAO.getTop;
import static org.example.backend.VideoDAO.getTotalVideoCount;

@WebServlet("/topVideosServlet")
public class TopVideosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        List<Video> videos = getTop(page, pageSize);
        int totalVideoCount = getTotalVideoCount();
        int totalPages = (int) Math.ceil((double) totalVideoCount / pageSize);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        String json = gson.toJson(new VideoResponse(videos, totalPages));
        response.getWriter().write(json);
    }

    private static class VideoResponse {
        List<Video> videos;
        int totalPages;

        VideoResponse(List<Video> videos, int totalPages) {
            this.videos = videos;
            this.totalPages = totalPages;
        }
    }
}
