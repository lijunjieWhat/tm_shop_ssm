package com.lijunjie.tmall.utils;

import java.util.Date;

import org.apache.commons.mail.SimpleEmail;



public class CommonsEmail {
	public static boolean sendTextMail(String strMail, String strTitle, String strText) throws Exception {
		boolean bret = true;
		SimpleEmail mail = new SimpleEmail();
		// 设置邮箱服务器信息
		mail.setSslSmtpPort("465");
		mail.setHostName("smtp.qq.com");
		// 设置密码验证器
		mail.setAuthentication("3183823136@qq.com", "kzqvqkhjbslydgdf");
		// 设置邮件发送者
		mail.setFrom("3183823136@qq.com");
		// 设置邮件接收者
		mail.addTo(strMail);
		// 设置邮件编码
		mail.setCharset("UTF-8");
		// 设置邮件主题
		mail.setSubject(strTitle);
		// 设置邮件内容
		mail.setMsg(strText);
		// 设置邮件发送时间
		mail.setSentDate(new Date());
		// 发送邮件
		mail.send();
		bret = true;
		return bret;
	}

}

