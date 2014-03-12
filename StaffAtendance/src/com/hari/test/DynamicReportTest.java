/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2013 Ricardo Mariaca
 * http://www.dynamicreports.org
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package com.hari.test;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.math.BigDecimal;

import com.hari.model.StaffTotalAttendance;

import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DynamicReportTest {
	private StaffTotalAttendance[] staffTotalAttendances;

	public DynamicReportTest() {
//		build();
	}

	public void build() {
		FontBuilder boldFont = stl.fontArialBold().setFontSize(12);

		TextColumnBuilder<String> staffColumn = col.column("Staff", "staff", type.stringType());
		TextColumnBuilder<Integer> absentColumn = col.column("Absent days", "absent", type.integerType());
		TextColumnBuilder<Integer> presentColumn = col.column("Present days", "present", type.integerType());

		try {
			report()
				.setTemplate(Templates.reportTemplate)
				.columns(staffColumn, absentColumn, presentColumn)
				.title(Templates.createTitleComponent("Staff LineChart"))
				.summary(
					cht.lineChart()
						.setTitle("Staff Attendance Report")
						.setTitleFont(boldFont)
						.setCategory(staffColumn)
						.series(
							cht.serie(absentColumn), cht.serie(presentColumn))
						.setCategoryAxisFormat(
							cht.axisFormat().setLabel("Staff")))
				.pageFooter(Templates.footerComponent)
				.setDataSource(createDataSource())
				.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("staff", "absent", "present");
		for (int i = 0; i < staffTotalAttendances.length; i++) {
			String name=staffTotalAttendances[i].getStaff().getFirstName();
			int present=staffTotalAttendances[i].getTotalPresentDays();
			int absent=staffTotalAttendances[i].getTotalAbsentDays();
			dataSource.add(name,absent,present);
		}
//		dataSource.add("Hari", 350, new BigDecimal(300));
//		dataSource.add("Pramod", 300, new BigDecimal(500));
//		dataSource.add("Manoj", 450, new BigDecimal(250));
//		dataSource.add("Binod", 450, new BigDecimal(250));
		return dataSource;
	}

	 

	public StaffTotalAttendance[] getStaffTotalAttendances() {
		return staffTotalAttendances;
	}

	public void setStaffTotalAttendances(
			StaffTotalAttendance[] staffTotalAttendances) {
		this.staffTotalAttendances = staffTotalAttendances;
	}

	public static void main(String[] args) {
		new DynamicReportTest();
	}
}
