package com.qianya.file.util;

import com.qianya.util.LogUtil;
import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 把两张图片合并一张
 */
public class CompoundPicUtilNew {
    /**
     *
     * @Title: modifyImagetogeter
     * @Description: 将几张图片合成一张图片
     * @param: @param b1
     * @param: @param b2
     * @param: @param b3
     * @param: @return      
     * @return: BufferedImage
     * @throws
     * @author:石德斌
     * @date:2020年4月21日 下午3:26:41
     */
    public static BufferedImage modifyImagetogeter(BufferedImage[] image) {
        //创建一个304*304的图片
        BufferedImage tag = new BufferedImage(304,304,BufferedImage.TYPE_INT_RGB);
        try {
            Graphics2D graphics = tag.createGraphics();
            //设置颜色为218，223，224
            graphics.setColor(new Color(218,223,224));
            //填充颜色
            graphics.fillRect(0, 0, 304, 304);
            int count = image.length;
            //根据不同的合成图片数量设置图片放置位置
            if(count == 1){
                int startX = 108;
                int startY = 108;
                BufferedImage b = image[0];
                graphics.drawImage(b, startX, startY, b.getWidth(), b.getHeight(), null);
            }else if(count == 2){
                int startX = 60;
                int startY = 108;
                BufferedImage b1 = image[0];
                graphics.drawImage(b1, startX, startY, b1.getWidth(), b1.getHeight(), null);
                BufferedImage b2 = image[1];
                startX = startX + b1.getWidth()+8;
                graphics.drawImage(b2, startX, startY, b2.getWidth(), b2.getHeight(), null);
            }else if(count == 3){
                int startX = 108;
                int startY = 60;
                BufferedImage b1 = image[0];
                graphics.drawImage(b1, startX, startY, b1.getWidth(), b1.getHeight(), null);
                BufferedImage b2 = image[1];
                startX = 60;
                startY = 60 + b1.getHeight() + 8;
                graphics.drawImage(b2, startX, startY, b2.getWidth(), b2.getHeight(), null);
                BufferedImage b3 = image[2];
                startX = startX + b2.getWidth()+8;
                graphics.drawImage(b3, startX, startY, b3.getWidth(), b3.getHeight(), null);
            }else if(count == 4){
                int startX = 60;
                int startY = 60;
                BufferedImage b1 = image[0];
                graphics.drawImage(b1, startX, startY, b1.getWidth(), b1.getHeight(), null);
                BufferedImage b2 = image[1];
                startX = 60 + b1.getWidth() + 8;
                graphics.drawImage(b2, startX, startY, b2.getWidth(), b2.getHeight(), null);
                BufferedImage b3 = image[2];
                startX = 60;
                startY = 60 + b2.getHeight() + 8;
                graphics.drawImage(b3, startX, startY, b3.getWidth(), b3.getHeight(), null);
                BufferedImage b4 = image[3];
                startX = 60 + b3.getWidth() + 8;
                graphics.drawImage(b4, startX, startY, b4.getWidth(), b4.getHeight(), null);
            }else if(count == 5){
                int startX = 60;
                int startY = 60;
                BufferedImage b1 = image[0];
                graphics.drawImage(b1, startX, startY, b1.getWidth(), b1.getHeight(), null);
                BufferedImage b2 = image[1];
                startX = startX + b1.getWidth()+8;
                graphics.drawImage(b2, startX, startY, b2.getWidth(), b2.getHeight(), null);
                startX = 12;
                startY = 12 + startY + b2.getHeight();
                for(int i = 2;i<count;i++){
                    BufferedImage b = image[i];
                    graphics.drawImage(b, startX, startY, b.getWidth(), b.getHeight(), null);
                    startX = startX + b.getWidth() + 8;
                }
            }else if(count == 6){
                int startX = 12;
                int startY = 60;
                for(int i = 0;i<count;i++){
                    BufferedImage b = image[i];
                    graphics.drawImage(b, startX, startY, b.getWidth(), b.getHeight(), null);
                    startX = startX + b.getWidth() + 8;
                    if((i+1)%3 == 0){
                        startY = startY + b.getHeight() + 8;
                        startX = 12;
                    }
                }
            }else if(count == 7){
                int startX = 108;
                int startY = 12;
                BufferedImage b = image[0];
                graphics.drawImage(b, startX, startY, b.getWidth(), b.getHeight(), null);
                startX = 12;
                startY = startY + 8 + b.getHeight();
                for(int i = 1;i<count;i++){
                    b = image[i];
                    graphics.drawImage(b, startX, startY, b.getWidth(), b.getHeight(), null);
                    startX = startX + b.getWidth() + 8;
                    if(i%3 == 0){
                        startY = startY + b.getHeight() + 8;
                        startX = 12;
                    }
                }
            }else if(count == 8){
                int startX = 60;
                int startY = 12;
                BufferedImage b1 = image[0];
                graphics.drawImage(b1, startX, startY, b1.getWidth(), b1.getHeight(), null);
                BufferedImage b2 = image[1];
                startX = startX + b1.getWidth()+8;
                graphics.drawImage(b2, startX, startY, b2.getWidth(), b2.getHeight(), null);
                startX = 12;
                startY = 12 + b2.getHeight() + 8;
                for(int i = 2;i<count;i++){
                    BufferedImage b = image[i];
                    graphics.drawImage(b, startX, startY, b.getWidth(), b.getHeight(), null);
                    startX = startX + b.getWidth() + 8;
                    if(i == 4){
                        startY = startY + b.getHeight() + 8;
                        startX = 12;
                    }
                }
            }else if(count == 9){
                int startX = 12;
                int startY = 12;
                for(int i = 0;i<count;i++){
                    BufferedImage b = image[i];
                    graphics.drawImage(b, startX, startY, b.getWidth(), b.getHeight(), null);
                    startX = startX + b.getWidth() + 8;
                    if((i+1)%3 == 0){
                        startY = startY + b.getHeight() + 8;
                        startX = 12;
                    }
                }
            }
            graphics.dispose();
        } catch (Exception e) {
            LogUtil.error(CompoundPicUtilNew.class,"推送同比压缩图片出错{}",e);
        }

        return tag;
    }

