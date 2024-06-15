function fetchVideoData() {
    fetch('/rwa_zadaca_war_exploded/randomVideos')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        }).then(data => {
        const videoContainer = document.getElementById('videoContainer');
        videoContainer.innerHTML = `
    <div class="video-item left-enter">
        <p>${data[0].title}</p>
         <iframe id="${data[0].id}" src='https://www.youtube.com/embed/${data[0].embedCode}'></iframe>
        <button class="google-button-style" role="button" onclick="vote(${data[0].id}, ${data[1].id})" >Vote</button>
    </div>
    <div class="video-item right-enter">
        <p>${data[1].title}</p>
         <iframe id="${data[1].id}" src='https://www.youtube.com/embed/${data[1].embedCode}'></iframe>
        <button class="google-button-style" role="button" onclick="vote(${data[1].id}, ${data[0].id})">Vote</button>
    </div>
            `;
    })
        .catch(error => console.error('Error fetching video:', error));
}

function updateVideoData(data) {
    // Update the left video item
    $(".video-item.left-enter p").text(data[0].title); // Update title
    $(".video-item.left-enter iframe").attr("src", 'https://www.youtube.com/embed/' + data[0].embedCode); // Update embed code
    $(".video-item.left-enter iframe").attr("id", `${data[0].id}`); // Update id
    $(".video-item.left-enter button").attr("onclick", `vote(${data[0].id}, ${data[1].id})`); // Update id

    // Update the right video item
    $(".video-item.right-enter p").text(data[1].title); // Update title
    $(".video-item.right-enter iframe").attr("src", 'https://www.youtube.com/embed/' + data[1].embedCode); // Update embed code
    $(".video-item.right-enter iframe").attr("id", `${data[1].id}`); // Update id}
    $(".video-item.right-enter button").attr("onclick", `vote(${data[1].id}, ${data[0].id})`); // Update id}
}

function refreshVideos() {
    $.ajax({
        url: "/rwa_zadaca_war_exploded/randomVideos",
        type: "POST", // HTTP method (GET in this case)
        dataType: "json", // Expected data type of the response
        data: {"data": "refresh"},
        success: function (data) {
            // Handle the JSON data received from the servlet
            // For example, update the DOM with the new video information
            updateVideoData(data);
            console.log(data[0].id)
        },
        error: function (xhr, status, error) {
            console.error("Error fetching videos:", error);
        }
    });
}

function fetchTopVideos(videoCount) {
    $.ajax({
        url: '/rwa_zadaca_war_exploded/topVideosServlet',
        type: 'POST', // Use POST request
        data: JSON.stringify({ count: videoCount }), // Send the desired number of videos
        contentType: 'application/json', // Set the content type to JSON
        dataType: 'json',
        success: function (data) {
            populateTable(data);
        },
        error: function (xhr, status, error) {
            console.error('Error fetching top videos:', error);
        }
    });
}

function populateTable(data) {
    var tableBody = $('.video-table tbody');
    tableBody.empty(); // Clear existing table rows
    data.forEach(function (video, index) {
        const row = $('<tr>');
        row.append('<td><img src="http://img.youtube.com/vi/' + video.embedCode + '/maxresdefault.jpg" alt="' + video.title + '"></td>');
        row.append('<td>' + video.title + '</td>');
        row.append('<td>' + (video.positiveVotes + "/" + video.totalVotes) + '</td>');
        row.append('<td>' + (index + 1) + '</td>');
        tableBody.append(row);
    });
}

function vote(videoId, otherVideoId) {
    $.ajax({
        url: "/rwa_zadaca_war_exploded/vote",
        type: "POST",
        dataType: "json",
        data: {
            votedVideoId: videoId,
            otherVideoId: otherVideoId
        },
        success: function (data) {
            updateVideoData(data);
        },
        error: function (xhr, status, error) {
            console.error("Error voting:", error);
        }
    });
}

$(document).ready(function () {
    console.log('Document ready, calling fetchTopVideos');
    fetchTopVideos(5);
});
document.getElementById('shareIcon').addEventListener('click', function(event) {
    event.preventDefault();
    const shareOptions = document.createElement('div');
    shareOptions.className = 'share-options';
    shareOptions.innerHTML = `
        <button class="copy-link">Copy Link</button>
        <a href="https://twitter.com/share?url=https://www.youtube.com/watch?v=${getVideoId()}" target="_blank">Share on Twitter</a>
    `;
    document.body.appendChild(shareOptions);
});

function getVideoId() {
    // Assuming you want to share the first video in the container
    const iframe = document.querySelector('#videoContainer iframe');
    if (iframe) {
        return iframe.getAttribute('src').split('/embed/')[1];
    }
    return '';
}

document.addEventListener('click', function(event) {
    if (event.target.classList.contains('copy-link')) {
        const videoId = getVideoId();
        const videoLink = `https://www.youtube.com/watch?v=${videoId}`;
        navigator.clipboard.writeText(videoLink).then(() => {
            alert('Link copied to clipboard');
        }).catch(err => {
            console.error('Failed to copy link: ', err);
        });
    }
});
