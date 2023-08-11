package com.qianya.file.util;


import com.qianya.util.StringUtil;

import java.util.Map;

public class ImageUtils {
	
	private static final String TYPE_GIF = "data:image/gif;base64,";
    private static final String TYPE_PNG = "data:image/png;base64,";
    private static final String TYPE_JEPG = "data:image/jpeg;base64,";
	
    public static final String KEY_SUFFIX = "suffix";
    public static final String KEY_IMAGEDATA = "imageData";
    
	/**
     * @return Boolean    返回类型
     * @throws
     * @Title: checkData
     * @Description: 检查参数
     * @author Sunt.
     * @time 2018年9月7日 下午2:55:56
     */
    public static Boolean checkData(String path, StorageState state, String imageData, Map<String, String> param) {

        if (StringUtil.isEmpty(path) || StringUtil.isEmpty(imageData)) {
            state.setMsg("参数不能为空");
            return false;
        }

        if (imageData.startsWith(TYPE_GIF)) {
            param.put("suffix", ".gif");
            param.put("imageData", imageData.substring(TYPE_GIF.length()));
        } else if (imageData.startsWith(TYPE_JEPG)) {
            param.put("suffix", ".jpg");
            param.put("imageData", imageData.substring(TYPE_JEPG.length()));
        } else if (imageData.startsWith(TYPE_PNG)) {
            param.put("suffix", ".png");
            param.put("imageData", imageData.substring(TYPE_PNG.length()));
        } else {
            state.setMsg("数据类型不是图片");
            return false;
        }

        return true;
    }

    /**
     * @return Boolean    返回类型
     * @throws
     * @Title: checkData
     * @Description: 检查参数
     * @author Sunt.
     * @time 2018年9月7日 下午2:55:56
     */
    public static Boolean checkData2(String imageData, Map<String, String> param) {
        if (imageData.startsWith(TYPE_GIF)) {
            param.put("suffix", ".gif");
            param.put("imageData", imageData.substring(TYPE_GIF.length()));
        } else if (imageData.startsWith(TYPE_JEPG)) {
            param.put("suffix", ".jpg");
            param.put("imageData", imageData.substring(TYPE_JEPG.length()));
        } else if (imageData.startsWith(TYPE_PNG)) {
            param.put("suffix", ".png");
            param.put("imageData", imageData.substring(TYPE_PNG.length()));
        } else {
            return false;
        }

        return true;
    }
}
