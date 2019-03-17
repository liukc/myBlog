$(function () {
    var userName = $.cookie("userName");
    var status = $.cookie("status");
    //alert(userName)
    if(status === "200"){
        $('#showlogin').html("<a href=\"/blog/html/personal.html\">"+userName+"</a>");
    }
})