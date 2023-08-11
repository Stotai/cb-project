package com.qianya.util;

import ch.qos.logback.core.util.CloseUtil;
import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.util.IdUtil;
import com.qianya.common.JsonResultT;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;

import java.io.*;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtil {
    /**
     * @desc 上传图片获得相对路径
     * @author lhl
     * @date 2020-07-13 08:41
     * @return
     */
    public static String base64UpLoad(String base64Data,String type){
        String filePath=SystemConfig.filePath();
        String path=type+File.separator+"img";
        try{
            String dataPrix = "";
            String data = "";
            if(base64Data == null || "".equals(base64Data)){
                throw new Exception("上传失败，上传图片数据为空");
            }else{
                String [] d = base64Data.split("base64,");
                if(d != null && d.length == 2){
                    dataPrix = d[0];
                    data = d[1];
                }else{
                    throw new Exception("上传失败，数据不合法");
                }
            }
            String suffix = "";
            if("data:image/jpeg;".equalsIgnoreCase(dataPrix)){//data:image/jpeg;base64,base64编码的jpeg图片数据
                suffix = ".jpg";
            } else if("data:image/x-icon;".equalsIgnoreCase(dataPrix)){//data:image/x-icon;base64,base64编码的icon图片数据
                suffix = ".ico";
            } else if("data:image/gif;".equalsIgnoreCase(dataPrix)){//data:image/gif;base64,base64编码的gif图片数据
                suffix = ".gif";
            } else if("data:image/png;".equalsIgnoreCase(dataPrix)){//data:image/png;base64,base64编码的png图片数据
                suffix = ".png";
            }else{
                suffix = ".jpg";
            }
            String tempFileName = IdUtil.simpleUUID() + suffix;

            //因为BASE64Decoder的jar问题，此处使用spring框架提供的工具包
            byte[] bs = Base64Utils.decodeFromString(data);
            try{
                //使用apache提供的工具类操作流
                FileUtils.writeByteArrayToFile(new File(filePath+path, tempFileName), bs);
            }catch(Exception ee){
                throw new Exception("上传失败，写入文件失败，"+ee.getMessage());
            }
            return "\\statics"+File.separator+path+File.separator+tempFileName;
        }catch (Exception e) {
            return "error";
        }
    }
    public static void saveFile(String fileContent, String dir, String fileName) throws Exception {
        Path target = Paths.get(dir);
        if (Files.notExists(target)) {
            Files.createDirectories(target);
        }
        Path file = target.resolve(fileName);
        if (Files.notExists(file)) {
            Files.createFile(file);
        }
        byte[] str = fileContent.getBytes(StandardCharsets.UTF_8);
        Files.write(file, str);
    }

    public static void copyDir(String sourcePath, String newPath) throws IOException {
        File file = new File(sourcePath);
        String[] filePath = file.list();

        if (!(new File(newPath)).exists()) {
            (new File(newPath)).mkdir();
        }

        for (int i = 0; i < filePath.length; i++) {
            if ((new File(sourcePath + file.separator + filePath[i])).isDirectory()) {
                copyDir(sourcePath + file.separator + filePath[i], newPath + file.separator + filePath[i]);
            }

            if (new File(sourcePath + file.separator + filePath[i]).isFile()) {
                copyFile(sourcePath + file.separator + filePath[i], newPath + file.separator + filePath[i]);
            }

        }
    }

	public static Object downloadFile(String path) throws IOException {
		File f = new File(path);
		if(!f.exists()){
			return JsonResultT.error("文件不存在");
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("filename", f.getName());
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<>(org.aspectj.util.FileUtil.readAsByteArray(f), headers,
				HttpStatus.OK);
	}
    public static void copyFile(String oldPath, String newPath) throws IOException {
        File oldFile = new File(oldPath);
        File file = new File(newPath);
        if (!new File(newPath.substring(0, newPath.lastIndexOf("\\"))).exists()) {
            new File(newPath.substring(0, newPath.lastIndexOf("\\"))).mkdirs();
        }
        FileInputStream in = new FileInputStream(oldFile);
        FileOutputStream out = new FileOutputStream(file);
        ;

        byte[] buffer = new byte[2097152];
        int readByte = 0;
        while ((readByte = in.read(buffer)) != -1) {
            out.write(buffer, 0, readByte);
        }

        in.close();
        out.close();
    }

    /**
     * @param size
     * @return
     * @Desc 转换文件大小
     * @author lhl
     * @Date 2019年5月9日 下午2:30:38
     */
    public static String getPrintSize(long size) {
        // 如果字节数少于1024，则直接以B为单位，否则先除于1024，后3位因太少无意义
        double value = (double) size;
        if (value < 1024) {
            return String.valueOf(value) + "B";
        } else {
            value = new BigDecimal(value / 1024).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
        }
        // 如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位
        // 因为还没有到达要使用另一个单位的时候
        // 接下去以此类推
        if (value < 1024) {
            return String.valueOf(value) + "KB";
        } else {
            value = new BigDecimal(value / 1024).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
        }
        if (value < 1024) {
            return String.valueOf(value) + "MB";
        } else {
            // 否则如果要以GB为单位的，先除于1024再作同样的处理
            value = new BigDecimal(value / 1024).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
            return String.valueOf(value) + "GB";
        }
    }
    /**
     * description  获取sql文件列表
     * date         202011/09 上午 10:42
     * @author      lhl
     */
    public static List<FileManage> getSqlFiles(String path) {
    	List<FileManage> list = new ArrayList<>();
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                // 如果还是文件夹 递归获取里面的文件 文件夹
            	String parentPath = path.replaceAll(Matcher.quoteReplacement(SystemConfig.filePath()), Matcher.quoteReplacement(File.separator));
            	String filePath = files[i].getPath().replaceAll(Matcher.quoteReplacement(SystemConfig.filePath()), Matcher.quoteReplacement(File.separator));
                if (files[i].isDirectory()) {
                		list.addAll(getSqlFiles(files[i].getPath()));
                } else {

                		list.add(new FileManage(files[i].getName(), filePath, parentPath, FileUtil.getPrintSize(files[i].length()), getSecondChange(files[i].lastModified()), false
                				, FileTypeUtil.getType(files[i])));
                   // new MimetypesFileTypeMap().getContentType(files[i])
                }
            }
        }
        return list;
    }
    /**
     * 读取txt文件的内容
     *
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
    public static String txt2String(File file) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GB2312"));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
    /**
     * @desc long转换为时间格式
     * @author lhl
     * @date 2020-07-14 14:50
     * @return
    */
    public static String getSecondChange(Long millionSeconds) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(millionSeconds);
        Date date = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
    /**
     * @desc 根据路径读文件
     * @author lhl
     * @date 2020-07-14 14:50
     * @return
     */
    public static String read(String path) {
        FileInputStream fin = null;
        StringBuilder sb = new StringBuilder();
        try {
            fin = new FileInputStream(new File(path));
            FileChannel channel = fin.getChannel();
            int capacity = 1024;// 字节
            ByteBuffer bf = ByteBuffer.allocate(capacity);
            int count = channel.read(bf);
            while (count != -1) {
                bf.flip();
                CharBuffer charBuffer = CharBuffer.allocate(capacity);
                Charset charset = Charset.forName("utf8");
                CharsetDecoder decoder = charset.newDecoder();
                decoder.decode(bf, charBuffer, true);
                charBuffer.flip();
                while (charBuffer.hasRemaining()) {
                    sb.append(charBuffer.get());
                }
                bf.clear();
                count = channel.read(bf);
            }
            channel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    /**
     * @desc 根据路径写入文件内容
     * @author lhl
     * @date 2020-07-14 14:50
     * @return
     */
    public static void write( String path, String value) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(path));
            FileChannel channel = fos.getChannel();
            ByteBuffer src = Charset.forName("utf8").encode(value);
            int length = 0;
            while ((length = channel.write(src)) != 0) {
                System.out.println("写入长度:" + length);
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }
    /**
     * @desc 根据路径获得树结构
     * @author lhl
     * @date 2020-07-14 14:50
     * @return
     */
    public static List<FileManage> getFiles(String path, boolean isTree) {
        List<FileManage> list = new ArrayList<>();
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                // 如果还是文件夹 递归获取里面的文件 文件夹
                String parentPath = path.replaceAll(Matcher.quoteReplacement(SystemConfig.filePath()), Matcher.quoteReplacement(File.separator));
                String filePath = files[i].getPath().replaceAll(Matcher.quoteReplacement(SystemConfig.filePath()), Matcher.quoteReplacement(File.separator));
                if (files[i].isDirectory()) {
                    if (isTree) {
                        list.add(new FileManage(files[i].getName(), filePath, parentPath, null, null, true, null));
                        list.addAll(getFiles(files[i].getPath(), isTree));
                    } else {
                        list.add(new FileManage(files[i].getName(), filePath, parentPath, FileUtil.getPrintSize(files[i].length()), getSecondChange(files[i].lastModified()), true, null));
                    }
                } else {
                    if (!isTree) {
                        list.add(new FileManage(files[i].getName(), filePath, parentPath, FileUtil.getPrintSize(files[i].length()), getSecondChange(files[i].lastModified()), false
                                , FileTypeUtil.getType(files[i])));
                    }
                }
            }
        }
        return list;
    }
    /**
     * @desc 根据路径删除文件
     * @author lhl
     * @date 2020-07-14 14:50
     * @return
     */
    public static void delete(String path) {
        File f = new File(path);
        if (f.exists()) {
            f.delete();
        }
    }

    public static File compressFile(List<File> files) {
        FileInputStream fileInputStream = null;
        ZipEntry zipEntry;
        ZipOutputStream zos;
        OutputStream out;
        File tmp = null;
        try {
            tmp = File.createTempFile(String.valueOf(System.currentTimeMillis()), ".zip");
            tmp.deleteOnExit();
            out = new FileOutputStream(tmp);
            zos = new ZipOutputStream(out);
            int count = 0;
            for (File file : files) {
                if (file.exists()) {
                    count++;
                    fileInputStream = new FileInputStream(file);
                    zipEntry = new ZipEntry(file.getName());
                    zos.putNextEntry(zipEntry);
                }
            }
            if (count != files.size()) {
                return null;
            }
            int len;
            byte[] buffer = new byte[1024];
            while ((len = fileInputStream.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            CloseUtil.closeQuietly(fileInputStream);
            CloseUtil.closeQuietly(zos);
            CloseUtil.closeQuietly(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmp;
    }
}
