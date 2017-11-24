pathName = window.location.pathname;
rootPath = pathName.substr(0, pathName.indexOf("/", 2));
function login() {
    var username = $("#userName").val();
    var password = $("#passWord").val();
    $.ajax({
        type: "post",
        url: rootPath + "/login/userQuery",
        data: "username=" + username + "&password=" + password,
        dataType: "json",
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',//防止乱码
        success: function (data) {
            window.location.href = rootPath+"/html/homePage?username="+data.username;
        },
        error: function (data) {
            alert("用户名或密码不正确!");
        }

    })

}
$(function () {
    document.onkeydown = function (e) {
        var ev = document.all ? window.event : e;
        if (ev.keyCode == 13) {
            login();//处理事件
        }
    }
    $("#login").click(function () {
        login();
    });
});