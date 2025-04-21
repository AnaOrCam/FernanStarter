package utilidades;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class FuncionesCorreos {
    /**
     * Funcion para el envio del correo.
     * @author davidrn06
     * @param destinatario nombre del destinatario que recibe la autentificacion en dos factores.
     * @param asunto asunto correspondiente al correo enviado.
     * @param cuerpo cuerpo del correo enviado.
     * @return no devuelve ningun valor.
     */
    public static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        String remitente = "davidrosanebrera@gmail.com";
        String clave = "ldes vjpg axbu vhbe";

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

    public static void enviarArchivosConGMail(String destinatario, String asunto, String cuerpo, String rutaArchivo) {
        String remitente = "davidrosanebrera@gmail.com";
        String clave = "ldes vjpg axbu vhbe";

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
            MimeBodyPart adjuntoParte = new MimeBodyPart();
            adjuntoParte.attachFile(rutaArchivo);
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
