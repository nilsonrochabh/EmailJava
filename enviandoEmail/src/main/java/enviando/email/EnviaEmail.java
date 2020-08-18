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

public class EnviaEmail {
	private String userName = "fiaelad@gmail.com";
	private String password = "2020elad";
	
	private String listaDestinatarios = "";
	private String nomeRemetente="";
	private String assuntoEmail="";
	private String textoEmail="";
	
	//construtor
	public EnviaEmail(String listaDestinatario, String nomeRemetente, String assuntoEmail, String textoEmail) {
		this.listaDestinatarios = listaDestinatario;
		this.nomeRemetente = nomeRemetente;
		this.assuntoEmail=assuntoEmail;
		this.textoEmail= textoEmail;
	}

	
	public void enviarEmail() {
		try {
			Properties properties = new Properties();
			properties.put("mail.smtp.ssl.trust", "*");// autenticando ssl 
			properties.put("mail.smtp.auth", true);// autorização
			properties.put("mail.smtp.starttls", true);// autenticacao
			properties.put("mail.smtp.host", "smtp.gmail.com");// servidor do google
			properties.put("mail.smtp.port", "465");// porta servidor
			properties.put("mail.smtp.socketFactory.port", "465");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {

					return new PasswordAuthentication(userName, password);
				}
			});
				Address[] toUser = InternetAddress.parse(listaDestinatarios);
				Message  message = new MimeMessage(session);
				message.setFrom(new InternetAddress(userName,nomeRemetente));//quem esta enviando mais quem esta enviando
				message.setRecipients(Message.RecipientType.TO, toUser);//email destino
				message.setSubject(assuntoEmail);//Assunto do email
				message.setText(textoEmail);//Corpo do email
				Transport.send(message);//enviando o email

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
