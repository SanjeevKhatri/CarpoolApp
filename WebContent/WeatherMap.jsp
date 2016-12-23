<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">


    <title>Weather Map</title>


<!-- Bootstrap Core CSS -->
<link href="view/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="view/css/style.css" rel="stylesheet">


<!-- Custom Fonts -->
<link href="view/font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
	

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">

			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<a class="navbar-brand" href="index.html"> <img
				src="view/images/logo.png" alt="logo"> <span>MUM
					Carpool</span>
			</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="inner-top-link pull-right">
				<li><a href="WeatherMap.jsp">Weather Map <i class="fa fa-sun-o"
						aria-hidden="true"></i></a></li>
				<li><a href="feed.jsp" class="notification">Notification <i
						class="fa fa-bell"></i></a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Account <span class="caret"></span></a>

					<ul class="dropdown-menu">
						<li><a href="#">Welcome, <br> <i
								class="fa fa-user fa-fw"></i><%=session.getAttribute("yourName")%></a></li>
						<li><a href="editprofile.jsp"><i class="fa fa-pencil fa-fw"></i>Edit
								Profile</a></li>
								<li><a href="Vpost"><i class="fa fa-rss"></i>View Your Post</a></li>
						<li class="divider"></li>
						<li><a href="LogoutController"><i class="fa fa-unlock"></i>Logout</a></li>
			
					</ul></li>
			</ul>
		</div>

		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

    <section class="banner">
    	<div class="map_container">
        	
            <!--Weather task-->
            <div class="map_form weather_form"> 
                <div class="block">	
                    <div id="location_result"> </div>
                </div>
            <div id="weather_display"></div>
            <!--lower block with two divs-->
                
            <div id="container_trips">
                <input type="button" id="trips" value="All Trips" >
                <input type="button" id="trips1" value="Trips with same Location" >
                <input type="button" id="trips2" value="Trips with near Location" >
                <div id="summary"></div>
            </div>
            <!--Google map-->
            <input class="map_text" type="text" id="city" placeholder="Search map">
            <input class="map_button" type="button" id="locweather" value="Show Weather">
            <div id="map"></div>
            </div>
        </div><!-- container end -->
    </section><!-- banner end -->
    <!-- jQuery -->
    <script src="view/js/jquery.js"></script>
    <script src="view/js/bootstrap.min.js"></script>
    <link href="view/css/weather_map.css" type="text/css" rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
     <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCtiMx-TubW49qgT_lgULfvzweEu1542NA&libraries=places&callback=initMap"async defer></script>
    <!--<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCtiMx-TubW49qgT_lgULfvzweEu1542NA&callback=initMap"></script>-->
    <script src="view/js/weather_map_api.js" type="text/javascript"></script>
	
</body>
</html>
