//创建编辑器
var E = window.wangEditor;
var editor = new E('#div1','#div2');  // 两个参数也可以传入 elem 对象，class 选择器
//editor.customConfig.uploadImgShowBase64 = true   // 使用 base64 保存图片
editor.customConfig.uploadImgServer = '/blog/cn.forlkc.servlet/FileServlet';  // 上传图片到服务器
var imgUrl = '/blog/images/1.jpg';
function a (){
    imgUrl = '/blog/images/1.jpg';
}


editor.customConfig.customUploadImg = function (files, insert) {//对上传的图片进行处理，图片上传的方式
    var data = new FormData();
    data.append("img", files[0])
    $.ajax({
        url: "/blog/cn.forlkc.servlet/FileServlet",
        type: "post",
        data: data,
        processData: false,
        contentType: false,
        success: function (data) {
            var json = JSON.parse(data);
            imgUrl = json.imgUrl;
            //这里是对图片格式进行处理，我这里因为是要保存到本地服务器上，将图片前缀修改
           editor.cmd.do('insertHTML', '<img style="text-align: center" src="'+ imgUrl+'" alt="">')

        },
        error: function () {
            alert("图片上传错误")
        }
    })

}

editor.create();

//获取search词
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
$("#btn1").click(function () {
    var centent = editor.txt.html();  // 获取 text格式的内容
    var json = editor.txt.getJSON()  // 获取 JSON 格式的内容

    //alert(imgUrl)
    var title = $("#title").val();
    if(title ===''){
        alert("标题不能为空")
    }else {
        var description = $("#description").val();
        var type = GetRequest();
        var arr = {
            "title": title,
            "description": description,
            "type": type.from,
            "img": imgUrl,
            "centent": centent
        };

        $.ajax({
            cache: true,//保留缓存数据
            type: "POST",
            url: "/blog/cn.forlkc.servlet/AddArticleServlet",//这是我在后台接受数据的文件名
            data: {
                "blog": JSON.stringify(arr)
            },
            async: false,//设置成true，这标志着在请求开始后，其他代码依然能够执行。如果把这个选项设置成false，这意味着所有的请求都不再是异步的了，这也会导致浏览器被锁死
            error: function (request) {//请求失败之后的操作
                alert("连接失败")
            },
            success: function (msg) {//请求成功之后的操作
                var json = JSON.parse(msg);
                if (json.status === 200) {
                    self.location = document.referrer;
                } else {
                    alert(json.desc);
                }

            }
        });
        return false;
    }
})
