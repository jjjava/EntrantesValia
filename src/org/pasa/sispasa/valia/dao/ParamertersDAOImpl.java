package org.pasa.sispasa.valia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;
import org.pasa.sispasa.valia.connection.ConexaoSQLServer;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ParamertersDAOImpl implements ParamertersDAO {

    private static final Logger LOGGER = Logger.getLogger(ParamertersDAOImpl.class);

    public ParamertersDAOImpl() {
    }

    @Override
    public String getValue(String key) {
        String sql = "SELECT * FROM parametros WHERE parametros.chave = '" + key + "'";
        String value = "";
        Connection theConn = null;
        try {
            theConn = ConexaoSQLServer.getConexao();
            ResultSet rs;
            Statement stmt;
            stmt = theConn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                value = rs.getString("VALOR");
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println(ex);
            LOGGER.error(ex);
        } finally {
            try {
                if (theConn != null) {
                    theConn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
                LOGGER.error(ex);
            }
        }
        return value;
    }
}
