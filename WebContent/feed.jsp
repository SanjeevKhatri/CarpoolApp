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

<title>Carpool</title>

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

	<section class="middle-section">
	<div class="container">
		<div class="row">
			<div class="col-sm-3 inner-left">
				<div class="user-profile">
					<div class="img-holder">
						<img src="view/images/thumb/default.jpg" alt="default">
					</div>
					<div class="text-holder">
						<h4><%=session.getAttribute("yourName")%></h4>
					</div>
				</div>
			</div>
			<div class="col-sm-6 inner-middle">

				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#post">Offering
							Ride</a></li>
					<li id="post3"><a data-toggle="tab" href="#post1">Asking
							Ride</a></li>


					<button type="button" class="btn btn-info btn-lg right"
						data-toggle="modal" data-target="#myModal">Add New Post</button>
					<div class="clear_right"></div>
					<!-- Modal -->
					<div id="myModal" class="modal fade" role="dialog">
						<div class="modal-dialog">

							<!-- Modal content-->
							<div class="modal-content">
								<form action="PostController" method="POST">
									<div class="modal-header">

										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">Add New Post</h4>
									</div>
									<div class="modal-body mod-body">

										<div class="form-group">
											<div class="col-md-12" style="margin-bottom:10px;">
												<label class="radio-inline"> <input name="posttype"
													type="radio" name="optradio" value="offering">offering
												</label> <label class="radio-inline"> <input name="posttype"
													type="radio" value="asking" name="optradio">asking
												</label>
											</div>
										</div>

										<div class="form-group">
											<div class='col-md-11 input-group date' style="margin-top:10px;margin-left:16px;">
												<input type='date' name="date" class="form-control"
													id="datepicker" /> 
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-6">
												<label for="ex1">From</label> <input name="from"
													class="form-control" id="ex1" type="text">
											</div>


											<div class="col-md-6">
												<label for="ex2">To</label> <input name="to"
													class="form-control" id="ex2" type="text">
											</div>
										</div>

										<div class="form-group">
											<div class="col-md-12">
												<label for="comment">Description:</label>
												<textarea name="description" class="form-control" rows="5"
													id="comment"></textarea>
											</div>
										</div>

									</div>


									<div class="modal-footer">
										<!--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>-->
										<button type="submit" class="btn btn-success">Submit</button>
									</div>
								</form>
							</div>

						</div>
					</div>

					<!-- Modal end -->
				</ul>

				<div class="tab-content">
					<div id="post" class="tab-pane fade post in active"></div>
					<div id="post1" class="tab-pane fade">

						<div id="post1 post2" class="tab-pane fade in active"></div>

					</div>
				</div>




			</div>

			<div class="col-sm-3 inner-right">
				<div class="mrgb-20">
					<img src="view/images/add1.jpg" alt="add1">
				</div>

				<div class="mrgb-20">
					<img src="view/images/add1.jpg" alt="add1">
				</div>

			</div>

		</div>
		<!-- row end -->
	</div>
	<!-- container-end --> </section>
	<!-- middle_section end -->

	<!-- --ok -ghghg->
    <footer>
    	<div class="container">
        	<p class="copyright">Copyright © Carpool 2016</p>
            <ul class="foot-social">
            	<li><a href="#" target="_blank"><i class="fa fa-facebook-square"></i></a></li>
                <li><a href="#" target="_blank"><i class="fa fa-twitter-square"></i></a></li>
                <li><a href="#" target="_blank"><i class="fa fa-google-plus-square"></i></a></li>
                <li><a href="#" target="_blank"><i class="fa fa-youtube-square"></i></a></li>
            </ul>
        </div>	
    </footer>

    <!-- jQuery -->
	<script src="view/js/jquery.js"></script>
	<script src="view/js/bootstrap.min.js"></script>
	<script src="view/js/feed.js"></script>
	
	

</body>

</html>