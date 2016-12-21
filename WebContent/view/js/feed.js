var old_count=0;

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
			console.log(data);
			
			var myHTML="";
			myHTML+="<div class='offeredPost'><h2 class='offererName'>"+"UserName"+data.name+"</h2>";
			myHTML+="<pre>"+data.post+"</pre>"+"<button class='btnLike' btn-postid=\""+data.postid+"\">Like</button>" +
					"<input type='hidden' name='txtHidden' value='"+data.postid+"'>" +
							"     "+"<button class='btnComment' btn-postid=\""+data.postid+"\">Comment</button></div>" +
									"<br><br>";
			
			var postContent="";
			postContent+="<div class='post_block'> <div class='post-author'><div class='img-holder'><img src='view/images/thumb/default.jpg' alt='img'> " +
					"</div><div class='text-holder'><h4>"+data.name+"</h4>" ;
			postContent+="<button type='button' class='btn btn-info btn-sm right' data-toggle='modal' data-target='#myMap'>View Map</button>"+		
							"<div id='myMap' class='modal fade' role='dialog'><div class='modal-dialog' style='width:1100px;height:1600px !important;'>"+
						" <div class='modal-content'>      <div class='modal-header'>  <button type='button' class='close' data-dismiss='modal'>&times;</button>"+
                           "   <h4 class='modal-title'>Map</h4> </div><div class='modal-body' style='height:1600px !important;'>"+
							
							"<div id='container-map'></div>  </div> <div class='modal-footer'> <button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>"+
							" </div>  </div></div>   </div>  <p>2016-12-22 <span>3:45pm</span></p><span style='font-size:13px;'><b>FROM:&nbsp;</b>"+data.fromlocation+"</span>"+
                            "&nbsp;<span style='font-size:13px;'><b>TO:&nbsp;</b>"+data.tolocation+"</span>   </div> </div>   ";
							
			postContent+=" <div class='clear'></div><div class='post-desc'><p>description goes here</p>"+
						"</div> <div class='post-foot'> <p class='like liked'><i class='fa fa-heart'></i><span>255</span>Likes</p>"+
                           " <p><i class='fa fa-comment'> </i><span>02</span>Comments</p></div><div class='leave-comment'><h4>Leave Comment</h4>"+
                           " <form method='post' action='#'><textarea placeholder='Write comment here'></textarea><button class='btn-all'>Submit</button>"+
                       " </form> </div>";
			postContent+="";
			postContent+=" ";
			postContent+="";
			postContent+=" ";
			
			$("#ajaxoutput").append(postContent);
			
		});
	},
	error:function(exception){
		console.log(exception);
	}
});
	
	
	// global variable  assign
	
			$.ajax({
				url:'PostController',
				type:'GET',
				headers:{
					Accept:"application/json; charset=utf-8",
					"Content-Type" : "application/json; charset=utf-8"
				},
				success:function(result){
					
					 old_count=result.JSONDATAC;
				}
				
			});
	
	
	
	// ajax call at certain interval
	
	setInterval(function () {
        console.log('it works' + new Date());
	
	
					$.ajax({
						url:'PostController',
						type:'GET',
						headers:{
							Accept:"application/json; charset=utf-8",
							"Content-Type" : "application/json; charset=utf-8"
						},
						success:function(result){
							
							var new_count = result.JSONDATAC;
							if(new_count>old_count){
								
								 $(".inner-top-link > li > a.notification").css("background-color","red");
							}
							else{
								
								old_count = new_count;
							}
							console.log(result.JSONDATAC);
						}
					});
					
	 },3000);
					
});