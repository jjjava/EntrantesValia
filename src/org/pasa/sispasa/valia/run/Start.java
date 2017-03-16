package org.pasa.sispasa.valia.run;

import org.pasa.sispasa.valia.connection.ConexaoSQLServer;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class Start {
    
    public static void main(String[] args) {
        ConexaoSQLServer.getConexao();
    }
}
