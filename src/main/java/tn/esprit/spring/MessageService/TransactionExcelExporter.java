package tn.esprit.spring.MessageService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.MessageRepository.MessageRepository;
import tn.esprit.spring.entities.Message;






public class TransactionExcelExporter {
	private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Message> listTrans;
    @Autowired
    MessageRepository messagerepository;
    public TransactionExcelExporter(List<Message> listTrans) {
        this.listTrans = listTrans;
        workbook = new XSSFWorkbook();
    }
    
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Transactions");
         
        XSSFRow row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        createCell(row, 0, "Sender", style);      
        createCell(row, 1, "Object", style);       
        createCell(row, 2, "Content", style);    
        
      
    }
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof java.lang.Float) {
            cell.setCellValue((float) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
     
    private void writeDataLines() {
        int rowCount = 1;

    	
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (Message t : listTrans) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
           // createCell(row, columnCount++, t.getId(), style);
            createCell(row, columnCount++, t.getContentM(), style);
            createCell(row, columnCount++, t.getObjectM(), style);
            createCell(row, columnCount++, t.getUser().getFirstName(), style);
      
        }
    }
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
         
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }
}
