<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<link href="/StaffAtendance/resources/css/style.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" href="/StaffAtendance/resources/css/jquery.datepick.css">
	<link rel="stylesheet" href="/StaffAtendance/resources/css/jquery-ui.css">
	<script src="/StaffAtendance/resources/js/jquery.js"></script>
	<script src="/StaffAtendance/resources/js/jquery-ui.js"></script>
	<script src="/StaffAtendance/resources/js/jquery.datepick.js"></script>
	<script src="/StaffAtendance/resources/js/jquery.tablesorter.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<div id="adminButtonContaner">
			<button id="addStaff" class="aqua">Add a Staff</button>
			<button id="removeStaff" class="aqua">Remove Staff</button>
			<button id="updateStaff" class="aqua">Update Staff</button>
			<button id="viewStaff" class="aqua">View Staff</button>
		</div>
		<div id="adminResultCOntainer"></div>
		<script type="text/javascript">
			jQuery("#addStaff").click(function(){
				jQuery.ajax({
					url:"addStaff.htm",
					success:function(data){
						jQuery("#adminResultCOntainer").html(data);
					}
				});
			});
			jQuery("#removeStaff").click(function(){
				jQuery.ajax({
					url:"removeStaff.htm",
					success:function(data){
						jQuery("#adminResultCOntainer").html(data);
					}
				});
			});
			jQuery("#viewStaff").click(function(){
				jQuery.ajax({
					url:"viewStaff.htm",
					success:function(data){
						jQuery("#adminResultCOntainer").html(data);
					}
				});
			});
			jQuery("#updateStaff").click(function(){
				jQuery.ajax({
					url:"updateStaff.htm",
					success:function(data){
						jQuery("#adminResultCOntainer").html(data);
					}
				});
			});
			</script>
	</div>
</body>
</html>