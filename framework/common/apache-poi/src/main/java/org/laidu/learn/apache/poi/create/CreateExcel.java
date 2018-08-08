package org.laidu.learn.apache.poi.create;

import jodd.io.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.File;
import java.io.IOException;
import java.util.stream.IntStream;

/**
 * create excel
 * <p>
 * Created by tiancai.zang
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

        HSSFSheet sheet0 = workbook.createSheet("sheet0");

        HSSFRow row0 = sheet0.createRow(0);

        IntStream.range(0,10).parallel().forEach(i -> {
            HSSFCell cell = row0.createCell(i, CellType.STRING);
            cell.setCellValue(i+"da");
        });

        workbook.write(new File(workDir+"/HSSFWorkbook.xls"));

    }



    public static void main(String[] args) throws IOException {


        createHSSFWorkbook();

    }
}