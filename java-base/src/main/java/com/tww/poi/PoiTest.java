package com.tww.poi;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-11 09:32
 */
public class PoiTest {

    public static void main(String[] args) throws IOException, InvalidFormatException {
        Path path= Paths.get("C:\\Users\\Administrator\\Desktop\\excel\\a.xlsx");
        Workbook wb = WorkbookFactory.create(Files.newInputStream(path));
        FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
        wb.forEach(sheet->{
            sheet.forEach(row->{
                row.forEach(cell->{
                    CellValue c = evaluator.evaluate(cell);    //单元格值对象
                    if (c != null) {    //判断单元格是否有值
                        switch (c.getCellTypeEnum()) {
                            case STRING:
                                String str = c.getStringValue();    //得到单元格值
                                System.out.print(str+"\t");
                                break;
                            case NUMERIC:
                                if(DateUtil.isCellDateFormatted(cell)){
                                    Date date = cell.getDateCellValue();
                                    System.out.print(new SimpleDateFormat("yyyy-MM-dd").format(date));
                                    break;
                                }
                                Double num = c.getNumberValue(); //得到单元格内数字
                                System.out.print(num +"\t");
                                break;
                            default:
                                System.out.print("---");
                        }
                    }
                });
                System.out.println();
            });
        });

    }
}
