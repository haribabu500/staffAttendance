<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="/StaffAtendance/resources/js/jquery.js"></script>
	<script src="/StaffAtendance/resources/js/jquery-ui.js"></script>
	<script src="/StaffAtendance/resources/js/jquery.datepick.js"></script>
	<script src="/StaffAtendance/resources/js/jquery.tablesorter.min.js"></script>
<div id="updateStaffContainer" class="left">
	<fieldset class="updateStaff">
		<legend>Update Staff</legend>
		<form:form id="updateStaffForm" modelAttribute="staff">
		<form:hidden path="id"/>
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
			<tr>
				<td>Join Date</td><td><form:input type="text" class="datepicker" path="startDate"/></td>
				<td><%-- Left Date</td><td><form:hidden type="text" class="datepicker" path="leftDate"/> --%></td>
			</tr>	
		</table>
		<script>
			jQuery(".datepicker").datepick();
		</script> 
		</form:form>
		<button id="update" class="aqua small">Update</button>
		<script type="text/javascript">
			jQuery("#update").click(function(){
				jQuery.post('updateStaffAction.htm',jQuery('#updateStaffForm').serialize(),function(data){
					alert("updated");
					//jQuery("#resultContainer").html("");
					jQuery.ajax({
						url:"updateStaff.htm",
						success:function(data){
							jQuery("#adminResultCOntainer").html(data);
						}
					});
					
				});
			});
		</script>
		<br><br>
		<div class="upadteView">
		<div class="metro">
		${resultTable }
		<script type="text/javascript">
			jQuery(".upadteView .metro tr").click(function(){
				var oid=jQuery(this).attr("name");
				jQuery.ajax({
					url:"updateStaff.htm?oid="+oid,
					success:function(data){
						jQuery("#updateStaffContainer").html(data);
					}
				});
			});
			jQuery(".routine").click(function(){
				//alert("tst");
				jQuery.ajax({
					url:"addStaffRoutine.htm?oid="+jQuery(this).closest( "tr" ).attr("name"),
					success:function(data){
						alert("Add routine");
						jQuery("#staffRoutine").html("");
						jQuery("#staffRoutine").html(data);
					}
				});
				/* jQuery("#staffRoutine").html(jQuery(this).attr("name")); */
			});
		</script>
		</div>
		</div>
	</fieldset>
</div>
<div id="staffRoutine" class="left"></div>