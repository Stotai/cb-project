package com.qianya.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @Package: com.qianya.util
 * @ClassName: BinaryUtil
 * @Author: zzq
 * @Description:
 * @Date: 2020/8/13 9:31
 * @Version: 1.0
 */
public class BinaryUtil {

    public static Integer[] toChange(String uInt8Array) {
        String[] hexArray=uInt8Array.split(",");
        StringBuilder hexString=new StringBuilder("");
        for (int i = 0; i <hexArray.length ; i++) {
            if (hexArray[i].length()<2){
                hexString.append("0");
            }
            hexString.append(hexArray[i]);
        }

        // 解析前六位数据
        // 判断是否为Data1的数据 判断data1的正则表达式为 ^fffe0b[0-9ba-f]{2}2395
        //String hexString = uInt8Array.replaceAll(",","");
        if (hexString.length() < 13) {
            return null;
        }
        if (!hexString.toString().matches("^fffe0b[0-9a-f]{2}2395.*")) {
            return null;
        }
        String binaryString = parseHexToBinary(hexString.substring(12, 18));
        if (binaryString == null) {
            return null;
        }
        // byte0
        // 脉率第7位(1位) bit6为脉率第7位，老版本没有
        String hightPulseRateBitBinary = binaryString.substring(1, 2);
        // 连接标志(1位) bit5=1未连接传感器,=0为已连接
        String connectFlagBinary = binaryString.substring(2, 3);
        if ("1".equals(connectFlagBinary)) {
            return null;
        }
        // 搜索标志(1位) bit4=1，搜索时间太长
        String searchFlagBinary = binaryString.substring(3, 4);
        if ("1".equals(searchFlagBinary)) {
            return null;
        }
        // 信号强度：0-15(4位)
        String signalIntensityBinary = binaryString.substring(4, 8);
        // byte1
        // 脉率低7位 脉率有效范围：0-250（0x00-0xFA）此处只有0-6bit，第7bit使用byte0的bit6
        String lowPulseRateBitBinary = binaryString.substring(9, 16);
        // byte2 血氧值：0-100（大于100为无效值） 表达范围0-127（0x00-0x7f），现只用0-100（0x00-0x64）
        String bloodOxygenBinary = binaryString.substring(17, 24);
        // 脉率 高位+低位
        String pulseRateBitBinary = hightPulseRateBitBinary + lowPulseRateBitBinary;
        // 二进制数据转10进制数据
//        System.out.println("连接标志=======》" + Integer.valueOf(connectFlagBinary, 2));
//        System.out.println("搜索标志=======》" + Integer.valueOf(searchFlagBinary, 2));
//        System.out.println("信号强度=======》" + Integer.valueOf(signalIntensityBinary, 2));
//        System.out.println("血氧值=======》" + );
//        System.out.println("脉率值=======》" + );
        Integer[] rest=new Integer[2];
        rest[0]=Integer.valueOf(bloodOxygenBinary, 2);
        rest[1]=Integer.valueOf(pulseRateBitBinary, 2);
        return rest;
    }

    public static String parseUInt8ToHexString(Integer uInt8Value) {
        if (uInt8Value == null || uInt8Value > 255) {
            return "00";
        }
        String hexString = Integer.toHexString(uInt8Value);
        return hexString.length() < 2 ? "0" + hexString : hexString;
    }

    public static String parseHexToBinary(String hexString) {
        if (StringUtils.isBlank(hexString)) {
            return null;
        }
        StringBuilder binaryString = new StringBuilder();
        char[] hexChars = hexString.toCharArray();
        for (char hexChar : hexChars) {
            switch(hexChar) {
                case 'F':
                case 'f':
                    binaryString.append("1111");
                    break;
                case 'E':
                case 'e':
                    binaryString.append("1110");
                    break;
                case 'D':
                case 'd':
                    binaryString.append("1101");
                    break;
                case 'C':
                case 'c':
                    binaryString.append("1100");
                    break;
                case 'B':
                case 'b':
                    binaryString.append("1011");
                    break;
                case 'A':
                case 'a':
                    binaryString.append("1010");
                    break;
                case '9':
                    binaryString.append("1001");
                    break;
                case '8':
                    binaryString.append("1000");
                    break;
                case '7':
                    binaryString.append("0111");
                    break;
                case '6':
                    binaryString.append("0110");
                    break;
                case '5':
                    binaryString.append("0101");
                    break;
                case '4':
                    binaryString.append("0100");
                    break;
                case '3':
                    binaryString.append("0011");
                    break;
                case '2':
                    binaryString.append("0010");
                    break;
                case '1':
                    binaryString.append("0001");
                    break;
                default:
                    binaryString.append("0000");
                    break;
            }
        }
        return binaryString.toString();
    }
}
