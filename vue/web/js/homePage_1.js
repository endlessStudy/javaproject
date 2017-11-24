$(function () {
    console.log(username);
    $("#navigate li").click(function () {
        $(this).addClass("active").siblings().removeClass("active");
    });
})