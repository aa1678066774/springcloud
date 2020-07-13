package com.tww.poi;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
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
        Path path= Paths.get("D:\\Documents\\WXWork\\1688853003882306\\Cache\\File\\2020-05\\募集资金分流数据.xlsx");
        Workbook wb = WorkbookFactory.create(Files.newInputStream(path));
        FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
        wb.forEach(sheet->{
            if(sheet.getSheetName().equals("北京极简时代软件科技有限公司")){
                sheet.forEach(row->{
                    String sql="INSERT INTO `ssb_ibt`.`ssb_analysis_bank_statement`(`user_id`, `trade_time`, `debit_side`, `bank_name`, `company_name`, `account_name`, `account_number`, `credit_side`, `summary`, `balance`,`file_id`, `page`,  `project_id`) VALUES (";
                    StringBuilder builder=new StringBuilder(sql);
                    row.forEach(cell->{
                        CellValue c = evaluator.evaluate(cell);    //单元格值对象
                        if (c != null) {    //判断单元格是否有值
                            switch (c.getCellTypeEnum()) {
                                case STRING:
                                    String str = c.getStringValue();    //得到单元格值
//                                    System.out.print(str+"\t");
                                    builder.append(",\""+str+"\"");
                                    break;
                                case NUMERIC:
                                    if(DateUtil.isCellDateFormatted(cell)){
                                        Date date = cell.getDateCellValue();
//                                        System.out.print(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date)+"\t");
                                        builder.append(",\""+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date)+"\"");
                                        break;
                                    }
                                    DecimalFormat  df = new DecimalFormat("0.00");
//                                    System.out.print(df.format(c.getNumberValue()) +"\t");
                                    builder.append(","+df.format(c.getNumberValue()));
                                    break;
                                default:
                                    System.out.print("---");
                            }
                        }
                    });
//                    System.out.println("---");
                    System.out.println(builder.append(",\"888888888888888888888888888\",0,1)").toString());
                });
            }
        });
    }
}
