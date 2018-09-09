/*
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
	xhr.setRequestHeader(header, token);
});*/

/*******************************图片上传2begin**************************************************************************************/

//$(function() {
  var tmpl = '<li imageFileUrl="imageFileUrl" class="weui-uploader__file imageFileUrl" value="#val#" style="background-image:url(#url#)"></li>',
    $gallery = $("#gallery"),
    $galleryImg = $("#galleryImg"),
    $uploaderInput = $("#uploaderInput"),
    $uploaderFiles = $("#uploaderFiles");
  $uploaderInput.on("change", function(e) {
    var src, url = window.URL || window.webkitURL || window.mozURL,files = e.target.files;
    for(var i = 0, len = files.length; i < len; ++i) {
    	var file = files[i];
    	if(url) {
    		src = url.createObjectURL(file);
    	} else {
    		src = e.target.result;
    	}
    	//$uploaderFiles.append($(tmpl.replace('#url#', src)));
    }
  });
  var index; //第几张图片
  $uploaderFiles.on("click", "li", function() {
    index = $(this).index();
    $galleryImg.attr("style", this.getAttribute("style"));
    $gallery.fadeIn(100);
  });
  $gallery.on("click", function() {
    $gallery.fadeOut(100);
  });
  //删除图片 删除图片的代码也贴出来。
  $(".weui-gallery__del").click(function() { //这部分刚才放错地方了，放到$(function(){})外面去了
    console.log('删除');
    $uploaderFiles.find("li").eq(index).remove();
  });
//});

/*******************************图片上传2end**************************************************************************************/
/*********************************************************************************************************************/


function uploadFile(){
    var fileObj = document.getElementById("uploaderInput").files[0]; // 获取文件对象
    var FileController = "/uploadPic.json"; // 接收上传文件的后台地址

    if(fileObj){
         // FormData 对象
             var form = new FormData();
             form.append("file", fileObj);// 文件对象

             // XMLHttpRequest 对象
             var xhr = new XMLHttpRequest();
             xhr.open("post", FileController, true);
             xhr.onload = function () {
                 var obj = JSON.parse(xhr.responseText); //由JSON字符串转换为JSON对象

                 var a = tmpl.replace('#url#', obj.data);
                 var b = a.replace('#val#', obj.data);
                 $uploaderFiles.append($(b));
             };

             xhr.send(form);

    }else{
        alert("未选择文件");
    }
}


/*********************************************************************************************************************/
function storeAddr(){
	var storage = window.localStorage;

	var orderUsername = $('#orderUsername').val();
	var orderPhone = $('#orderPhone').val();
	var orderArea = $('#orderArea').val();
	var orderAddr = $('#orderAddr').val();

	storage.setItem('orderUsername',orderUsername);
	storage.setItem('orderPhone',orderPhone);
	storage.setItem('orderArea',orderArea);
	storage.setItem('orderAddr',orderAddr);
}

function getAddr(){
	$('#orderUsername').val(localStorage.orderUsername);
	$('#orderPhone').val(localStorage.orderPhone);

	if(localStorage.orderArea == '' || localStorage.orderArea == null){
		$('#orderArea').val('河南省 新乡市');
	}else{
		$('#orderArea').val(localStorage.orderArea);
	}

	$('#orderAddr').val(localStorage.orderAddr);
}

