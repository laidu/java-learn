package org.laidu.learn.apache.poi.create;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * create excel
 * <p>
 * Created by tiancai.zang
 * on 2018-04-28 15:11.
 */
@Slf4j
public class CreateExcel {



    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();

        String excelPath = "/Users/laidu/IdeaProjects/java-learn/framework/common/apache-poi/src/main/resources/excel/";
        FileOutputStream out = new FileOutputStream(new File(excelPath +"createworkbook.xlsx"));

        XSSFSheet defalut = workbook.createSheet("default1");
        XSSFRow row = defalut.createRow(1);
//        IntStream.range(0,10).forEach(index -> row.createCell(index,CellType.NUMERIC));




        workbook.write(out);
        out.close();
        System.out.println("demo.xlsx written successfully");

    }
}