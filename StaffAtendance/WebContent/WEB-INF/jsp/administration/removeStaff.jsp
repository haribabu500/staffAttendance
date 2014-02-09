<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="metro">
	<fieldset class="removeStaff">
		<legend>Remove Staff</legend>
		${resultTable }
		
	</fieldset>
	<script type="text/javascript">
		jQuery(".staffTable").tablesorter();
		jQuery(".remStaff").click(function(){
			var url="removeStaffAction.htm?oid="+jQuery(this).attr('name');
			alert(url);
			jQuery.ajax({
				url:url,
				success:function(){
					jQuery.ajax({
						url:"removeStaff.htm",
						success:function(data){
							jQuery("#adminResultCOntainer").html(data);
						}
					});
				}
			});
		});
	</script>
</div>