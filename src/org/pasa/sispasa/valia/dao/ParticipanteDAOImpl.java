
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
 * @verison 1.0.0
 */

public class ParticipanteDAOImpl implements ParticipanteDAO{
    
    private final static Logger LOGGER = Logger.getLogger(FuncionarioDAOImpl.class);
    
    public ParticipanteDAOImpl(){
    }
    
    @Override
    public String getCpf(Long idParticipante){
        String sql = "SELECT participante.cpf FROM participante WHERE participante.id_participante = " + idParticipante;
        String cpf = "";
        Connection theConn = null;
        try {
            theConn = ConexaoSQLServer.getConexao();
            ResultSet rs;
            Statement stmt;
            stmt = theConn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                cpf = rs.getString("CPF");
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
        return cpf;
    }
}
