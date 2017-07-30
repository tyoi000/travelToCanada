<!DOCTYPE html>
<html>
<head>
    <title>${webTitle}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="css/common.css" >
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column" id="navigator">
        </div>
    </div>
    <div class="row clearfix">
                <div class="col-md-12 column">
                    <ol class="breadcrumb">
                        <li>现在的位置 ：</li>
                        <#list visitPaths as visitPath>
                            <li><a href="${visitPath.html}">${visitPath.displayName}</a></li>
                        </#list>
                        <li class="active">${schoolInfo.title}</li>
                    </ol>
                </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-1 column ">
            <img src="image/news_title.jpg" alt="..." style="overflow :hidden" width="100px" height="400px"/>
        </div>
        <div class="col-md-11 column">
            <div class="newsInfo_bar">
                <span>${schoolInfo.publishTime?string("yyyy-MM-dd")}</span>
                <span>来源：加拿大留学移民</span>
            </div>
            <div class="page-header bg-info">
                <h3>${schoolInfo.title} &nbsp;&nbsp; 排名：${schoolInfo.ranking}位
                    <small>${schoolInfo.introduction}</small>
                </h3>
            </div>
            <div style="display:block" id="static_area">
                ${schoolInfo.content}
            </div>
        </div>
    </div>
</div>
<footer class="main-footer" id="footer_area">
</footer>
<div class="copyright" id="copy_right_area">
</div>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="js/bootstrap.min.js"></script>
<script src="js/activeJs/header.js"></script>
<script src="js/activeJs/loadTemplate.js"></script>
<script>
    loadHeader("navigator");
    loadFooter("footer_area");
    loadCopyright("copy_right_area");
</script>
</body>
</html>