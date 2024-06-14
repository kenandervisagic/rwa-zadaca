<%@ page import="org.example.backend.Video" %><%--
  Created by IntelliJ IDEA.
  User: Kenan
  Date: 6/12/2024
  Time: 10:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="styles/table.css">
    <link rel="stylesheet" href="styles/style.css">
    <link rel="icon" type="image/jpg" href="https://www.shutterstock.com/image-vector/hand-voting-ballot-box-icon-600nw-1340887919.jpg">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>Home</title>
</head>
<body onload="fetchVideoData()">
<div class="navbar">
    <div class="navbar-first-line">
        <p>Video voting competition</p>
        <p>
            <a class="icon-link" onclick="refreshVideos()">
                <i class="fas fa-sync-alt"></i>
            </a>
            <a id="shareIcon" href="" class="icon-link">
                <i class="fas fa-share-alt"></i>
            </a>
        </p>
    </div>
    <div class="navigation">
        <a href="home">Home</a>
        <a href="rankings">Rankings</a>
    </div>
</div>
<div class="video-container" id="videoContainer"></div>
<div class="video-table-container">
    <div class="table-title">
        <h2>Top 5 Videos</h2>
    </div>
    <table class="video-table">
        <thead>
        <tr>
            <th>Thumbnail</th>
            <th>Title</th>
            <th>Score</th>
            <th>Rank</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>
<script src="scripts/HomeScripts.js"></script>
</body>
</html>