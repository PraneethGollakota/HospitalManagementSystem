<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Symptoms</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="assets/css/light-bootstrap-dashboard.css" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />


    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />
<style type="text/css">
.as{
text-align:auto;
}
</style>
</head>
<body>

<div class="wrapper">
    <div class="sidebar" data-color="purple" data-image="assets/img/sidebar-5.jpg">

    <!--

        Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
        Tip 2: you can also add an image using data-image tag

    -->

    	<div class="sidebar-wrapper">
           

            <ul class="nav">
                <li class="active">
                    <a href="SymptomsDummy.jsp">
                        <i class="pe-7s"></i>
                        <p>Symptoms</p>
                    </a>
                </li>
                
                <li>
                    <a href="report">
                        <i class="pe-7s"></i>
                        <p>Generate Report</p>
                    </a>
                </li>
				 <li>
                    <a href="tip">
                        <i class="pe-7s"></i>
                        <p>Health tips</p>
                    </a>
                </li>
				
            </ul>
    	</div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <%
                    Cookie ck[]=request.getCookies();
                    String userName=ck[0].getValue();
                    out.println(userName);
                    %>
                </div>
                <div class="collapse navbar-collapse">
                    
                    <ul class="nav navbar-nav navbar-right">
                        
                        <li>
                            <a href="logoutServlet">
                                Log out
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
		
<form action="symptoms" method="post"><center><table>

<div class="container as">
<input type="checkbox" value="yes" name="abdomnal pain">Abdomnal pain &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<input type="checkbox" value="yes" name="blood in stool">Blood in stool &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<input type="checkbox" value="yes" name="breath shortness"> Breath shortness &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

 <input type="checkbox" value="yes" name="chest pain"> Chest pain&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<input type="checkbox" value="yes" name="chills">Chills</div></table>
<table><br><br>
<div class="container as">
<input type="checkbox" value="yes" name="cold"> Cold &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

 <input type="checkbox" value="yes" name="cough"> Cough&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<input type="checkbox" value="yes" name="diarrhoea">Diarrhoea &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<input type="checkbox" value="yes" name="depression"> Depression&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<input type="checkbox" value="yes" name="fast heart rate">Fast heart rate</div></table><br><br><table>
<div class="container as"> 

 <input type="checkbox" value="yes" name="fever">Fever&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<input type="checkbox" value="yes" name="headache"> Headache &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

 <input type="checkbox" value="yes" name="hyper active">Hyper active&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<input type="checkbox" value="yes" name="infection">Infection &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<input type="checkbox" value="yes" name="itching">Itching </div></table><br><br><table>
<div class="container as"> 

<input type="checkbox" value="yes" name="mouth infection">Mouth infection &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<input type="checkbox" value="yes" name="pain">Pain  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<input type="checkbox" value="yes" name="pain behind eyes">Pain behind eyes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    

<input type="checkbox" value="yes" name="rash">Rash &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<input type="checkbox" value="yes" name="throat irritation">Throat irritation </div></table><br><br><table>
<div class="container as"> 
<input type="checkbox" value="yes" name="toilet urgency">Toilet urgency&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<input type="checkbox" value="yes" name="urinary problem">Urinary problem &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 

<input type="checkbox" value="yes" name="visionproblem">Vision problem  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<input type="checkbox" value="yes" name="vomitings">Vomitings &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<input type="checkbox" value="yes" name="yellow eyes">Yellow eyes</div></table><br><br><table>

<input type="submit" value="submit" name="submit">
<input type="reset" value="reset" name="reset"></center></table>
</form>		
        
    </div>
</div>


</body>

    <!--   Core JS Files   -->
    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="assets/js/bootstrap-checkbox-radio-switch.js"></script>

	<!--  Charts Plugin -->
	<script src="assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="assets/js/light-bootstrap-dashboard.js"></script>

	<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
	<script src="assets/js/demo.js"></script>



</html>
