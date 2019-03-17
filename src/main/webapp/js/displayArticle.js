//切割出文件名
var strUrl=window.location.href;
var arrUrl=strUrl.split("/");

//去除后缀
var strPage=arrUrl[arrUrl.length-1];
var filename = strPage.split(".");

var types = filename[0];
if(types ==="index" || types === ''){
    types = 'all'
}


$.ajax({
    cache: true,//保留缓存数据
    type: "GET",//为post请求
    url: "/blog/cn.forlkc.servlet/ArticleServlet?type="+types,
    async: false,//设置成true，这标志着在请求开始后，其他代码依然能够执行。如果把这个选项设置成false，这意味着所有的请求都不再是异步的了，这也会导致浏览器被锁死
    error: function (request) {//请求失败之后的操作
        alert("失败")
    },
    success: function (msg) {//请求成功之后的操作
        var json = JSON.parse(msg);
        //console.log(json);
        var str="";
        //var k=0;
        for(var i=0,k=0;i<3;i++){

            str+="<div class=\"row\">"
            for(var j=0 ; j<2 ; j++,k++){
                if(k>=Object.keys(json).length-1){
                    break;
                }
                str+=" <div class=\"col-1-2\">\n" +
                    "                            <article>\n" +
                    "                                <div class=\"post-thumbnail-wrap\">\n" +
                    "                                    <a href=\"/blog/html/single.html?id="+json[k].blogid+"\" class=\"portfolio-box\">\n" +
                    "                                        <img src=\""+json[k].image+"\" style=\"width: 590px;height: 350px;\" >\n" +
                    "                                        <div class=\"portfolio-box-caption\">\n" +
                    "                                            <div class=\"portfolio-box-caption-content\">\n" +
                    "                                                <div class=\"project-text\">"+json[k].description+"</div>\n" +
                    "                                            </div>\n" +
                    "                                        </div>\n" +
                    "                                    </a>\n" +
                    "                                </div>\n" +
                    "                                <div class=\"entry-header \">\n" +
                    "                                    <h3 class=\"entry-title\">"+json[k].title+"</h3>\n" +
                    "                                    <div class=\"l-tags\"><a href=\"#\">"+json[k].author+"</a> / <a href=\"#\">"+json[k].type+"</a> / <a href=\"#\">"+json[k].formatTime+"</a></div>\n" +
                    "                                </div>\n" +
                    "                            </article>\n" +
                    "                        </div>";

            }
        str+="</div>";
        }
        $('#articleDislplay').html(str);
    }
});