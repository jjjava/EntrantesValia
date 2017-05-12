package org.pasa.sispasa.valia.config;

import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;
import org.pasa.sispasa.valia.util.DateUtil;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class SendEmail {

    private final List<String> lista;
    private final String subject;
    private final String message;

    private static final Logger LOGGER = Logger.getLogger(SendEmail.class);

    public SendEmail(List<String> lista, String subject, String message) {
        this.lista = lista;
        this.subject = subject;
        this.message = message;
    }

    public void enviar() {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", Parameters.getInstance().getMailServer());
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            Session s = Session.getDefaultInstance(props, new Authentication(Parameters.getInstance().getMailUser(), 
                    Parameters.getInstance().getMailPassword()));
            
            MimeMessage email = new MimeMessage(s);
            InternetAddress de = new InternetAddress(Parameters.getInstance().getMailUser());
            email.setFrom(de);
            for (String d : lista) {
                InternetAddress para = new InternetAddress(d);
                email.addRecipient(Message.RecipientType.TO, para);
            }
            email.setSubject(subject + DateUtil.obterDataAtual());
            email.setText(message);
            Transport.send(email);
        } catch (AddressException ex) {
            System.err.println(ex);
            LOGGER.error(ex);
        } catch (MessagingException ex) {
            System.err.println(ex);
            LOGGER.error(ex);
        }
    }
}
