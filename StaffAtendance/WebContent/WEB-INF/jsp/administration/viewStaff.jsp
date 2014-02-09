<script src="/StaffAtendance/resources/js/jquery.bpopup.min.js"></script>
<div class="metro left">
	<fieldset class="viewStaff">
		<legend>Staff Details</legend>
		${resultTable }
	</fieldset>
	<script type="text/javascript">
		jQuery(".staffTable").tablesorter();
		jQuery(".routine").click(function(){
			jQuery.ajax({
				url:"staffRoutine.htm?oid="+jQuery(this).closest( "tr" ).attr("name"),
				success:function(data){
					jQuery("#staffRoutine").html(data);
				}
			});
			/* jQuery("#staffRoutine").html(jQuery(this).attr("name")); */
		});
		
	</script>
</div>
<div id="staffRoutine" class="left"></div>