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
				src="view/images/logo.png" alt="logo"> <span>slogan is
					here</span>
			</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="inner-top-link pull-right">
				<li><a href="#">Notification <i class="fa fa-bell"></i></a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Account <span class="caret"></span></a>

					<ul class="dropdown-menu">
						<li><a href="#">Dashboard</a></li>
						<li><a href="#">Profile</a></li>
						<li class="divider"></li>
						<li><a href="#">Logout</a></li>
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
						<h4>Sanjay Shrestha</h4>
					</div>
				</div>
			</div>
			<div class="col-sm-6 inner-middle">

				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#post">Ride
							Offers</a></li>
					<li><a data-toggle="tab" href="#post1">Asking Ride</a></li>


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
											<div class="col-md-12">
												<label class="radio-inline"> <input name="posttype"
													type="radio" name="optradio" value="Offering">Offering
												</label> <label class="radio-inline"> <input name="posttype"
													type="radio" value="Asking" name="optradio">Asking
												</label>
											</div>
										</div>

										<div class="form-group">
											<div class='col-md-11 input-group date'>
												<input type='text' name="date" class="form-control"
													id="datepicker" /> <span class="input-group-addon">
													<span class="glyphicon glyphicon-calendar"></span>
												</span>
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
										<button type="submit" class="btn btn-success">Success</button>
									</div>
								</form>
							</div>

						</div>
					</div>

					<!-- Modal end -->
				</ul>
				<div id="ajaxoutput">
				
				</div>




				<%-- <%@ page import="java.sql.*"%>

				<%
						try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carpoolingdb?zeroDateTimeBehavior=convertToNull", "root", "root");  
							PreparedStatement ps = con.prepareStatement("select * from posts");
							ResultSet rs = ps.executeQuery();
							while (rs.next()) {
								out.print("Date : "+rs.getString(6) + " <br>From Location : " + rs.getString(7)+" <br>To Location "+rs.getString(8)+" <br>Description "+rs.getString(9)+"<br><hr>");
							}
							con.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
				%> --%>


				<!-- <div class="tab-content">
					<div id="post" class="tab-pane fade post in active">
						<div class="post_block">
							<div class="post-author">
								<div class="img-holder">
									<img src="view/images/thumb/default.jpg" alt="img">
								</div>
								<div class="text-holder">
									<h4>Sanjay Shrestha</h4>
									<p>
										2016-12-22 <span>3:45pm</span>
									</p>
								</div>
							</div>
							<div class="post-desc">
								<h1>Lorem ipsum dolor sit amet, consectetur adipisicing elit</h1>
								<img src="images/post/post.png" alt="post">
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Ut, tenetur natus doloremque laborum quos iste ipsum rerum
									obcaecati impedit odit illo dolorum ab tempora nihil dicta
									earum fugiat. Temporibus, voluptatibus. Lorem ipsum dolor sit
									amet, consectetur adipisicing elit. Eos, doloribus, dolorem
									iusto blanditiis unde eius illum consequuntur neque dicta
									incidunt ullam ea hic porro optio ratione repellat
									perspiciatis. Enim, iure! Lorem ipsum dolor sit amet,
									consectetur adipisicing elit. Error, nostrum, aliquid, animi,
									ut quas placeat totam sunt tempora commodi nihil ullam alias
									modi dicta saepe minima ab quo voluptatem obcaecati?</p>
							</div>

							<div class="post-foot">
								<p class="like liked">
									<i class="fa fa-heart"></i><span>255</span>Likes
								</p>
								<p>
									<i class="fa fa-comment"></i><span>02</span>Comments
								</p>
							</div>

							<div class="leave-comment">
								<h4>Leave Comment</h4>
								<form method="post" action="#">
									<textarea placeholder="Write comment here"></textarea>
									<button class="btn-all">Submit</button>
								</form>
							</div>

							<div class="comments-wrap">
								<div class="single-comment">
									<div class="img-holder">
										<img src="view/images/thumb/img.jpg" alt="img">
									</div>
									<div class="text-holder">
										<h4>
											Navraj Bhattarai <span>August 25, 2014 at 9:30 PM</span>
										</h4>
										<p>Cras sit amet nibh libero, in gravida nulla. Nulla vel
											metus scelerisque ante sollicitudin commodo. Cras purus odio,
											vestibulum in vulputate at, tempus viverra turpis.</p>
									</div>
								</div>

								<div class="single-comment">
									<div class="img-holder">
										<img src="view/images/thumb/default.jpg" alt="default">
									</div>
									<div class="text-holder">
										<h4>
											Navraj Bhattarai <span>August 25, 2014 at 9:30 PM</span>
										</h4>
										<p>Cras sit amet nibh libero, in gravida nulla. Nulla vel
											metus scelerisque ante sollicitudin commodo. Cras purus odio,
											vestibulum in vulputate at, tempus viverra turpis.</p>
									</div>
								</div>

							</div>


						</div>

						<div class="post_block">
							<div class="post-author">
								<div class="img-holder">
									<img src="view/images/thumb/default.jpg" alt="img">
								</div>
								<div class="text-holder">
									<h4>Sanjay Shrestha</h4>
									<p>
										2016-12-22 <span>3:45pm</span>
									</p>
								</div>
							</div>
							<div class="post-desc">
								<h1>Lorem ipsum dolor sit amet, consectetur adipisicing
									elit</h1>
								<img src="view/images/post/post.png" alt="post">
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Ut, tenetur natus doloremque laborum quos iste ipsum rerum
									obcaecati impedit odit illo dolorum ab tempora nihil dicta
									earum fugiat. Temporibus, voluptatibus. Lorem ipsum dolor sit
									amet, consectetur adipisicing elit. Eos, doloribus, dolorem
									iusto blanditiis unde eius illum consequuntur neque dicta
									incidunt ullam ea hic porro optio ratione repellat
									perspiciatis. Enim, iure! Lorem ipsum dolor sit amet,
									consectetur adipisicing elit. Error, nostrum, aliquid, animi,
									ut quas placeat totam sunt tempora commodi nihil ullam alias
									modi dicta saepe minima ab quo voluptatem obcaecati?</p>
							</div>

							<div class="post-foot">
								<p class="like">
									<i class="fa fa-heart"></i><span>255</span>Likes
								</p>
								<p>
									<i class="fa fa-comment"></i><span>02</span>Comments
								</p>
							</div>

							<div class="leave-comment">
								<h4>Leave Comment</h4>
								<form method="post" action="#">
									<textarea placeholder="Write comment here"></textarea>
									<button class="btn-all">Submit</button>
								</form>
							</div>

							<div class="comments-wrap">
								<div class="single-comment">
									<div class="img-holder">
										<img src="images/thumb/img.jpg" alt="img">
									</div>
									<div class="text-holder">
										<h4>
											Navraj Bhattarai <span>August 25, 2014 at 9:30 PM</span>
										</h4>
										<p>Cras sit amet nibh libero, in gravida nulla. Nulla vel
											metus scelerisque ante sollicitudin commodo. Cras purus odio,
											vestibulum in vulputate at, tempus viverra turpis.</p>
									</div>
								</div>

								<div class="single-comment">
									<div class="img-holder">
										<img src="view/images/thumb/default.jpg" alt="default">
									</div>
									<div class="text-holder">
										<h4>
											Navraj Bhattarai <span>August 25, 2014 at 9:30 PM</span>
										</h4>
										<p>Cras sit amet nibh libero, in gravida nulla. Nulla vel
											metus scelerisque ante sollicitudin commodo. Cras purus odio,
											vestibulum in vulputate at, tempus viverra turpis.</p>
									</div>
								</div>

							</div>


						</div>
					</div>
					<div id="post1" class="tab-pane fade">

						<div id="post1" class="tab-pane fade in active">


							<div class="post_block">
								<div class="post-author">
									<div class="img-holder">
										<img src="view/images/thumb/default.jpg" alt="img">
									</div>
									<div class="text-holder">
										<h4>Sanjay Shrestha</h4>
										<p>
											2016-12-22 <span>3:45pm</span>
										</p>

									</div>
								</div>
								<div class="post-desc">
									<h1>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit</h1>
									<img src="view/images/post/post.png" alt="post">
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit. Ut, tenetur natus doloremque laborum quos iste ipsum
										rerum obcaecati impedit odit illo dolorum ab tempora nihil
										dicta earum fugiat. Temporibus, voluptatibus. Lorem ipsum
										dolor sit amet, consectetur adipisicing elit. Eos, doloribus,
										dolorem iusto blanditiis unde eius illum consequuntur neque
										dicta incidunt ullam ea hic porro optio ratione repellat
										perspiciatis. Enim, iure! Lorem ipsum dolor sit amet,
										consectetur adipisicing elit. Error, nostrum, aliquid, animi,
										ut quas placeat totam sunt tempora commodi nihil ullam alias
										modi dicta saepe minima ab quo voluptatem obcaecati?</p>
								</div>

								<div class="post-foot">
									<p class="like">
										<i class="fa fa-heart"></i><span>255</span>Likes
									</p>
									<p>
										<i class="fa fa-comment"></i><span>02</span>Comments
									</p>
								</div>

								<div class="leave-comment">
									<h4>Leave Comment</h4>
									<form method="post" action="#">
										<textarea placeholder="Write comment here"></textarea>
										<button class="btn-all">Submit</button>
									</form>
								</div>

								<div class="comments-wrap">
									<div class="single-comment">
										<div class="img-holder">
											<img src="view/images/thumb/img.jpg" alt="img">
										</div>
										<div class="text-holder">
											<h4>
												Navraj Bhattarai <span>August 25, 2014 at 9:30 PM</span>
											</h4>
											<p>Cras sit amet nibh libero, in gravida nulla. Nulla vel
												metus scelerisque ante sollicitudin commodo. Cras purus
												odio, vestibulum in vulputate at, tempus viverra turpis.</p>
										</div>
									</div>

									<div class="single-comment">
										<div class="img-holder">
											<img src="view/images/thumb/default.jpg" alt="default">
										</div>
										<div class="text-holder">
											<h4>
												Navraj Bhattarai <span>August 25, 2014 at 9:30 PM</span>
											</h4>
											<p>Cras sit amet nibh libero, in gravida nulla. Nulla vel
												metus scelerisque ante sollicitudin commodo. Cras purus
												odio, vestibulum in vulputate at, tempus viverra turpis.</p>
										</div>
									</div>

								</div>


							</div>
						</div>

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

			</div>-->

			</div>
			<!-- row end -->
		</div>
		<!-- container-end -->
	</section>
	<!-- middle_section end -->


	<footer>
	<div class="container">
		<p class="copyright">Copyright © Carpool 2016</p>
		<ul class="foot-social">
			<li><a href="#" target="_blank"><i
					class="fa fa-facebook-square"></i></a></li>
			<li><a href="#" target="_blank"><i
					class="fa fa-twitter-square"></i></a></li>
			<li><a href="#" target="_blank"><i
					class="fa fa-google-plus-square"></i></a></li>
			<li><a href="#" target="_blank"><i
					class="fa fa-youtube-square"></i></a></li>
		</ul>
	</div>
	</footer>

	<!-- jQuery -->
	<script src="view/js/jquery.js"></script>
	<script src="view/js/bootstrap.min.js"></script>
	<script src="view/js/custom.js"></script>
	<script src="view/js/feed.js"></script>



</body>

</html>