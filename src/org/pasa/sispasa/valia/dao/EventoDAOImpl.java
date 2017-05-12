package org.pasa.sispasa.valia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.pasa.sispasa.valia.connection.ConexaoSQLServer;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class EventoDAOImpl implements EventoDAO {

    private static final Logger LOGGER = Logger.getLogger(EventoDAOImpl.class);

    public EventoDAOImpl() {
    }

    @Override
    public List<Long> getNovosEntrantes() {
        String sql = "XXXXX XXXXXXX XXXXXX XXXXXX XXXXXX";
        List<Long> lista = new ArrayList<>();
        Connection theConn = null;
        try {
            theConn = ConexaoSQLServer.getConexao();
            ResultSet rs;
            Statement stmt;
            stmt = theConn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                lista.add(rs.getLong("ID_PARTICIPANTE"));
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
        return lista;
    }
}
