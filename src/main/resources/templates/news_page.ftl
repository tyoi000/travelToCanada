<!DOCTYPE html>
<html>
<head>
    <title>加拿大留学移民</title>
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
                        <li class="active">${currentPage.displayName}</li>
                    </ol>
                </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-1 column ">
            <img src="image/news_title.jpg" alt="..." style="overflow :hidden" width="100px" height="400px"/>
        </div>
        <div class="col-md-11 column">
            <ul class="media-list" id="summaryList">
                <#list item_summary as article>
                <a href="${article.htmlLink}" class="page_${article.pageNumber}">
                <li class="media highlight">
                    <div class="media-left">

                            <img class="media-object" src="image/city.jpg" alt="..." class="img-rounded"
                                         width="64px" height="64px">

                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">${article.title}
                            <small>${article.publishTime}</small>
                        </h4>
                                ${article.introduction}
                            </div>
                </li>
                </a>
                </#list>
            </ul>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-4 col-md-offset-5 column">
            <nav aria-label="Page navigation">
                <ul class="pagination" id="pages">
                </ul>
            </nav>
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
    var pageTotal=${pageTotal};
    var currentPage=0;
    loadHeader("navigator");
    loadFooter("footer_area");
    loadCopyright("copy_right_area");
	pagination();
	pageNumClick();
	$("#summaryList a").css("display","none");
	$("#firstPage").click();
	$("#firstPage").focus();


	function pagination(){
	    var pageHtml = "";
	    for(var i=1;i<=pageTotal; i++){
		     if (i == 1){
			     pageHtml = pageHtml + '<li><a href="#" class="pageNum" id="firstPage">'+i+'</a></li>'
			 }else {
			     pageHtml = pageHtml + '<li><a href="#" class="pageNum">'+i+'</a></li>'
			 }

		}

		$("#pages").html(pageHtml);
	}

	function pageNumClick(){
	    $(".pageNum").click(function(){
		    var pageNum = this.text;
			if (currentPage == pageNum){
			    // do nothing
			} else {
			    $(".page_" + currentPage).hide();
				$(".page_" + pageNum).show();
				currentPage = pageNum;
			}
		});
	}

</script>
</body>
</html>