    public static BufferedImage loadImageLocal(String imgName) {
        try {
            File file = new File(imgName);
            BufferedImage read = ImageIO.read(file);
            return read;
        } catch (IOException e) {
            LogUtil.error(CompoundPicUtilNew.class,"推送同比压缩图片出错{}",e);
        }
        return null;
    }
    public static BufferedImage loadImageUrl(String imgUrl) {
        try {
            InputStream imageStream = getStreamByUrl(imgUrl);
            BufferedImage read = ImageIO.read(imageStream);
            return read;
        } catch (IOException e) {
            LogUtil.error(CompoundPicUtilNew.class,"推送同比压缩图片出错{}",e);
        }
        return null;
    }
    /***
     * @title  获得网络图片的地址
     * @Description
     * @param: strUrl
     * @return: java.io.InputStream
     * @Author lhl
     * @Date 2023/6/19 9:52
     */
    public static InputStream getStreamByUrl(String strUrl){
        HttpURLConnection conn = null;
        try {
            URL url = new URL(strUrl);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(20 * 1000);
            final ByteArrayOutputStream output = new ByteArrayOutputStream();
            IOUtils.copy(conn.getInputStream(),output);
            return  new ByteArrayInputStream(output.toByteArray());
        } catch (Exception e) {
            LogUtil.info(CompoundPicUtilNew.class,e.getMessage());
        }finally {
            try{
                if (conn != null) {
                    conn.disconnect();
                }
            }catch (Exception e){
                LogUtil.info(CompoundPicUtilNew.class,e.getMessage());
            }
        }
        return null;
    }

    public static void writeImageLocal(String newImage, BufferedImage img) {
        if (newImage != null && img != null) {
            try {
                File outputfile = new File(newImage);
                ImageIO.write(img, "png", outputfile);
            } catch (IOException e) {
                LogUtil.error(CompoundPicUtilNew.class,"推送同比压缩图片出错{}",e);
            }
        }
    }

    /**
     *
     * @Title: handleLarge
     * @Description: 同比例压缩图片，使图片形成相同大小   
     * @param: @param image
     * @param: @return      
     * @return: BufferedImage[]
     * @throws
     * @author:石德斌
     * @date:2020年4月23日 上午10:36:11
     */
    public static BufferedImage[] handleLarge(Integer width,Integer height,BufferedImage[] image) {
        BufferedImage[] b = new BufferedImage[image.length];
        for (int i = 0; i < image.length; i++) {
            BufferedImage sourceImage = image[i];
            try {
                b[i] = CompoundPicUtilNew.zoom2(width, height, sourceImage);
            } catch (Exception e) {
                LogUtil.error(CompoundPicUtilNew.class,"推送同比压缩图片出错{}",e);
            }
        }
        return b;
    }

    public static void main(String[] args) {
//		BufferedImage b1 = loadImageLocal("C:\\Users\\Admin\\Documents\\WeChat Files\\a010662716\\FileStorage\\File\\2020-04\\头像\\");
//        try {
//            //用于合成的图片数量
//            int count = 3;
//            BufferedImage[] image =new BufferedImage[3];
//            image[0]=loadImageUrl("https://wx.qlogo.cn/mmhead/hNWCQ9bibbzETOsjpca26voBRU7HX6xLyKZI1hnI72BOGyD7HXIZZZw/0");
//            image[1]=loadImageUrl("https://wework.qpic.cn/wwpic/506478_nNRYk6YoRwKdobh_1686129955/0");
//            image[2]=loadImageUrl("http://wx.qlogo.cn/mmhead/hNWCQ9bibbzETOsjpca26voBRU7HX6xLyKZI1hnI72BOGyD7HXIZZZw/0");
//            BufferedImage bufferedImage = modifyImagetogeter(handleLarge(88, 88, image));
//            getImageStream(bufferedImage)
//            writeImageLocal("C:\\Users\\JSP\\Desktop\\桌面文件\\img\\new_gou.png", bufferedImage);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static BufferedImage zoom2(int width,int height,BufferedImage sourceImage) throws Exception {

        if( sourceImage == null ){
            return sourceImage;
        }
        // 计算x轴y轴缩放比例--如需等比例缩放，在调用之前确保參数width和height是等比例变化的
        double ratiox  = (new Integer(width)).doubleValue()/ sourceImage.getWidth();
        double ratioy  = (new Integer(height)).doubleValue()/ sourceImage.getHeight();
        AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratiox, ratioy), null);
        BufferedImage bufImg = op.filter(sourceImage, null);
        return bufImg;
    }

    public static InputStream getImageStream(BufferedImage bimage){
        InputStream is = null;
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ImageOutputStream imOut;
        try {
            imOut = ImageIO.createImageOutputStream(bs);
            ImageIO.write(bimage, "png",imOut);
            is= new ByteArrayInputStream(bs.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return is;
    }

}

