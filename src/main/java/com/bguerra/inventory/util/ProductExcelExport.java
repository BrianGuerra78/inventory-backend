package com.bguerra.inventory.util;

import com.bguerra.inventory.model.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductExcelExport {

    private XSSFWorkbook workbook;

    private XSSFSheet sheet;

    private List<Product> product;

    public ProductExcelExport (List<Product> products){
        this.product = products;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine(){
        sheet = workbook.createSheet("Resultado");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();

        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row,0,"ID",style);
        createCell(row,1,"Nombre",style);
        createCell(row,2,"Precio",style);
        createCell(row,3,"Cantidad",style);
        createCell(row,4,"Categoria",style);
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style){
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);

        if(value instanceof  Integer){
            cell.setCellValue((Integer) value);
        }else if (value instanceof Boolean){
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines(){
        int rowCount =1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for(Product result: product){
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row,columnCount++, String.valueOf(result.getId()), style);
            createCell(row,columnCount++, result.getName(), style);
            createCell(row,columnCount++, result.getPrice(), style);
            createCell(row,columnCount++, result.getAccount(), style);
            createCell(row,columnCount++, result.getCategory().getName(), style);
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();//write the header
        writeDataLines();//write the data

        ServletOutputStream servletOutput = response.getOutputStream();
        workbook.write(servletOutput);
        workbook.close();

        servletOutput.close();
    }
}
