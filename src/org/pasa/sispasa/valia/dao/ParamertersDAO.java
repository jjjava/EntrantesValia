
package org.pasa.sispasa.valia.dao;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface ParamertersDAO {
    
    String getMailServer(String key);
    String getMailUser(String key);
    String getMailPassword(String key);    
    
}
