//请求分类信息
function initItemize(id){
	$.ajax({
		url:"/web/itemize",
		method:"get",
		type:"json",
		data:{itemId:id},
		success:function(data){
			if(data.status == 200){
				data = data.data;
				if(id == 1){
					for(var i = 0;i < data.length;i++){
						$("#itemize").append("<li id="+data[i].id+">"+
							"<a href='' onfocus='initItemize("+data[i].id+")'>"+data[i].title+"</a>"+
						"<div class='pop'><div class='left fl'></div></div></li>")
					}
				}else{
					var item = $("#"+data.id).find(".pop").find(".fl");
					for(var i = 0;i<data.length;i++){
						$(item).append("<div>"
									"<div class='xuangou_left fl'>"+
										"<a href=''>"+
											"<div class='img fl'><img src='"+data[i].img+"' alt=''></div>"+
											"<span class='fl'>"+data[i].title+"</span>"+
											"<div class='clear'></div>"+
										"</a>"+
									"</div>"+
									"<div class='xuangou_right fr'><a href='./xiangqing.html'>选购</a></div>"+
									"<div class='clear'></div>"+
								"</div>")
					}
				}
			}
		}
	})
}
//获取banner图片
function getBanner(dom,id){
	$.ajax({
		url:"/web/banner/"+id,
		method:"get",
		async:false,
		success:function(data){
			if(data.status == 200){
				data = data.data;
				//$(dom).css(background:) 
			}
		}
	})
}
//初始化热销商品
function initHotItem(){
	$.ajax({
		url:"/web/hot",
		method:"get",
		async:false,
		success:function(data){
			if(data.status == 200){
				data = data.data;
				for(var i = 0;i < data.length;i++){
					$("#hot-items").append("<div class='mingxing fl'>"+
					"<div class='sub_mingxing'><a href=''><img src='"+data[i].img+"'></a></div>"+
					"<div class='pinpai'><a href=''>"+data[i].title+"</a></div>"+
					"<div class='youhui'>"+data[i].desc+"</div>"+
					"<div class='jiage'>"+data[i].price+"</div>"+
				"</div>")
				}
			}
		}
	})
}
