<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/StaffAtendance/resources/css/style.css" type="text/css" rel="stylesheet" />
<link href="/StaffAtendance/resources/css/bootstrap.css" type="text/css" rel="stylesheet" /><!-- bootstrap css -->
<script src="/StaffAtendance/resources/js/jquery.js"></script>
</head>
<body>
	<div class="metro left">
	<fieldset>
		<legend>Welcome to Home</legend>
		${staffs }		
		<br>
		<!-- <button id="submitAttendance" class="aqua small">Submit</button> -->
		<button id="submitAttendance" class="btn btn-primary">Submit</button>	
	</fieldset>
	</div>
<script type="text/javascript">
	
	jQuery(".attendance").click(function(){
		if(jQuery(this).hasClass("absent")){
			jQuery(this).removeClass("absent btn-danger");
			jQuery(this).addClass("present btn-primary");
			jQuery(this).text("Present");
			jQuery(this).attr("present","true");
		}
		else if(jQuery(this).hasClass("present")){
			jQuery(this).removeClass("present btn-primary");
			jQuery(this).addClass("absent btn-danger");
			jQuery(this).text("Absent");
			jQuery(this).attr("present","false");
		}
	});
	
	jQuery("#submitAttendance").click(function(){
		alert("test");
		var temp="";
		jQuery(".metro").find(".attendance").each(function(){
			temp=temp+jQuery(this).attr("id")+"@@"+jQuery(this).attr("present")+"$$";
		});
		console.log(temp);
		jQuery.ajax({
			url:'submitAttendanceAction.htm?attendance='+temp,
			success:function(){
				alert("done");
			}
		});
	});
	jQuery(".vatt").click(function(){
		var id=jQuery(this).attr("id");
		jQuery.ajax({
			url:'reports/staffReport.htm?id='+id,
			success:function(){
				alert("reporting");
			}
		});
	});
</script>
</body>
</html>