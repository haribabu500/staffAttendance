<div class="metro">
	<fieldset>
		<legend>Staff Routine</legend>
		${staff.firstName } ${staff.lastName } <br>
		 <table class="staffTable">
		 <thead>
		 	<tr><th>Day</th><th>Shift From</th><th>Shift To</th></tr>
		 </thead>
		 <tbody>
			 <tr><td><label>Sunday:</label></td><td>${schedule.sundayFrom}</td><td>${schedule.sundayTo}</td></tr>
			 <tr><td><label>Monday:</label></td><td>${schedule.mondayFrom}</td><td>${schedule.mondayTo}</td></tr>
			 <tr><td><label>Tuesday:</label></td><td>${schedule.tuesdayFrom}</td><td>${schedule.tuesdayTo}</td></tr>
			 <tr><td><label>Wednesday:</label></td><td>${schedule.wednesdayFrom}</td><td>${schedule.wednesdayTo}</td></tr>
			 <tr><td><label>Thursday:</label></td><td>${schedule.thursdayFrom}</td><td>${schedule.thursdayTo}</td></tr>
			 <tr><td><label>Friday:</label></td><td>${schedule.fridayFrom}</td><td>${schedule.fridayTo}</td></tr>
			 <tr><td><label>Saturday:</label></td><td>${schedule.saturdayFrom}</td><td>${schedule.saturdayTo}</td></tr>
		</tbody>
		 </table>
		 
	</fieldset>
	
</div>