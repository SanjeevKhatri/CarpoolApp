$(document).ready(function () {
	$.ajax({
	url:'DisplayPost',
	type:'POST',
	headers:{
		Accept:"application/json; charset=utf-8",
		"Content-Type" : "application/json; charset=utf-8"
	},
	success:function(result){
		$.each(result.JSONDATA,function(i,data){
			
			var myHTML="";
			myHTML+="<div class='offeredPost'><h2 class='offererName'>"+data.name+"</h2>";
			myHTML+="<pre>"+data.post+"</pre>"+"<button class='btnLike' btn-postid=\""+data.postid+"\">Like</button>" +
					"<input type='hidden' name='txtHidden' value='"+data.postid+"'>" +
							"     "+"<button class='btnComment' btn-postid=\""+data.postid+"\">Comment</button></div>" +
									"<br><br>";
			$("#ajaxOutput").append(myHTML);
			
		});
	},
	error:function(exception){
		console.log(exception);
	}
});
	
});