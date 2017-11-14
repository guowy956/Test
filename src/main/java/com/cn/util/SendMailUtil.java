package com.cn.util;

/**
 * Created by newtouch on 2017/11/6.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 邮件服务:发送邮件；
 */
@Service
public class SendMailUtil {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Autowired
    public JavaMailSender javaMailSender;

//    @Value("{mail.send.name}")
    public  String from;

    /**
     * 发送纯文本文件
     */
    public void sendMailForText(String to,String random , String subject){
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(to);
            message.setSubject(subject);
            StringBuilder builder = new StringBuilder();
            builder.append(" 亲爱的用户"+to+" 您好 ");
            builder.append(" 以下部分省略。。。。。。 ");
            builder.append(" 验证码为"+random+" ");
            message.setSubject(builder.toString());
            javaMailSender.send(message);
            logger.debug("邮件发送成功   --   ");
        }catch (Exception e){
            logger.error("邮件发送过程出现错误");
        }
    }

    /**
     * 发送HTML格式
     */
    public void sendMailForHtml(String to,String random , String subject){
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            StringBuilder builder = new StringBuilder();
            builder.append(" 亲爱的用户"+to+" 您好 <br><br>");
            builder.append(" 以下部分省略。。。。。。 <br><br>");
            builder.append(" 验证码为"+random+" <br><br>");
            message.setSubject(builder.toString());
            javaMailSender.send(message);
        }catch (Exception e){
            logger.error("邮件发送过程出现错误");
        }
    }


    /**
     * 附带附件的邮件
     */
    public void sendMailForFile(String to,String random , String subject, String filePath){
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(random,true);
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName,file);
        }catch (Exception e){
            logger.error("邮件发送过程出现错误");
        }
    }

    /**
     * 发送邮件：带有静态文件
     */
    public void sendMailForResource(String to,String random , String subject, String content, String rscPath, String rscId){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);
            FileSystemResource resource = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId,resource);
        }catch (Exception e){
            logger.error("邮件发送过程出现错误");
        }
    }
}
