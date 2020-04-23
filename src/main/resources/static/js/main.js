$(document).ready(function() {
	$("#search-form").submit(function(event){
		event.preventDefault();
		
		fire_ajax_submit();
	});
});

function fire_ajax_submit(){
	$("#definition #noun").html("");
	$("#definition #verb").html("");
	$("#definition #adverb").html("");
	$("#definition #transitiveVerb").html("");
	$("#definition #searched-Word").html("");
	$("#definition #phonetic").html("");

	var term = $("#word").val();
	$.ajax({
		type : "GET",
		datatype : "json",
		url : "/api/search/" + term, 
		success : function(data) {
			
			console.log(data);

			$("#searched-Word").append("<h2>"+data.word+"</h2>");
			$("#phonetic").append("<h4>"+data.phonetic+"</h4>");

			if(data.meaning.noun !== null){
				$("#noun").append("<p>[noun]</p>");
				$("#noun").append("<ul></ul>");
				$.each(data.meaning.noun , function(i){
					$("#noun ul").append("<li>"+data.meaning.noun[i].definition+"</li>");
				});
			}
			if(data.meaning.verb !== null){
				$("#verb").append("<p>[verb]</p>");
				$("#verb").append("<ul></ul>");
				$.each(data.meaning.verb , function(i){
					$("#verb ul").append("<li>"+data.meaning.verb[i].definition+"</li>");
				});
			}
			if(data.meaning.adverb !== null){
				$("#adverb").append("<p>[adverb]</p>");
				$("#adverb").append("<ul></ul>");
				$.each(data.meaning.adverb , function(i){
					$("#adverb ul").append("<li>"+data.meaning.adverb[i].definition+"</li>");
				});
			}
			if(data.meaning["transitive verb"] !== null){
				$("#transitiveVerb").append("<p>[transitive verb]</p>");
				$("#transitiveVerb").append("<ul></ul>");
				$.each(data.meaning["transitive verb"] , function(i){
					$("#transitiveVerb ul").append("<li>"+data.meaning["transitive verb"][i].definition+"</li>");
				});
			}
		},
		error : function(){
			console.log("error");
		}
	});
};