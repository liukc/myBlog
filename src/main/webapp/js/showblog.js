function GetRequest() {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}

var id = GetRequest().id;

$.ajax({
    cache: true,//保留缓存数据
    type: "POST",
    url: "/blog/cn.forlkc.servlet/ShowServlet?id="+id,//这是我在后台接受数据的文件

    async: false,//设置成true，这标志着在请求开始后，其他代码依然能够执行。如果把这个选项设置成false，这意味着所有的请求都不再是异步的了，这也会导致浏览器被锁死
    error: function (request) {//请求失败之后的操作
        alert("请求失败")
    },
    success: function (msg) {//请求成功之后的操作
        var json = JSON.parse(msg);
        if(json.status === 200) {
            console.log(json)
            $('#title').html(json.title);
            $('#author').html(json.author);
            $('#content').html(json.content);
            $('#time').html(json.formatTime);
        }else{
            alert(json.desc);
        }

    }
})