/*********************************************************************************************************************/
function validateForm(){
	var orderUsername = $('#orderUsername').val();
	if(orderUsername == ''){
		$.toast("请输入您的称呼", "text");
		return false;
	}

	var orderPhone = $('#orderPhone').val();
	if(orderPhone == ''){
		$.toast("请输入您的手机号码", "text");
		return false;
	}

	var orderArea = $('#orderArea').val();
	if(orderArea == ''){
		$.toast("请输入您的所在区域", "text");
		return false;
	}

	var orderAddr = $('#orderAddr').val();
	if(orderAddr == ''){
		$.toast("请输入您的详细地址", "text");
		return false;
	}

	//取图片
	var listUrl = '';
	var child = $uploaderFiles.find('[imageFileUrl]');
	child.each(function(index, item) {
		var value = $(item).attr('value');
		listUrl = listUrl+value+ ',';
	});

	$('#orderImages').val(listUrl);

	var A = $('#A').is(':checked');
	var B = $('#B').is(':checked');
	var C = $('#C').is(':checked');
	var D = $('#D').is(':checked');
	var E = $('#E').is(':checked');
	var F = $('#F').is(':checked');
	var F = $('#G').is(':checked');
	var F = $('#H').is(':checked');




	if(A == false && B == false && C== false && D == false && E== false && F == false&& G == false&& H == false) {
		$.toast("请至少选择一项您的出售物品类型", "text");
		return false;
	}

	var orderGoods = '';
	if(A){
		var V = $('#A').attr('value');
		orderGoods = orderGoods + V + '、';
	}

	if(B){
		var V = $('#B').attr('value');
		orderGoods = orderGoods + V + '、';
	}

	if(C){
		var V = $('#C').attr('value');
		orderGoods = orderGoods + V + '、';
	}

	if(D){
		var V = $('#D').attr('value');
		orderGoods = orderGoods + V + '、';
	}

	if(E){
		var V = $('#E').attr('value');
		orderGoods = orderGoods + V + '、';
	}

	if(F){
		var V = $('#F').attr('value');
		orderGoods = orderGoods + V;
	}
	if(G){
		var V = $('#G').attr('value');
		orderGoods = orderGoods + V;
	}
	if(H){
		var V = $('#H').attr('value');
		orderGoods = orderGoods + V;
	}
	console.log(orderGoods);

	$('#orderGoods').val(orderGoods);

	storeAddr();

	return true;
}

function uploadNeed(){
	if(!validateForm()){
		return;
	}

	var dataparam = $('#needForm').serialize();

	$.ajax({
		type : "POST",
		url : '/uploadneedd.json',
		data : dataparam,
		dataType : 'json',
		success : function(ret) {
			if (ret.ret == '0') {
				window.location.href='/yuyueok.html';
			} else {
				$.toast("预约失败，请您稍后再试！", "text");
			}
		},
		error : function() {

		}
	});
}

/*********************************************************************************************************************/


//初始化地址选择器
$("#start").cityPicker({
    title: "选择目的地",
    showDistrict: false
});

 $(function () {

     //loadStart();
 })
//用存储的地址code值去匹配当前地址

/*
function loadStart() {
    if ($("#start_place_id").val() != "") {
        $("#start").attr("data-code", $("#start_place_id").val());
        var citydatacodes = $("#start_place_id").val();
             var str = "";//citydatacodes.substring(2);
             $("#start").attr("data-codes", citydatacodes.replace(str, "0000") + "," + $("#start_place_id").val());
             //加载已认证的默认城市
             var cityvalue = [];
             var codes = $("#start").attr("data-code");   //如130100
             var str = codes.replace(codes.substring(2), "0000"); //如130000
             var raw = $.rawCitiesData;
             for (var i = 0; i < raw.length; i++) {
                 if (str == raw[i].code) {
                     cityvalue.push(raw[i].name);
                     console.log(raw[i].name);
                     for (var j = 0; j < raw[i].sub.length; j++) {
                         if (raw[i].sub[j].code === codes) {
                             console.log(raw[i].sub[j].name);
                             cityvalue.push(raw[i].sub[j].name);
                             console.log(cityvalue);
                             $("#start").val(cityvalue);
                             return;
                             // sub(raw[i].sub[j].name);
                         }
                     }
                 }
             }
         }
     }

*/

//获取code值

 /*
function setStart() {
 var codes = $("#start").attr("data-code");
  $("#start_place_id").val(codes);
}
*/



/*********************************************************************************************************************/
$(document).ready(function(e) {
	getAddr();
	/*var gallery = mui('.mui-slider');
	gallery.slider({
	  interval:3000//自动轮播周期，若为0则不自动播放，默认为0；
	});*/
});