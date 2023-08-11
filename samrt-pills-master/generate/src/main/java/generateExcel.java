import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class GenerateExcel {

    /**
     * 生成数据库文档说明
     * @param aa
     * @throws Exception
     */
    public static void main(String[] aa) throws Exception {
        List<String> list=getFileString();
        List<String> list2 = new ArrayList();
        for (String a : list) {
            if (a.contains("ENGINE=InnoDB") || a.contains("CREATE")) {
                if (a.contains("ENGINE=InnoDB")) {
                    a = getKey3(a);
                    a = getKey4(a);
                } else {
                    a = getKey(a);
                    a = getKey2(a);
                }
                a += "-表名";
                list2.add(a);
            } else if (!a.contains("DROP") && !a.contains("PRIMARY KEY") && !a.contains("UNIQUE KEY") && !a.contains("-") && !a.contains("Table")) {
                a = getKey(a);
                String one = getKey2(a);
                if(a!=null) {
                    a = a.replace(" ", "");
                    a = getKey3(a);
                    a = getKey4(a);

                    if (one != null && !"".equals(one)) {
                        a = one + "-" + a;
                        list2.add(a);
                    }
                }
            }
        }
        HSSFWorkbook excel = new HSSFWorkbook();
        List<Table> list3 = null;
        List<Table> list4 = new ArrayList<>();
        List<List<Table>> list5 = new ArrayList<>();
        Integer i = 0;
        for (String aaaa : list2) {
            if (i == 0) {
                list3 = new ArrayList();
            }
            String[] a4 = aaaa.split("-");
            if (aaaa.contains("表名")) {
                i += 1;
            }
            if(!aaaa.contains("表名")||i==1) {
                Table table = new Table();
                table.setName(a4[0]);
                table.setRemark(a4[1]);
                list3.add(table);
            }
            if (i == 2) {
                Table table2 = list3.get(0);
                table2.setRemark(a4[0]);
                list4.add(table2);
                list3.set(0, table2);
                list5.add(list3);
                i = 0;
            }
        }
        List<Table> list6=list5.get(0);
        Table table2=list4.get(0);
        list4.add(table2);
        list4.remove(0);
        list5.set(0,list4);
        list5.add(list6);
        int y=0;
        for(List<Table> list7:list5){
            y+=1;
            if(y==1){
                ExcelImportUtil.createDownExcelForMarketing(excel,list7, "数据库总览");
            }else{
                ExcelImportUtil.createDownExcelForMarketing(excel,list7, list7.get(0).getRemark());
            }
        }
        File files=new File("E:\\最新数据库说明.xls");
        FileOutputStream mOutputStream = new FileOutputStream(files);
        excel.write(mOutputStream);
        mOutputStream.flush();
    }

    public static String getKey(String a) {
        if (a == null) {
            return "";
        }
        int p = a.indexOf("`");
        if (p > 0) {
            a = a.substring(p + 1);
        } else {
            return null;
        }
        return a;
    }

    public static String getKey2(String a) {
        if (a == null) {
            return "";
        }
        int p1 = a.indexOf("`");
        //第一个key表名或者字段名
        String b = null;
        if (p1 > 0) {
            b = a.substring(0, p1);
        }
        return b;
    }

    public static String getKey3(String a) {
        if (a == null) {
            return "";
        }
        int p = a.indexOf("'");
        if (p > 0) {
            a = a.substring(p + 1);
        }
        return a;
    }

    public static String getKey4(String a) {
        if (a == null) {
            return "";
        }
        int p1 = a.lastIndexOf("'");
        if(p1==-1){
            return "无";
        }

        a=a.substring(0,p1);
        int p2 = a.lastIndexOf("'");
        //第一个key表名或者字段名
        String b = null;
        if ( p2!=-1) {
            b = a.substring(p2+1);
        }else{
            b=a;
        }
        return b;
    }
    public static  List<String> getFileString(){
        String fileUrl = "C:\\Users\\Administrator\\Desktop\\cqs-test.sql";
        File file = new File(fileUrl);
        BufferedReader reader = null;
        List<String> list = new ArrayList();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;

            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                list.add(String.valueOf(tempString));
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return list;
    }


}


class Table {
    String name;
    String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}