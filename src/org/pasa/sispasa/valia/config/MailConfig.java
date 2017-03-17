package org.pasa.sispasa.valia.config;

import java.io.Serializable;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class MailConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String user;
    private String password;
    private String server;

    public MailConfig() {
    }

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
//        try {
//            return Criptografia.decriptografarBase64(senha);
//        } catch (EncoderException ex) {
//            Logger.getLogger(MailConfig.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
    }

    public void setPassword(String password) {
        this.password = password;
//        try {
//            this.senha = Criptografia.criptografarBase64(senha);
//        } catch (EncoderException ex) {
//            Logger.getLogger(MailConfig.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
