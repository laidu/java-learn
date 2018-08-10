package org.laidu.learn.apache.poi.create;

import jodd.io.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.laidu.commom.util.file.MsOfficeType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.IntStream;

/**
 * create excel
 * <p>
 *
 * @author tiancai.zang
 * on 2018-04-28 15:11.
 */
@Slf4j
public class CreateExcel {

    private static final String workDir = System.getProperty("user.home")+"/temp/excel/";

    static {
        if (!FileUtil.isExistingFolder(new File(workDir))) {
            try {
                FileUtil.mkdir(new File(workDir));
                System.out.println("成功创建 工作目录 : " + workDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void createHSSFWorkbook() throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();


        IntStream.range(0,10).forEach(i -> {
            HSSFSheet sheet0 = workbook.createSheet("sheet"+i);
            HSSFRow row0 = sheet0.createRow(0);
            HSSFCell cell = row0.createCell(0, CellType.STRING);
            cell.setCellValue(i+"测试数据");
        });

        workbook.write(new File(workDir+"/HSSFWorkbook.xls"));

    }


    public static  void  createXSSFWorkbook() throws IOException {

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();

        IntStream.range(0,10).forEach(i -> {
            XSSFSheet sheet = xssfWorkbook.createSheet("sheet" + i);
            XSSFRow row0 = sheet.createRow(0);
            XSSFCell cell = row0.createCell(0, CellType.STRING);
            cell.setCellValue(i+"测试数据");
        });

        xssfWorkbook.write(new FileOutputStream(new File(workDir+"/HSSFWorkbook.xlsx")));
    }


    public static void readWorkbook(String fileName) throws IOException{

        try (FileInputStream excel = new FileInputStream(workDir+"/"+fileName)) {


            String fileHead = org.laidu.commom.util.file.FileUtil.INSTANCE.getFileHead(excel);

            log.info("file head: {}", fileHead);

            String typeByValue = MsOfficeType.getTypeByValue(fileHead);
            
            log.info(": {}", typeByValue);


        }

    }


    public static void main(String[] args) throws IOException {


//        createHSSFWorkbook();

//        createXSSFWorkbook();

        readWorkbook("0807合益进件名单.xlsx");
    }
}