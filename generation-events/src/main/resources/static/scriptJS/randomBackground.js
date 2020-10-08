$(function(){
	$.get("/api/events/randomImgEvent",function(data){
	
		var cssImg = "url('/" + data.immagine + "')";

		//$("body").css("background-image", cssImg);
		//$("body").css("background-position","center");
		$(".container").css("background-color","rgba(255,255,255,0.8)").css("display","block").css("border-radius","1rem");
		$("body").attr("style","background-image:" + cssImg + "; background-position:center");
		
	});
});
