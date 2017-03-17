package org.pasa.sispasa.valia.bean;

import org.pasa.sispasa.valia.config.MailConfig;
import org.pasa.sispasa.valia.dao.ParamertersDAOImpl;
import org.pasa.sispasa.valia.util.EntrantesValiaCommon;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ParametersBeanImpl implements ParametersBean {

    private final ParamertersDAOImpl paramertersDAO;

    public ParametersBeanImpl() {
        paramertersDAO = new ParamertersDAOImpl();
    }

    public String getValueByKey(String key) {
        return paramertersDAO.getValue(key);
    }

    public MailConfig getMailConfig() {
        MailConfig mailConfig = new MailConfig();
        mailConfig.setServer(paramertersDAO.getValue(EntrantesValiaCommon.P_MAIL_SERVER));
        mailConfig.setUser(paramertersDAO.getValue(EntrantesValiaCommon.P_MAIL_USER));
        mailConfig.setPassword(paramertersDAO.getValue(EntrantesValiaCommon.P_MAIL_PASSWORD));
        return mailConfig;
    }
}
