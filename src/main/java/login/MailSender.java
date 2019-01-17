package login;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component("javaMailSender")
public class MailSender {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public void sendMail(JavaMailSender javaMailSender, String from, String to, String subject, String body) {

		SimpleMailMessage mail = new SimpleMailMessage();

		mail.setFrom(from);
		mail.setTo(to);
		mail.setSubject(subject);
		mail.setText(body);

		logger.info("Sending...");

		javaMailSender.send(mail);

		logger.info("Done!");
	}

	/**
	 * @param javaMailSender
	 * @param mimeMessage
	 */
	public void sendMail(JavaMailSender javaMailSender, MimeMessage mimeMessage) {

		logger.info("SEnding..........!");
		try {
			ExecutorService executor = Executors.newFixedThreadPool(5);
			executor.submit(new Runnable() {
				@Override
				public void run() {
					javaMailSender.send(mimeMessage);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Done!");

	}
}