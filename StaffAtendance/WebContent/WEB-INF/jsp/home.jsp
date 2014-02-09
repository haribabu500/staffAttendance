<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/StaffAtendance/resources/css/style.css" type="text/css" rel="stylesheet" />
<script src="/StaffAtendance/resources/js/jquery.js"></script>
</head>
<body>
	<div class="metro left">
	<fieldset>
		<legend>Welcome to Home</legend>
		${staffs }		
		<br>
		<button id="submitAttendance" class="aqua small">Submit</button>	
	</fieldset>
	</div>
<script type="text/javascript">
	
	jQuery(".attendance").click(function(){
		if(jQuery(this).hasClass("absent")){
			jQuery(this).removeClass("absent");
			jQuery(this).addClass("present");
			jQuery(this).text("Present");
			jQuery(this).attr("present","true");
		}
		else if(jQuery(this).hasClass("present")){
			jQuery(this).removeClass("present");
			jQuery(this).addClass("absent");
			jQuery(this).text("Absent");
			jQuery(this).attr("present","false");
		}
	});
	
	jQuery("#submitAttendance").click(function(){
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
</script>
</body>
</html>