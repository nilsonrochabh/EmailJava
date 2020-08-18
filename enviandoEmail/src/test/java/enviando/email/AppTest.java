package enviando.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.handlers.message_rfc822;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@org.junit.Test
	public void testeEmail() {
	EnviaEmail enviaemail = new EnviaEmail("nilson.f.rocha@gmail.com", 
												"fiaelad@gmail.com", 
												"Testeando envio", 
												"TESte de envio de email via java");
	enviaemail.enviarEmail();




	}
}
