package org.pasa.sispasa.valia.config;

import org.pasa.sispasa.valia.bean.ParametersBeanImpl;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class Parameters {

    private static Parameters instance = null;
    private final MailConfig mailConfig;

    private Parameters() {
        mailConfig = new ParametersBeanImpl().getMailConfig();
    }

    public static synchronized Parameters getInstance() {
        if (null == instance) {
            instance = new Parameters();
        }
        return instance;
    }
    
    public String getMailServer(){
        return mailConfig.getServer();
    }
    
    public String getMailUser(){
        return mailConfig.getUser();
    }
    
    public String getMailPassword(){
        return mailConfig.getPassword();
    }
}
