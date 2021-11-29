package online.restadvidor.restadvidor.utils;

import org.apache.commons.mail.*;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class EmailConfirmation {
    private static final String HOSTNAME= "smtp.gmail.com";
    private static final int PORT = 465;
    private static final String EMAIL ="proyectokodigo@gmail.com";
    private static final String PASS ="Kodigo2021!";

    
    public static String makeHash(String email)
            throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        String input =  getSeed(email);
        System.out.println("Input sin cifrar: " +input);
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.reset();
        byte[] buffer = input.getBytes("UTF-8");
        md.update(buffer);
        byte[] digest = md.digest();

        String hexStr = "";
        for (int i = 0; i < digest.length; i++) {
            hexStr +=  Integer.toString( ( digest[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return hexStr;
    }

        public static String sendConfirmationLink(String emailToSend) {
            String infoToSend= "";
            try {
                infoToSend = makeHash(emailToSend);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            //AQUI YA VA GENERADO EL HASH COMPLETO
            String url = "http://localhost:8890/email/link?confirm=" + infoToSend;
            //String url = "http://34.125.6.179/email/link/?confirm=" + infoToSend;

            HtmlEmail he = new HtmlEmail();
            he.setHostName(HOSTNAME);
            he.setSmtpPort(PORT);
            he.setAuthentication(EMAIL, PASS);
            he.setSSLOnConnect(true);

            StringBuffer msg = new StringBuffer();
            msg.append("<html lang=\"en\">"
            		+ ""
            		+ "<style>"
            		+ "    .header{"
            		+ "        height: 90px;"
            		+ "        font-size: 2em;"
            		+ "        font-weight: bold;"
            		+ "        background-color: steelblue;"
            		+ "        color: white;"
            		+ "        text-align: center;"
            		+ "        padding-top: 10px;"
            		+ "        padding-bottom: 20px;"
            		+ "    }"
            		+ "    .content{"
            		+ "        background-color: rgba(188, 234, 255, 0.253);"
            		+ "        padding-top: 20px;"
            		+ "        padding-bottom: 20px;"
            		+ "    }"
            		+ "    .heading{"
            		+ "        font-size: 1.5em;"
            		+ "    }"
            		+ "    .negrita{"
            		+ "        font-weight: bold;"
            		+ "    }"
            		+ "    "
            		+ "</style>"
            		+ "<body>"
            		+ "    <div class=\"container\">"
            		+ "        <div class=\"header w-100 bg-primary\">"
            		+ "            <p class=\"text-white p-4 mt-2\">Restaurantes App</p>"
            		+ "        </div>"
            		+ "        <div class=\"content\">"
            		+ "            <h4 class=\"heading\">You are almost done!</h4>"
            		+ "            <p>Thanks for signing up to Restaurantes App</p>"
            		+ "            <hr>");
            msg.append("<p class='negrita'><a href='").append(url).append("'>").append("Confirm Your Email Address").append("</a></p>");
            msg.append("<p>Or copy and paste the following link into your browser:</p>");
            msg.append("<p>").append(url).append("</p>");
            msg.append("<p>If you ever have any questions, please don't hesitate to contact our team at team@restapdivsor.com</p>"
            		+ "            <p>Thanks,</p>"
            		+ "            <p>The Restaurantes App Team</p>"
            		+ "        </div>"
            		+ "    </div>"
            		+ "</body>"
            		+ "</html>");
            
            try {
                he.setHtmlMsg(msg.toString());
                he.setFrom(EMAIL);
                he.setSubject("Confirmation Link - Restaurantes App");
                he.addTo(emailToSend);
                he.send();
                System.out.println("Link successfully sent to " + emailToSend);
            } catch (EmailException ex) {
                ex.getMessage();
            }
            return infoToSend;
        }

    private static String getSeed(String email){
        Date dateSeed = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateToStr = dateFormat.format(dateSeed);
        return dateToStr + email;
    }

}
