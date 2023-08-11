import org.apache.poi.hssf.usermodel.*;

import java.util.List;

/**
 * Created by cc on 2017/9/20
 * excel文件解析
 * @author 陈青山
 */
public class ExcelImportUtil {
    public static String zero="0";
    public static String one="1";
    public static String two="2";



    public static void createDownExcelForMarketing(HSSFWorkbook excel, List list, String s) {
        // 创建一个webbook 对于一个Excel
        // 在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = excel.createSheet(s);
        // 设置每个单元格宽度根据字多少自适应
        sheet.autoSizeColumn(1);
        // 在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((short) 0);
        row.setHeight((short)700);

        //设置字体
        HSSFFont font =excel.createFont();
        //字体
        font.setFontName("黑体");
        //宽度selectUserFunds
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        // 创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = excel.createCellStyle();
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 居中
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setFont(font);
        style.setWrapText(true);

        HSSFCell cell = row.createCell((short) 0);
        cell.setCellValue("字段/表名");
        cell.setCellStyle(style);

        cell = row.createCell((short) 1);
        cell.setCellValue("字段/表说明");
        cell.setCellStyle(style);


        sheet.setColumnWidth(0,5000);
        sheet.setColumnWidth(1,5000);


        importDataForMarketing( excel,list, sheet);
    }
    private static void importDataForMarketing(HSSFWorkbook wb, List<Table> list, HSSFSheet sheet) {
        HSSFCellStyle style = wb.createCellStyle();
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 居中
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setWrapText(true);
        HSSFCell hs = null;
        HSSFFont font = wb.createFont();
        //字体
        font.setFontName("黑体");
        //宽度
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        for (int i = 0; i < list.size(); i++) {
            HSSFRow row = sheet.createRow((short) i + 1);

            Table table = list.get(i);

            hs = row.createCell((short) 0);
            hs.setCellStyle(style);
            hs.setCellValue(table.getName());
            hs = row.createCell((short) 1);
            hs.setCellStyle(style);
            if("null".equals(table.getRemark())){
                hs.setCellValue("无");
            }else{
                hs.setCellValue(table.getRemark());
            }



        }

    }


}

