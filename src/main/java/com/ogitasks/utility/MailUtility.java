package com.ogitasks.utility;

import java.io.StringWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component("MailUtility")
public class MailUtility {

	@Value("${spring.mail.username}")
	String username;

//	@Autowired
//	ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@Autowired
	JavaMailSender javaMailSender;

	@Autowired
	VelocityEngine velocityEngine;

	public String getMailText(final Map<String, Object> params, final String templateName) {
		Template template = velocityEngine.getTemplate(templateName);
		VelocityContext context = new VelocityContext();
		Set<Entry<String, Object>> entries = params.entrySet();
		for (Entry<String, Object> entry : entries) {
			context.put(entry.getKey(), entry.getValue());
		}
		StringWriter writer = new StringWriter();
		template.merge(context, writer);
		return writer.toString();
	}

	public void send(final String email, final String subject, String templateName, Map<String, Object> params) {
			MimeMessage mime = javaMailSender.createMimeMessage();
			MimeMessageHelper helper;
			try {
				helper = new MimeMessageHelper(mime, true);
				helper.setFrom("No-Reply<" + username + ">");
				helper.setTo(email);
				helper.setSubject(subject);
				helper.setText(getMailText(params, templateName), true);
				javaMailSender.send(mime);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
	}
}
