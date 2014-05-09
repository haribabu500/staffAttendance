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

package com.hari.report;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.math.BigDecimal;
import java.util.List;

import com.hari.model.Attendance;
import com.hari.model.Staff;
import com.hari.model.StaffTotalAttendance;
import com.hari.service.EasServiceManager;

import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.constant.Orientation;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class IndividualStaffMonthReport {
	Staff staff;
	public IndividualStaffMonthReport(Staff staff) {
		this.staff=staff;
	}
	
	public void build() {
		FontBuilder boldFont = stl.fontArialBold().setFontSize(12);

		TextColumnBuilder<String> staffColumn = col.column("Month", "month", type.stringType());
		TextColumnBuilder<Long> absentColumn = col.column("Absent days", "absent", type.longType());
		TextColumnBuilder<Long> presentColumn = col.column("Present days", "present", type.longType());
		Orientation orientation=Orientation.VERTICAL;

		try {
			report()
				.setTemplate(Templates.reportTemplate)
				.columns(staffColumn, absentColumn, presentColumn)
				.title(Templates.createTitleComponent(staff.getFirstName()+" "+staff.getLastName()))
				.summary(
					cht.lineChart()
//					cht.stackedBarChart()
						.setTitle(staff.getFirstName()+"'s Attendance Report")
						.setTitleFont(boldFont)
						.setCategory(staffColumn)
						.series(
							cht.serie(absentColumn), cht.serie(presentColumn))
						.setCategoryAxisFormat(
							cht.axisFormat().setLabel("Month")))
				.pageFooter(Templates.footerComponent)
				.setDataSource(createDataSource())
				.show(false);
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("month", "absent", "present");
		for(int i=1;i<=12;i++){
			List present=EasServiceManager.select("select count(a) from Attendance a where FUNC('MONTH', a.date)="+i+" and a.status='P' and a.staff.id="+staff.getId(), Attendance.class);
			List absent=EasServiceManager.select("select count(a) from Attendance a where FUNC('MONTH', a.date)="+i+" and a.status='A' and a.staff.id="+staff.getId(), Attendance.class);
			if(i==1)
				dataSource.add("jan",present.get(0),absent.get(0));
			else if(i==2)
				dataSource.add("feb",present.get(0),absent.get(0));
			else if(i==3)
				dataSource.add("mar",present.get(0),absent.get(0));
			else if(i==4)
				dataSource.add("apr",present.get(0),absent.get(0));
			else if(i==5)
				dataSource.add("may",present.get(0),absent.get(0));
			else if(i==6)
				dataSource.add("jun",present.get(0),absent.get(0));
			else if(i==7)
				dataSource.add("jul",present.get(0),absent.get(0));
			else if(i==8)
				dataSource.add("aug",present.get(0),absent.get(0));
			else if(i==9)
				dataSource.add("sept",present.get(0),absent.get(0));
			else if(i==10)
				dataSource.add("oct",present.get(0),absent.get(0));
			else if(i==11)
				dataSource.add("nov",present.get(0),absent.get(0));
			else if(i==12)
				dataSource.add("dec",present.get(0),absent.get(0));
				
			System.out.println("-----------"+i);
			System.out.println(present.get(0));
			System.out.println(absent.get(0));
		}
		return dataSource;
	}
	/*public static void main(String[] args) {
		IndividualStaffMonthReport individualStaffMonthReport=new IndividualStaffMonthReport(252);
//		individualStaffMonthReport.createDataSource();
		individualStaffMonthReport.build();
	}*/
}
