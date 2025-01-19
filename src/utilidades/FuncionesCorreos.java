package utilidades;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class FuncionesCorreos {
    public static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        String remitente = "davidrosanebrera@gmail.com";
        String clave = "cnnu lpxh vvva enhn";

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setContent(cuerpo, "text/html; charset=utf-8");
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (Exception me) {
            me.printStackTrace();
        }
    }
    /**
     * Menu para generar el codigo de autentificacion.
     * @author davidrn06
     * @return Devuelve el codigo de autentificacion generado para el acceso a los perfiles.
     */
    public static int generarAutentificacion(){
        double autentificacionInicial =Math.random();
        int  autentificacion =(int) (autentificacionInicial*8999+1000);
        return autentificacion;
    }
}
