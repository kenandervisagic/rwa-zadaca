<%--
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
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/table.css">
    <link rel="icon" type="image/jpg" href="https://www.shutterstock.com/image-vector/hand-voting-ballot-box-icon-600nw-1340887919.jpg">
    <title>Rankings</title>
</head>
<body>
<div class="navbar">
    <div class="navbar-first-line">
        <p>Rankings</p>
        <p>
            <a href="#" class="icon-link">
                <i class="fas fa-sync-alt"></i>
            </a>
            <a href="#" class="icon-link">
                <i class="fas fa-share-alt"></i>
            </a>
        </p>
    </div>
    <div class="navigation">
        <a href="home.html">Home</a>
        <a href="ranking.html">Rankings</a>
    </div>
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
    <tr>
        <td><img src="http://img.youtube.com/vi/HS7eJEUYtyU/maxresdefault.jpg" alt="Image 1"></td>
        <td>Dino Merlin - Kad zamirisu jorgovani</td>
        <td>10/10</td>
        <td>1</td>
    </tr>
    <tr>
        <td><img src="http://img.youtube.com/vi/i78bV7KbzAI/maxresdefault.jpg" alt="Image 2"></td>
        <td>Sasa Matic - Kad ljubav zakasni</td>
        <td>9/10</td>
        <td>2</td>
    </tr>

    <tr>
        <td><img src="http://img.youtube.com/vi/gxJEMsppj1s/maxresdefault.jpg" alt="Image 2"></td>
        <td>Sasa Matic - Idemo Andjele</td>
        <td>6/10</td>
        <td>3</td>
    </tr>
    <tr>
        <td><img src="http://img.youtube.com/vi/-DhCgrpPUvQ/maxresdefault.jpg" alt="Image 2"></td>
        <td>Zdravko Colic - Biraj Ti</td>
        <td>5/10</td>
        <td>4</td>
    </tr>
    <tr>
        <td><img src="http://img.youtube.com/vi/ExUxI3HBY38/maxresdefault.jpg" alt="Image 2"></td>
        <td>Aco Pejovic - Ne pitaj</td>
        <td>4/10</td>
        <td>5</td>
    </tr>

    <tr>
        <td><img src="http://img.youtube.com/vi/IBlxAhVVIZ0/maxresdefault.jpg" alt="Image 2"></td>
        <td>Sasa Kovacevic - Prevarena</td>
        <td>3/10</td>
        <td>6</td>
    </tr>
    <tr>
        <td><img src="http://img.youtube.com/vi/Uyq0eazCFaI/maxresdefault.jpg" alt="Image 8"></td>
        <td>Aleksandra Prijovic - Zvuk Tisine</td>
        <td>2/10</td>
        <td>7</td>
    </tr>

    <tr>
        <td><img src="http://img.youtube.com/vi/IWti5VDb2-U/maxresdefault.jpg" alt="Image 8"></td>
        <td>Aleksandra Prijovic - Dam Dam Dam</td>
        <td>2/10</td>
        <td>8</td>
    </tr>

    <tr>
        <td><img src="http://img.youtube.com/vi/JR6jmsvE7tI/maxresdefault.jpg" alt="Image 8"></td>
        <td>ET - Tek je 12 sati</td>
        <td>2/10</td>
        <td>9</td>
    </tr>
    </tbody>
    <tfoot>
    <tr>
        <td colspan="4">
            <ul class="pagination">
                <li class="active"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>

            </ul>
        </td>
    </tr>
    </tfoot>
</table>
</body>
</html>