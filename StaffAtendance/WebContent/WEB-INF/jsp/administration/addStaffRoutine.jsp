<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="metro">
	<fieldset>
		<legend>Add Staff Routine</legend>
		${staff.firstName } ${staff.lastName } <br>
		<form:form id="addRoutine" modelAttribute="schedule" action="">
			 <table class="staffTable">
			 <thead>
			 	<tr><th>Day</th><th>Shift From</th><th>Shift To</th></tr>
			 </thead>
			 <tbody>
				<tr><td><label>Sunday:</label></td><td><form:input path="sundayFrom"/> </td><td><form:input path="sundayTo"/> </td></tr>
					 <tr><td><label>Monday:</label></td><td><form:input path="mondayFrom"/></td><td><form:input path="mondayTo"/></td></tr>
					 <tr><td><label>Tuesday:</label></td><td><form:input path="tuesdayFrom"/></td><td><form:input path="tuesdayTo"/></td></tr>
					 <tr><td><label>Wednesday:</label></td><td><form:input path="wednesdayFrom"/></td><td><form:input path="wednesdayTo"/></td></tr>
					 <tr><td><label>Thursday:</label></td><td><form:input path="thursdayFrom"/></td><td><form:input path="thursdayTo"/></td></tr>
					 <tr><td><label>Friday:</label></td><td><form:input path="fridayFrom"/></td><td><form:input path="fridayTo"/></td></tr>
					 <tr><td><label>Saturday:</label></td><td><form:input path="saturdayFrom"/></td><td><form:input path="saturdayTo"/></td></tr>
			</tbody>
			 </table>
		 </form:form>
		 <button id="saveRoutine" class="aqua small">Save Routine</button>
		 <script type="text/javascript">
		 	jQuery("#saveRoutine").click(function(){
		 		jQuery.post('addStaffRoutineAction.htm?oid=${staff.id}',jQuery('#addRoutine').serialize(),function(data){
					alert("Routine Added ${staff.firstName }");
					//jQuery("#resultContainer").html("");
					
				});
		 	});
		 </script>
	</fieldset>
	
</div>