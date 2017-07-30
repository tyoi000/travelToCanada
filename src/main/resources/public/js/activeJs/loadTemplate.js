function loadHeader(elementId){
    var jsonObj = $.parseJSON(header);
    var headerBrandHtml = addHeaderBrand(jsonObj.logo);
    // for this part, server side will directly generate List Object json data
    parseDataToNavObj(jsonObj.nav,navBars);
    var navBarsHtml = addNavigationBar(navBars);
    var finalHtml = '<nav class="navbar navbar-default" role="navigation">' + headerBrandHtml + navBarsHtml + '</nav>';
    $("#" + elementId).html(finalHtml);
}

var navBars = new Array();

function parseDataToNavObj(navItemObj, firstLevelNavBars){

    $.each(navItemObj,function(){
        if (this.parent_item == 0){
           var navBarObj = new NavBar(this);
           firstLevelNavBars.push(navBarObj);
        }
    });

    $.each(navItemObj,function(){
        if (this.parent_item > 0){
           var navBarObj = new NavBar(this);
           var parent_item = this.parent_item;
           $.each(firstLevelNavBars,function(){
               if (parent_item == this.navId){
                   this.addSubNav(navBarObj);
               }
           });
        }
    });
}

function addHeaderBrand(brandName){
    var navHtmlBegin = '<div class="navbar-header">' +
                       '<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">' +
                       ' <span class="sr-only">Toggle navigation</span>Toggle navigation</span>' +
                       '<span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar">' +
                       '</button>' +
                       '<a class="navbar-brand" href="#">' +
                       brandName +
                       '</a></div>';
    return navHtmlBegin;
}
function NavBar(navObj){

    this.navName = navObj.item_name;
    this.navUrl = navObj.url;
    this.isActive = false;
    this.isDropDown = false;
    this.subNav = new Array();
    this.navId = navObj.item_id;
    this.addSubNav = function(navObj){
        this.subNav.push(navObj);
        this.isDropDown=true;
    };
    var url=window.location.href;
    var loc = url.substring(url.lastIndexOf('/')+1, url.length);
    if ( loc == this.navUrl){
        this.isActive = true;
    }
}

function addNavigationBar(navList){
    var navbarHtml = '<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">' +
                     '<ul class="nav navbar-nav">';

    $.each(navList,function(){

        var label = "";
        var navNameHtml = "";
        if (this.isActive){
            label = label + " active";
        }

        if (this.isDropDown){
            label = label + " dropdown";
            navNameHtml =  '<a href="#" class="dropdown-toggle" data-toggle="dropdown">' +
                           this.navName +
                           '<strong class="caret"></strong></a>';
            var subNavHtml = '<ul class="dropdown-menu">';
            $.each(this.subNav,function(){
                subNavHtml = subNavHtml + '<li>' + '<a href="' + this.navUrl + '">' + this.navName + '</a><li>';
            });

            subNavHtml = subNavHtml + '</ul>';
            navNameHtml = navNameHtml + subNavHtml;
        } else {
            navNameHtml = '<a href="' + this.navUrl + '">' + this.navName + '</a>';
        }

        if (label == ""){
        } else {
           label = 'class="' + label + '"';
        }
        var itemHtml = '<li ' + label + '>' + navNameHtml + '</li>';
        navbarHtml = navbarHtml + itemHtml;

    });
    navbarHtml = navbarHtml + '</ul></div>';
    return navbarHtml;
}

function loadSubNav(subNavId){
	var subNavHtml = addSubNav(navBars);
	$("#" + subNavId).html(subNavHtml);

}

function addSubNav(navList){
        var subNavHtml = "";
		$.each(navList,function(){
            if(this.subNav.length==0){
				return true;
			}
			var subNavGroupFound = false;
			$.each(this.subNav, function(){

			    if (this.isActive == true){
					subNavGroupFound = true;
					subNavHtml = subNavHtml + '<li role="presentation" class="active">';
				}else {
					subNavHtml = subNavHtml + '<li role="presentation">';
				}
				subNavHtml = subNavHtml + '<a href="'+this.navUrl+'">' + this.navName + '</a>';

			});

			if (subNavGroupFound == false){
			    subNavHtml = "";
			} else {
				return false;
			}

		});
	   return subNavHtml;
}

function loadCopyright(copyrightId){
   var copyrightHtml = '<div class="container">' +
                    '<div class="row">' +
                    '<div class="col-sm-12">' +
                    '<span>Copyright © <a href="http://expo.bootcss.com">Celadon</a></span> |' +
                    '<span><a href="http://www.miibeian.gov.cn/" target="_blank">青瓷</a></span>' +
                    '</div>' +
                    '</div>' +
                    '</div>';

   $("#" + copyrightId).html(copyrightHtml);
}

function loadFooter(footerId){
   var footerHtml = "" +
        '<div class="container" stype="background-color:black">' +
            '<div class="row clearfix">' +
                '<div class="col-sm-4">' +
                    '<div class="widget">' +
                        '<h4 class="title">友情链接</h4>' +
                        '<div class="content friend-links">' +
                            '<a href="http://www.bootcss.com/" title="加拿大留学链接1"  target="_blank">加拿大留学链接1</a>' +
                            '<a href="http://www.golaravel.com/" title="加拿大留学链接2" target="_blank">加拿大留学链接2</a>' +
                        '</div>' +
                    '</div>' +
                '</div>' +
                '<div class="col-sm-4">' +
                    '<div class="widget">' +
                       '<h4 class="title">联系我们</h4>' +
                        '<address>' +
                            '<strong>China, Inc.</strong>' +
                            '<br/> 795 Folsom Ave, Suite 600' +
                            '<br/> San Francisco, CA94107' +
                            '<br/>' +
                            '<abbr title="Phone">P:</abbr> (123) 456-7890' +
                        '</address>' +
                    '</div>' +
                '</div>' +

            '</div>' +
       '</div>';
   $("#" + footerId).html(footerHtml);
}