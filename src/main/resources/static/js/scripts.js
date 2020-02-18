$(document).ready(function () {
    $("#joke-text").load("/getjoke");
});

$(document).ready(function () {
    $("#joke-button").click(function () {
        $("#joke-text").load("/getjoke");
        var images = [];
        images[0] = 'img/chuck01.png';
        images[1] = 'img/chuck02.png';
        images[2] = 'img/chuck03.png';
        images[3] = 'img/chuck04.png';
        images[4] = 'img/chuck05.png';
        images[5] = 'img/chuck06.png';
        var randomNumber = Math.floor(Math.random() * images.length);
        $("#chuck-img").attr("src", images[randomNumber]);
    })
});

$(document).ready(function () {
    $("#joke-button").click(function () {
        var colors = [];
        colors[0] = 'CadetBlue';
        colors[1] = 'CornflowerBlue';
        colors[2] = 'DarkBlue';
        colors[3] = 'DarkSlateBlue';
        colors[4] = 'DimGrey';
        colors[5] = 'Maroon';
        var randomNumber = Math.floor(Math.random() * colors.length);
        $("body").css("background-color", colors[randomNumber]);
    });
});