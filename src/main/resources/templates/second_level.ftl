<!DOCTYPE html>
<html>
<head>
    <title>加拿大留学移民</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/site.min.css" rel="stylesheet">
    <style type="text/css">
	      .index_content_title{
		      border-bottom:4px double #e5311a;
			  padding:0 0 5px 6px;
			  font-weight:bold;
			  margin:10px 2px;
		  }
	      .highlight{
              padding:2px 2px;
			  border-radius:5px;
			  transition-duration:0.3s;
			  transition-property:box-shadow;
			  transform:translateZ(0);
		  }
	      .highlight:hover{
              box-shadow:0 0 8px rgba(0, 0, 0, 0.6);
			  background:#F5F8FA;
		  }
		  
		  .index_content li{
		      color:#8e99a0;
			  overflow:hidden;
		  }
		  
		  .index_content ul{
              list-style:none outside;
			  text-decoration:none;
			  padding:0px;
		  }	    
		  

    </style>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column" id="navigator">
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-2 column">
            <ul class="nav nav-pills nav-stacked" id="subNav">
            </ul>
        </div>
        <div class="col-md-10 column highlight">
            <div style="display:block">
			    <h3 class="index_content_title">
                   <img src="image/canada_flag.jpg" style="float:left" width="50px"/> &nbsp;&nbsp;
				       ${currentPage.pageDisplayName}
                   </span>
               </h3>
                ${static_area}
            </div>
        </div>
    </div>
</div>
<footer class="main-footer">
    <div class="container" stype="background-color:black">
        <div class="row clearfix">
            <div class="col-sm-4">
                <div class="widget">
                    <h4 class="title">友情链接</h4>
                    <div class="content friend-links">
                        <a href="http://www.bootcss.com/" title="加拿大留学链接1"
                           onclick="_hmt.push(['_trackEvent', 'link', 'click', 'Bootstrap中文网'])" target="_blank">加拿大留学链接1</a>
                        <a href="http://www.golaravel.com/" title="加拿大留学链接2"
                           onclick="_hmt.push(['_trackEvent', 'link', 'click', 'Laravel中文网'])"
                           target="_blank">加拿大留学链接2</a>
                    </div>
                </div>
            </div>

            <div class="col-sm-4">
                <div class="widget">
                    <h4 class="title">联系我们</h4>
                    <address><strong>China, Inc.</strong><br/> 795 Folsom Ave, Suite 600<br/> San Francisco, CA
                        94107<br/> <abbr title="Phone">P:</abbr> (123) 456-7890
                    </address>
                </div>
            </div>
        </div>
    </div>
</footer>
<div class="copyright">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <span>Copyright © <a href="http://expo.bootcss.com">Celadon</a></span> |
                <span><a href="http://www.miibeian.gov.cn/" target="_blank">青瓷</a></span>
            </div>
        </div>
    </div>
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
    loadSubNav("subNav");
</script>
</body>
</html>