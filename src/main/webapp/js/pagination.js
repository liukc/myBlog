//切割出文件名
var strUrl = window.location.href;
var arrUrl = strUrl.split("/");

//去除后缀
var strPage = arrUrl[arrUrl.length - 1];
var filename = strPage.split(".");

var types = filename[0];
if (types === "index" || types === '') {
    types = 'all'
}
var totalpage = 0;
var nextpage = 0;


//分页操作
function changePage(toPage) {
    if (toPage === "end") {
        nextpage = totalpage;
    } else if (toPage === "first") {
        nextpage = 0;
    } else if (toPage === "prev") {
        if (nextpage > 0) {
            nextpage = (nextpage - 1);
        } else {
            alert("已是第一页！");
            return;
        }
    } else {
        if (nextpage < totalpage) {
            nextpage = (nextpage + 1);
        } else {
            alert("已是最后一页");
            return;
        }
    }
    nextPage();
}

function getJsonLength(jsonData) {
    var jsonLength = 0;
    for (var item in jsonData) {
        jsonLength++;
    }
    return jsonLength;
}

function nextPage() {
    $.ajax({
        cache: true,
        type: "POST",
        url: "/blog/cn.forlkc.servlet/PageServlet",
        data: {
            type: types,
            toPage: nextpage,
        },
        async: true,
        error: function (request) {
            var json = JSON.parse(request)

            console.log(json.decs)
        },
        success: function (msg) {
            var json = JSON.parse(msg);
            console.log(json);
            var length = getJsonLength(json);
            totalpage = parseInt(json[length-1].allPage);
            //var pageNum = parseInt(json[0].pageNum);
            console.log("json长度：" + getJsonLength(json));

            var str = "";
            //var k=0;
            for (var i = 0, k = 0; i < 3; i++) {

                str += "<div class=\"row\">"
                for (var j = 0; j < 2; j++, k++) {
                    if (k >= length - 1) {
                        break;
                    }
                    str += " <div class=\"col-1-2\">\n" +
                        "                            <article>\n" +
                        "                                <div class=\"post-thumbnail-wrap\">\n" +
                        "                                    <a href=\"/blog/html/single.html?id=" + json[k].blogid + "\" class=\"portfolio-box\">\n" +
                        "                                        <img src=\"" + json[k].image + "\" style=\"width: 590px;height: 350px;\" >\n" +
                        "                                        <div class=\"portfolio-box-caption\">\n" +
                        "                                            <div class=\"portfolio-box-caption-content\">\n" +
                        "                                                <div class=\"project-text\">" + json[k].description + "</div>\n" +
                        "                                            </div>\n" +
                        "                                        </div>\n" +
                        "                                    </a>\n" +
                        "                                </div>\n" +
                        "                                <div class=\"entry-header \">\n" +
                        "                                    <h3 class=\"entry-title\">" + json[k].title + "</h3>\n" +
                        "                                    <div class=\"l-tags\"><a href=\"#\">" + json[k].author + "</a> / <a href=\"#\">" + json[k].type + "</a> / <a href=\"#\">" + json[k].formatTime + "</a></div>\n" +
                        "                                </div>\n" +
                        "                            </article>\n" +
                        "                        </div>";

                }
                str += "</div>";
            }
            $('#articleDislplay').html(str);
            $('#PNumber').html(nextpage);
            console.log("总页数：" + totalpage)
        }
    })
}
