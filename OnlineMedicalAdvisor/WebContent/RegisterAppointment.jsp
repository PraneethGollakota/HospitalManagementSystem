<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dr.Online | RegisterAppointment</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Medicate Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //custom-theme -->
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<!-- stylesheet -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/easy-responsive-tabs.css" rel='stylesheet' type='text/css'/>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/gallery.css" rel="stylesheet" type="text/css" media="all" /> <!-- gallery css -->
<!-- //stylesheet -->
<!-- online fonts -->
<link href="//fonts.googleapis.com/css?family=Titillium+Web:200,200i,300,300i,400,400i,600,600i,700,700i,900" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
<!-- //online fonts -->
<!-- font-awesome-icons -->
<link href="css/font-awesome.css" type="text/css" rel="stylesheet"> 
<!-- //font-awesome-icons -->
<script src="js/modernizr.custom.js"></script>
<script type="text/javascript" src="js/modernizr.custom.79639.js"></script>		
<link rel="stylesheet" type="text/css" href="css/custom.css" />	
<!-- for smooth scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
jQuery(document).ready(function($) {
	$(".scroll").click(function(event){		
		event.preventDefault();
		$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
	});
});
</script>
<!-- //for smooth scrolling -->
<style type="text/css">
button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 10px 18px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
}

</style>
</head>
<body>
<header class="main-header" role="banner">
  <img src="images/6.jpg" width="1400px" height="200px" alt="Banner Image"/>
</header>
<!--  img src="images/banner.jpg"-->
<center>
<div class="modal-body">
						<div class="wthree-info">
							<h3>Fill details below to book an appointment</h3>
							<div class="login">
								<form action="appointment" method="post">
										 <input type="text" class="user" name="name" placeholder="Name" required=""><br>
										 <input type="number" name="age" placeholder="Age" required=""><br> 
										 Gender:&nbsp;&nbsp;<input type="radio" name="gender" value="Male">Male
										<input type="radio" name="gender" value="Female">Female
										<br><br>
										<input type="text" class="user" name="city" placeholder="City" required="">
										 <br>
										 <input placeholder="Date" class="date" id="datepicker" name="date" type="date" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" required=""/>
									
										 
										 <br>
				
										 <input type="submit" value="appointment">
										 <input type="reset" value="reset">
								</form>
							</div>	
     					</div> 
						<div class="clearfix"> </div>
					</div></center>
</body>
</html>