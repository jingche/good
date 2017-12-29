/**
 * 
 */
$(function(){
		$("#button").bind("click",function(){
			$.ajax({
				type: "post",
				url: "/mavenSSM/getUser",
				dataType: "json",
				success: function(data){
					var s = "";
					
				}
			}); 
		});
	});