<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link href="/StaffAtendance/resources/css/style.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="/StaffAtendance/resources/css/jquery.datepick.css">
<link rel="stylesheet" href="/StaffAtendance/resources/css/jquery-ui.css">
<script src="/StaffAtendance/resources/js/jquery.js"></script>
<script src="/StaffAtendance/resources/js/jquery-ui.js"></script>
<script src="/StaffAtendance/resources/js/jquery.datepick.js"></script>

<div class="wrapper">
<div>
	<fieldset class="addStaff">
		<legend>Add Staff</legend>
		<form:form id="addStaffForm" modelAttribute="staff">
		<table>
			<tr><td>First Name</td><td><form:input path="firstName"/></td>
				<td>Last Name</td><td><form:input path="lastName"/></td>
			</tr>
			<tr>
				<td>Contact No.</td><td><form:input path="contact"/></td>
				<td></td><td></td>
			</tr>
			<tr>
				<td>Address</td><td><form:input path="address"/></td>
				<td></td><td></td>
			</tr>
			<tr>
				<td>Staff Type</td>
				<td>
					<form:select path="type.id">
						<c:forEach var="staffType" items="${types}">
							<option value="${staffType.id}">${staffType.type }</option>
						</c:forEach>
					</form:select>
				</td>
				<td></td><td></td>
			</tr>
			<%-- <tr>
				<td>Address</td><td><form:textarea path="address"></form:textarea></td>
				<td></td><td></td>
			</tr> --%>
			<tr>
				<td>Join Date</td><td><form:input type="text" id="datepicker" path="startDate"/>
				<script>
				 $(function() {
					 $( "#datepicker" ).datepick();
					 });
						jQuery("#datepicker").datepick();
						
				</script> 
				</td>
				<td></td><td></td>
			</tr>	
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>	
		</table>
		</form:form>
		<button id="add" class="aqua small">Add staff</button>
	</fieldset>
	
		<script src="/StaffAtendance/resources/js/jquery.js"></script>
			<script type="text/javascript">
			jQuery("#add").click(function(){
				/* jQuery("#resultContainer").html("<img src='/Camsort_Web/resources/images/loading.gif' height='100' width='100'/>"); */
				jQuery.post('addStaffAction.htm',jQuery('#addStaffForm').serialize(),function(data){
					alert("Staff Added");
				});
			});
			</script>
</div>
</div>