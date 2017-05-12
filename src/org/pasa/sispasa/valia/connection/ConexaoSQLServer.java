package org.pasa.sispasa.valia.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.pasa.sispasa.valia.util.JDBCUtils;

/**
 *
 * @author Hudson Schumaker
 */
public class ConexaoSQLServer {

    private static final Logger LOGGER = Logger.getLogger(ConexaoSQLServer.class);
    
    public ConexaoSQLServer(){
    }
    
    public static Connection getConexao() {
        Connection conn = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
            LOGGER.error(ex);
        }
        try {
            conn = DriverManager.getConnection(JDBCUtils.getDbConnectionString(),
                    JDBCUtils.getDbUser(), JDBCUtils.getDbPassword());
        } catch (SQLException ex) {
            System.err.println(ex);
            LOGGER.error(ex);
        }
        return conn;
    }
}
