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
                        <li><a href="index.html">首页</a></li>
                        <li><a href="#">新闻热点</a></li>
                        <li class="active">${article.title}</li>
                    </ol>
                </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-1 column ">
            <img src="image/news_title.jpg" alt="..." style="overflow :hidden" width="100px" height="400px"/>
        </div>
        <div class="col-md-11 column">
            <div class="newsInfo_bar">
                <span>${article.publishTime}</span>
                <span>编辑：${article.author}</span>
                <span>来源：加拿大留学移民</span>
                <span>点击：${article.clickCount}</span>
            </div>
            <div class="page-header bg-info">
                <h3>${article.title}
                    <small>${article.introduction}</small>
                </h3>
            </div>
            <p class="lead">加拿大不再是一个遥远的梦了</p>
            <div style="display:block">
                <img style="float:left;padding:20px 20px 20px 20px;" src="image/city.jpg" alt="..." class="img-circle"
                     width="200px" height="200px">
                ${article.content}
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
<script src="js/activeJs/loadTemplate.js"></script>
<script>
    loadHeader("navigator");
    loadFooter("footer_area");
    loadCopyright("copy_right_area");
</script>
</body>
</html>