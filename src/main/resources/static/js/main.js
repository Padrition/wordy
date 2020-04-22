$(document).ready(function() {
	$("#search-form").submit(function(event){
		event.preventDefault();
		
		fire_ajax_submit();
	});
});

function fire_ajax_submit(){
	$("#definition").html("");
	var term = $("#word").val();
	$.ajax({
		type : "GET",
		datatype : "json",
		url : "/api/search/" + term, 
		success : function(data) {
			console.log(data);
			$("#searched-Word").html(data.word);
			console.log(data.meaning.noun);
			if(data.meaning.noun !== null){
				$("#definition").append("<p>[noun]</p>");
				$("#definition").append("<ul></ul>");
				$.each(data.meaning.noun , function(i){
					$("#definition").append("<li>"+data.meaning.noun[i].definition+"</li>");
				});
			}
			if(data.meaning.verb !== null){
				$("#definition").append("<p>[verb]</p>");
				$("#definition").append("<ul></ul>");
				$.each(data.meaning.verb , function(i){
					$("#definition").append("<li>"+data.meaning.verb[i].definition+"</li>");
				});
			}
			if(data.meaning.adverb !== null){
				$("#definition").append("<p>[adverb]</p>");
				$("#definition").append("<ul></ul>");
				$.each(data.meaning.adverb , function(i){
					$("#definition").append("<li>"+data.meaning.adverb[i].definition+"</li>");
				});
			}
		},
		error : function(){
			console.log("error");
		}
	});
};