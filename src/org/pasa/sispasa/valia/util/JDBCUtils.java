package org.pasa.sispasa.valia.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author Andre Gomes
 *
 */
public abstract class JDBCUtils {

    private JDBCUtils() {
    }

    private final static Logger LOGGER = Logger.getLogger(JDBCUtils.class);

    private final static String DB_CONNECTION_STRING = "DB_CONNECTION_STRING";
    private final static String DB_USER = "DB_USER";
    private final static String DB_PASSWORD = "DB_PASSWORD";
    private final static String CONFIG_PROPERTIES = "configuracao.properties";

    public static String getDbConnectionString() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(CONFIG_PROPERTIES));
            return prop.getProperty(DB_CONNECTION_STRING);
        } catch (IOException ex) {
            LOGGER.error(ex);
        }
        return null;
    }

    public static String getDbUser() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(CONFIG_PROPERTIES));
            return prop.getProperty(DB_USER);
        } catch (IOException ex) {
            LOGGER.error(ex);
        }
        return null;
    }

    public static String getDbPassword() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(CONFIG_PROPERTIES));
            return prop.getProperty(DB_PASSWORD);
        } catch (IOException ex) {
            LOGGER.error(ex);
        }
        return null;
    }
}
