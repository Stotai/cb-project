package com.qianya.file.util;

import com.qianya.common.JsonResult;
import com.qianya.file.comm.FileTypeEnum;
import com.qianya.util.LogUtil;
import com.qianya.util.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * @Title: OSSFileUploadController.java
 * @author Ralph Zhao
 * @since  2019-08-09 15:34
 * @Description: OSS文件上传操作控制器
 * @Copyright: Copyright (c) 2019
 * @source: Sunt.
 * @date: 2019年3月21日上午11:13:01
 * @version: 1.0
 */
@Component
@RefreshScope
public class OSSFileUploadUtil {
	
	@Value("${cb.oss.image-path}")
	private String imagePath;
	@Value("${cb.oss.endpoint}")
	private String endpoint;
	@Value("${cb.oss.access-key-id}")
	private String accessKeyId;
	@Value("${cb.oss.secret-access-key}")
	private String secretAccessKey;
	@Value("${cb.oss.bucket-name}")
	private String bucketName;
    @Value("${cb.path.image-server1}")
    private String imageServer1;
    
    /**
     * 上传公共方法
     * @author Xiang Zhao
     * @date 2018-12-20 PM 03:23
     * @param file
     * @return
     * @throws Exception
     */
    public JsonResult uploadMultipartFile(MultipartFile file,Integer type) {
		String ossPrefixPath="";
		switch (type){
			case 1 : ossPrefixPath="/img";break;
			case 2 : ossPrefixPath="/video";break;
			case 3 : ossPrefixPath="/file";break;
			default: ossPrefixPath="/other";
		}
    	try {
			if (!file.isEmpty()) {
				InputStream in = file.getInputStream();
				String name = file.getOriginalFilename();
				String ext = null;
				if (name.contains(".")) {
					ext = name.substring(name.lastIndexOf("."));
				}
				//验证文件格式
				String extUp = ext.toUpperCase();
				//判断是否支持上传
				String res = FileTypeEnum.isExist(type, extUp);
				if (res!=null){
					return JsonResult.error("只支持上传以下类型"+res);
				}
				String fileName = IDUtils.genIdString() + ext;
				JsonResult result = null;
				result = OSSUtils.uploadFile(endpoint, accessKeyId, secretAccessKey, bucketName, in, imagePath + ossPrefixPath, fileName);
				if (!result.getSuccess()) {
					return result;
				}
				return JsonResult.ok(result.getData());

			} else {
				return JsonResult.error("上传文件不能为空");
			}
		} catch (Exception e) {
			LogUtil.error(Object.class, e);
			return JsonResult.error("上传文件失败");
		}
    }
    
    /**
     * 将base64图存入阿里云 
     * @author Longxm
     * @date 2019年9月8日
     * @param 
     * @param imgSteam
     * @return
     * @throws Exception
     */
    public JsonResult uploadBase64Img(String imgSteam) throws Exception{

        if(StringUtil.isEmpty(imgSteam)){
            return JsonResult.error("请添加图片");
        }
        Base64.Decoder decoder = Base64.getDecoder();
        Map<String, String> param = new HashMap<>();
        
        if (ImageUtils.checkData2(imgSteam, param)) {
            String fileName = IDUtils.genIdString() + param.get(ImageUtils.KEY_SUFFIX);   
            JsonResult result = OSSUtils.uploadFile(endpoint, accessKeyId, secretAccessKey, bucketName,
            		new ByteArrayInputStream(decoder.decode(param.get(ImageUtils.KEY_IMAGEDATA))), 
            		imagePath + "/img", fileName);
            if (! result.getSuccess()) {
                return result;
            }
            return JsonResult.ok(result.getData());
        }else {
            return  JsonResult.error("图片格式错误");
        } 
    }
	/***
	 * @title   图片合成
	 * @Description
	 * @param: urls
	 * @return: com.qianya.common.JsonResult
	 * @Author lhl
	 * @Date 2023/6/19 9:58
	 */
    public JsonResult picCompound(String urls) {
		String[] split = urls.split(",");
		List<String> urlList=new ArrayList<>();
		for (String str : split) {
			if (StringUtil.isNotEmpty(str)){
				if (!str.contains("http")){
					return JsonResult.error("图片地址错误,识别失败");
				}
				urlList.add(str);
			}
		}
		if (urlList.size()==0){
			return JsonResult.error("图片地址获取失败");
		}
		try {
			String fileName = IDUtils.genIdString() + ".png";
			//用于合成的图片数量
			BufferedImage[] image =new BufferedImage[urlList.size()];
			for (int i = 0; i < urlList.size(); i++) {
				image[i]=CompoundPicUtilNew.loadImageUrl(urlList.get(i));
			}
			BufferedImage bufferedImage = CompoundPicUtilNew.modifyImagetogeter(CompoundPicUtilNew.handleLarge(88, 88, image));
			InputStream imageStream = CompoundPicUtilNew.getImageStream(bufferedImage);
			JsonResult result = OSSUtils.uploadFile(endpoint, accessKeyId, secretAccessKey, bucketName,
					imageStream,
					imagePath + "/img/hc", fileName);
			if (! result.getSuccess()) {
				return result;
			}
			return JsonResult.ok(result.getData());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JsonResult.error();
	}
}