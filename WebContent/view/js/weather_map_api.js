var start=[];
var end=[];
var curLocation="fairfield";//"<%= session.getAttribute(\"seesionCity\");%>";
console.log(curLocation);

$(function weather(){
/////////////////////////////initially displaying the weather of current city //////////////////////////
	$(document).ready(function(){
		$("#locweather").trigger("click");
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
				if(isNaN(data.fromlocation)&&isNaN(data.tolocation)){
						start.push(data.fromlocation);
						end.push(data.tolocation);
				}
				});
				
				console.log(end);
			},
			error:function(exception){
				console.log(exception);
			}
		});
	});
});	
////////////////////////////////////marker in the map ///////////////////////////////////////////////////	
function initMap(){
		var map = new google.maps.Map(document.getElementById('map'), {
				center: {lat: 41.0086111, lng: -91.9625},
				zoom: 13
			});
			//placing the text field and button over the map
				var input = document.getElementById('city');
				map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
				var autocomplete = new google.maps.places.Autocomplete(input);
				
				var button= document.getElementById('locweather');
				map.controls[google.maps.ControlPosition.TOP_LEFT].push(button);
				autocomplete.bindTo('bounds', map);
				
				//initialing the marker
				var marker = new google.maps.Marker({
						map: map,
						anchorPoint: new google.maps.Point(0, -29)
					});

					//adding auto complete listener to the text field for the location
				autocomplete.addListener('place_changed', function() {
					marker.setVisible(false);
					var place = autocomplete.getPlace();
					if (!place.geometry) {
						// User entered the name of a Place that was not suggested and
						// pressed the Enter key, or the Place Details request failed.
						window.alert("Please select complete address from the list '" + place.name + "'");
						return;
					}
						
					// If the place has a geometry, then present it on a map.
					if (place.geometry.viewport) {
						map.fitBounds(place.geometry.viewport);
						}
					else {
							map.setCenter(place.geometry.location);
							map.setZoom(9); 
					}
					marker.setIcon(/** @type {google.maps.Icon} */({
							url: place.icon,
							size: new google.maps.Size(71, 71),
							origin: new google.maps.Point(0, 0),
							anchor: new google.maps.Point(17, 34),
							scaledSize: new google.maps.Size(35, 35)
					}));
					marker.setPosition(place.geometry.location);
					marker.setVisible(true);

					var address = '';
					if (place.address_components) {
						address = [
							(place.address_components[0] && place.address_components[0].short_name || ''),
							(place.address_components[1] && place.address_components[1].short_name || ''),
							(place.address_components[2] && place.address_components[2].short_name || '')
						].join(' ');
					}
			});

////////////////////////////////showing all trips//////////////////////////////////////////////////////////////////////
$(function AllTrips() {
	var counter=0;
	
//	var start=["chicago","omaha","florida"];
//	var end=["fairfield","newyork","kansas"];	
	//Displaying route of one starting and ending point//
	function calculateAndDisplayRoute(directionsService, directionsDisplay) {
		directionsService.route({
			origin: start[counter],
			destination: end[counter],
			travelMode: 'DRIVING'
		},function(response, status) {
			if (status === 'OK') {
				directionsDisplay.setDirections(response);
			}
			else {
//				window.alert('Directions request failed due to ' + status);
				console.lot('Directions request failed due to ' + status);
			}
		});
	}
	$("#trips").click(function(){
			///initializing the value of counter each time the Trip is clicked///
			if(counter==start.length){
				counter=0;
				$("#summary").empty();
			}
			var directionsService = new google.maps.DirectionsService;
			var directionsDisplay = new google.maps.DirectionsRenderer;
			directionsDisplay.setMap(map);
			////////////////////////////////////////////////////////////
			//pass value of source and destination from database//
			///////////////////////////////////////////////////////////
			
			calculateAndDisplayRoute(directionsService, directionsDisplay);
			counter++;
			///////////////////////////////////////displaying all drips in left side////////////////
			var routes="";
			routes+="<span style='font-size:9px'>Trip:"+counter+" "+start[counter-1]+" to "+end[counter-1]+"</span><br>";
			$("#summary").append(routes);
/////////////////setting interval and auto click event to display all trips in map////////////////////////////////////////////////////////////
			setInterval(function () {
//				console.log('it works' + new Date());
				if(counter>0&&counter<start.length){
					$("#trips").trigger("click");
				}
			},500);
	});

//		/////////////////trips 2/////////
//		$("#trips1").click(function(){
//			///initializing the value of counter each time the Trip is clicked///
//			if(counter1==start.length){
//				counter1=0;
//				$("#summary").empty();
//			}
//			var directionsService = new google.maps.DirectionsService;
//			var directionsDisplay = new google.maps.DirectionsRenderer;
//			directionsDisplay.setMap(map);
//			////////////////////////////////////////////////////////////
//			//pass value of source and destination from database//
//			///////////////////////////////////////////////////////////
//			
//			calculateAndDisplayRoute(directionsService, directionsDisplay);
//			counter1++;
//			///////////////////////////////////////displaying all drips in left side////////////////
//			var routes="";
//			routes+="Trip:"+counter1+" "+"<h5>"+start[counter1-1]+" to "+end[counter1-1]+"<h5><br>";
//			$("#summary").append(routes);
///////////////////setting interval and auto click event to display all trips in map////////////////////////////////////////////////////////////
//			setInterval(function () {
//				console.log('it works' + new Date());
//				///////////start.length should be changed
//				if(counter1>0&&counter1<start.length){
//					$("#trips1").trigger("click");
//				///////////////////////////////////////////
//			}
//			},500);
//	});
//
///////////////////trips 3/////////
//		$("#trips2").click(function(){
//			///initializing the value of counter each time the Trip is clicked///
//			if(counter2==start.length){
//				counter2=0;
//				$("#summary").empty();
//			}
//			var directionsService = new google.maps.DirectionsService;
//			var directionsDisplay = new google.maps.DirectionsRenderer;
//			directionsDisplay.setMap(map);
//			////////////////////////////////////////////////////////////
//			//pass value of source and destination from database//
//			///////////////////////////////////////////////////////////
//			
//			calculateAndDisplayRoute(directionsService, directionsDisplay);
//			counter2++;
//			///////////////////////////////////////displaying all drips in left side////////////////
//			var routes="";
//			routes+="Trip:"+counter2+" "+"<h5>"+start[counter2-1]+" to "+end[counter2-1]+"<h5><br>";
//			$("#summary").append(routes);
///////////////////setting interval and auto click event to display all trips in map////////////////////////////////////////////////////////////
//			setInterval(function () {
//				console.log('it works' + new Date());
//				///////////start.length should be changed
//				if(counter2>0&&counter2<start.length){
//					$("#trips2").trigger("click");
//				/////////////////////////////////////////
//				}
//			},500);
//	});

});
/////////////////////////////////////////End of function all trips ///////////////////////////////////
}
//////////////////////////////////////////End of function init()/////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////
	 $(function weather(){
			$("#locweather").click(function(){
				// console.log("ok");
				$("#weather_display").empty(); 
				$("#location_result").empty(); 
				var city="";
				city=$('#city').val();
				console.log(city+"ok1");
				var api="http://api.openweathermap.org/data/2.5/forecast?q=";
				var countryCode=",us";
				var apiKey="&appid=97f9ce027149ca1b3d324cddf8e2bcd7"; 
				var units="&units=metric&mode=json";
				/////////////////////////////////////////////
				////pass value of user's location from db////
//				if(city==""){city="fairfield";}
				///////////////////user's location from geo location got from stack over-flow//////////
				if((city=="")||(!isNaN(curLocation))){
					city=curLocation;
					console.log(city);
				}
				else{
					$.get("http://ipinfo.io", function(response) {
						city=response.city;
						console.log(city);
					}, "jsonp");
				}
				console.log(city);
				
				/////////////////////////////////////////////
				/////////////////////////////////////////////
				/////////////////////////////////////////////
				var url= api + city + countryCode + units + apiKey;
				if(city!=""){
				//Displaying day
				var weekdays = ['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'];	
				$.get(url).done(function(data){
					var content=""; 
					content+=	"<h4>Today's weather of: "+data.city.name+","+data.city.country+"</h4>"+
								" <img   src='http://openweathermap.org/img/w/"+data.list[0].weather[0].icon+".png'/>"+
								"<span>"+data.list[0].main.temp+" C  </span>"+
								"<span>, "+data.list[0].weather[0].description+"</span>";
								$("#location_result").append(content);
					
					var content1="";
							content1+="<div class='forecast'>"+weekdays[new Date(data.list[3].dt_txt).getDay()] +
							"<img    src='http://openweathermap.org/img/w/"+data.list[3].weather[0].icon+".png'/>"+
							"<span> "+data.list[3].main.temp+" C  </span>"+
							"<span>, "+data.list[3].weather[0].description+"</span>"+"</div>"+
							
							"<div class='forecast'>"+weekdays[new Date(data.list[11].dt_txt).getDay()] + 
							"<img    src='http://openweathermap.org/img/w/"+data.list[11].weather[0].icon+".png'/>"+
							"<span>"+data.list[11].main.temp+" C  </span>"+
							"<span>, "+data.list[11].weather[0].description+"</span>"+"</div>"+
								
							"<div class='forecast'>"+weekdays[new Date(data.list[19].dt_txt).getDay()] + 
							"<img    src='http://openweathermap.org/img/w/"+data.list[19].weather[0].icon+".png'/>"+
							"<span>"+data.list[19].main.temp+" C  </span>"+
							"<span>, "+data.list[19].weather[0].description+"</span>"+"</div>"+

							"<div class='forecast'>"+weekdays[new Date(data.list[27].dt_txt).getDay()] + 
							"<img    src='http://openweathermap.org/img/w/"+data.list[27].weather[0].icon+".png'/>"+
							"<span>"+data.list[27].main.temp+" C  </span>"+
							"<span>, "+data.list[27].weather[0].description+"</span>"+"</div>"+
								
							"<div class='forecast'>"+weekdays[new Date(data.list[35].dt_txt).getDay()] + 
							"<img  src='http://openweathermap.org/img/w/"+data.list[35].weather[0].icon+".png'/>"+
							"<span>"+data.list[35].main.temp+" C  </span>"+
							"<span>, "+data.list[35].weather[0	].description+"</span>"+"</div>";
				
					$("#weather_display").append(content1);
					
						})
						.fail(function(xhr,status,exception){
						console.log(exception);
							})	
					}
			});
	});	

//////////////////////////////////////////End of function init()/////////////////////////////////////

		// //To do:
		// // bring value of city from database and display mark the user's position on the map
		//  done
		//pin in the map with weather information
		// weather forecast of particular location with extra 5 days weather forecast 
		// routing single source and destination
		// Routing the information after clicking the button

