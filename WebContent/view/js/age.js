$(document).ready(function() {

$( "#birthyear" ).on( "change", function() {
    var by=$('#birthyear').val();
    var age=2016-by
    if(age<18){
    	$('#configform')[0].reset();
    }
    else{
       
    }
});

});