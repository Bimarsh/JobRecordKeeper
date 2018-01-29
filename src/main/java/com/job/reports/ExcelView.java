package com.job.reports;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.job.modal.Job;
@Component("forexView")
public class ExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// change the file name
	    response.setHeader("Content-Disposition", "attachment; filename=\"JobReport.xls\"");

	    @SuppressWarnings("unchecked")
	    List<Job> jobs =  (List<Job>) model.get("jobs");

	    // create excel xls sheet
	    Sheet sheet = workbook.createSheet("User Detail");
	    sheet.setDefaultColumnWidth(30);

	    // create style for header cells
	    CellStyle style = workbook.createCellStyle();
	    Font font = workbook.createFont();
	    font.setFontName("Arial");
	    style.setFillForegroundColor(HSSFColor.BLUE.index);
	    font.setBold(true);
	    font.setColor(HSSFColor.WHITE.index);
	    style.setFont(font);


	    // create header row
	    Row header = sheet.createRow(0);
	    header.createCell(0).setCellValue("Position");
	    header.getCell(0).setCellStyle(style);
	    header.createCell(1).setCellValue("Registered Date");
	    header.getCell(1).setCellStyle(style);
	    header.createCell(2).setCellValue("Company Name");
	    header.getCell(2).setCellStyle(style);
	    header.createCell(3).setCellValue("Type");
	    header.getCell(3).setCellStyle(style);
	    header.createCell(4).setCellValue("Email");
	    header.getCell(4).setCellStyle(style);
	    header.createCell(5).setCellValue("State");
	    header.getCell(5).setCellStyle(style);
	    header.createCell(6).setCellValue("Source");
	    header.getCell(6).setCellStyle(style);
	    header.createCell(7).setCellValue("Job Description");
	    header.getCell(7).setCellStyle(style);
	   



	    int rowCount = 1;

	    for(Job job : jobs){
	        Row userRow =  sheet.createRow(rowCount++);
	        userRow.createCell(0).setCellValue(job.getPosition());
	        userRow.createCell(1).setCellValue(job.getRegisteredDate().toString());
	        userRow.createCell(2).setCellValue(job.getEmployer().getCompanyName());
	        userRow.createCell(3).setCellValue(job.getEmployer().getEmployerType().toString());
	        userRow.createCell(4).setCellValue(job.getEmployer().getAddress().getEmail());
	        userRow.createCell(5).setCellValue(job.getEmployer().getAddress().getState());
	        userRow.createCell(6).setCellValue(job.getEmployer().getAddress().getSource());
	        userRow.createCell(7).setCellValue(job.getJobDescription());

	        }
		
	}

}
