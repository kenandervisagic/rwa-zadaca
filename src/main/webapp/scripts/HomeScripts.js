
function fetchVideoData() {
    fetch('/rwa_zadaca_war_exploded/randomVideos')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })        .then(data => {
            console.log(data)
            const videoContainer = document.getElementById('videoContainer');
            videoContainer.innerHTML = `
    <div class="video-item left-enter">
        <p>${data[0].title}</p>
         <iframe src='https://www.youtube.com/embed/${data[0].embedCode}'></iframe>
        <button class="google-button-style" role="button">Vote</button>
    </div>
    <div class="video-item right-enter">
        <p>${data[1].title}</p>
         <iframe src='https://www.youtube.com/embed/${data[1].embedCode}'></iframe>
        <button class="google-button-style" role="button">Vote</button>
    </div>
            `;
        })
        .catch(error => console.error('Error fetching video:', error));
}
function refreshVideos() {
    $.ajax({
        url: "/rwa_zadaca_war_exploded/randomVideos",
        type: "POST", // HTTP method (GET in this case)
        dataType: "json", // Expected data type of the response
        data:{"data":"refresh"},
        success: function(data) {
            // Handle the JSON data received from the servlet
            // For example, update the DOM with the new video information
             updateVideoData(data);
        },
        error: function(xhr, status, error) {
            console.error("Error fetching videos:", error);
        }
    });
}
function updateVideoData(data) {
    // Update the left video item
    $(".video-item.left-enter p").text(data[0].title); // Update title
    $(".video-item.left-enter iframe").attr("src",'https://www.youtube.com/embed/' + data[0].embedCode); // Update embed code

    // Update the right video item
    $(".video-item.right-enter p").text(data[1].title); // Update title
    $(".video-item.right-enter iframe").attr("src", 'https://www.youtube.com/embed/' + data[1].embedCode); // Update embed code
}
function fetchTopVideos() {
    $.ajax({
        url: '/rwa_zadaca_war_exploded/topVideosServlet',
        type: 'GET', // Use GET request
        dataType: 'json',
        success: function(data) {
            populateTable(data);
        },
        error: function(xhr, status, error) {
            console.error('Error fetching top videos:', error);
        }
    });
}
function populateTable(data) {
    var tableBody = $('.video-table tbody');
    tableBody.empty(); // Clear existing table rows
    data.forEach(function(video) {
        const row = $('<tr>');
        //<td><img src="http://img.youtube.com/vi/HS7eJEUYtyU/maxresdefault.jpg" alt="Image 1"></td>
        row.append('<td><img src="http://img.youtube.com/vi/' + video.embedCode + '/maxresdefault.jpg" alt="' + video.title + '"></td>');
        row.append('<td>' + video.title + '</td>');
        row.append('<td>' + (video.positiveVotes / video.totalVotes) + '</td>');
        row.append('<td>' + video.totalVotes + '</td>'); //TODO: add rank
        tableBody.append(row);
    });
}
$(document).ready(function() {
    console.log('Document ready, calling fetchTopVideos');
    fetchTopVideos();
});
