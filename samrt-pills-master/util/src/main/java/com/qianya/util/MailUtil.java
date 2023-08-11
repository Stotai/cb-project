package com.qianya.util;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONObject;
import com.qianya.entity.mongo.UtilConfigMoEntity;
import com.qianya.exception.CustomException;
import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class MailUtil {
    //配置表
    private static String CONFIG_TABLE="util_config";
    //邮件key
    private static String CONFIG_MAIL_KEY="config_mail_key";
    /****
     * @Title 发送短信
     * @Description
     * @param: mongoTemplate
     * @param: subject
     * @param: content
     * @return: boolean
     * @Author lhl
     * @Date 2023-05-27 17:02
     */
	public static boolean sendEmail(MongoTemplate mongoTemplate,String subject, String content) {
        UtilConfigMoEntity one = mongoTemplate.findOne(new Query(Criteria.where("config_key").is(CONFIG_MAIL_KEY)), UtilConfigMoEntity.class, CONFIG_TABLE);
        if (one==null){
            throw new CustomException("获取短信配置失败");
        }
        if (!one.getConfigValue().equals("1")){
            return true;
        }
        String[] toUser=one.getReceiveUser().replaceAll(" ","").split(",");
        String sendAccount = one.getSendAccount();
        List<String> accountList = Arrays.stream(sendAccount.split("&&")).filter(StringUtils::isNotBlank).collect(Collectors.toList());
        int index = RandomUtil.randomInt(0, accountList.size());
        String[] accountGroup = accountList.get(index).split("::");
        String accountStr=accountGroup[0];
        String password=accountGroup[1];
        boolean flag = true;
        try {
            JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
            javaMailSender.setHost("smtp.qq.com");
            javaMailSender.setUsername(accountStr);
            javaMailSender.setPassword(password);
            javaMailSender.setDefaultEncoding("UTF-8");
            javaMailSender.setProtocol("smtp");
            javaMailSender.setPort(Integer.parseInt("465"));

            Properties properties = new Properties();
            properties.setProperty("mail.smtp.auth", accountStr);
            properties.setProperty("mail.smtp.timeout", "5000");
            MailSSLSocketFactory sf = null;
            try {
                sf = new MailSSLSocketFactory();
                sf.setTrustAllHosts(true);
                properties.put("mail.smtp.ssl.enable", "true");
                properties.put("mail.smtp.ssl.socketFactory", sf);
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            };
            javaMailSender.setJavaMailProperties(properties);

            MimeMessage mailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true);
            messageHelper.setTo(toUser);
            messageHelper.setFrom(accountStr);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, true);
            javaMailSender.send(mailMessage);

        } catch (Exception e) {
            LogUtil.error(MailUtil.class,"发送邮件失败!", e);
            flag = false;
        }
        return flag;
    }
}
