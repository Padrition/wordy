$(document).ready(function() {
	$("#search-form").submit(function(event){
		event.perventDefault();
		
		fire_ajax_submit();
	});
});

function fire_ajax_submit(){
	
};