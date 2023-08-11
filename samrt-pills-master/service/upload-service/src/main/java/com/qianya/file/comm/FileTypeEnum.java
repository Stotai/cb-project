package com.qianya.file.comm;

import com.qianya.exception.CustomException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public enum FileTypeEnum {
    PIC1(1, ".JPEG"),
    PIC2(1, ".JPG"),
    PIC3(1, ".PNG"),
    PIC4(1, ".GIF"),
    PIC5(1, ".WEBP"),
    VID1(2, ".AVI"),
    VID2(2, ".WMV"),
    VID3(2, ".MP4"),
    FILE1(3, ".TXT"),
    FILE2(3, ".XLS"),
    FILE3(3, ".XLSX"),
    FILE4(3, ".DOC"),
    FILE5(3, ".DOCX"),
    FILE6(3, ".PDF");

    private final int typeCode;
    private final String typeName;

    FileTypeEnum(int typeCode, String typeName) {
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public static String isExist(int type, String typeName) {
        if (type==0){
            return null;
        }
        List<String> list=new ArrayList<>();
        for (FileTypeEnum status : FileTypeEnum.values()) {
            if (status.getTypeCode() == type) {
                if (typeName.equals(status.getTypeName())){
                    return null;
                }
                list.add(status.getTypeName());
            }
        }
       return list.stream().collect(Collectors.joining());
    }
}
