
package org.pasa.sispasa.valia.bean;

import org.pasa.sispasa.valia.config.MailConfig;
import org.pasa.sispasa.valia.dao.ParamertersDAOImpl;
import org.pasa.sispasa.valia.util.EntrantesValiaCommon;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ParametersBeanImpl implements ParametersBean{
    
    private final ParamertersDAOImpl paramertersDAO;
    
    public ParametersBeanImpl(){
        paramertersDAO = new ParamertersDAOImpl();
    }
    
    public MailConfig getMailConfig(){
        MailConfig mailConfig = new MailConfig();
        mailConfig.setServer(paramertersDAO.getMailServer(EntrantesValiaCommon.P_MAIL_SERVER));
        mailConfig.setUser(paramertersDAO.getMailUser(EntrantesValiaCommon.P_MAIL_USER));
        mailConfig.setPassword(paramertersDAO.getMailUser(EntrantesValiaCommon.P_MAIL_PASSWORD));
        return mailConfig;
    }
}
