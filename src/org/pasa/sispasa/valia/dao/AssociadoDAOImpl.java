
package org.pasa.sispasa.valia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;
import org.pasa.sispasa.valia.connection.ConexaoSQLServer;
import org.pasa.sispasa.valia.model.Associado;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class AssociadoDAOImpl implements AssociadoDAO{    
    
    private static final Logger LOGGER = Logger.getLogger(AssociadoDAOImpl.class);
    
    public AssociadoDAOImpl(){
    }
    
    @Override
    public Associado obter(Long idParticipante){
        Associado associado = new Associado();
        String sql = "SELECT associado.dt_associacao, associado.matr_valia_participante FROM participante WHERE participante.id_participante = " + idParticipante;
        Connection theConn = null;
        try {
            theConn = ConexaoSQLServer.getConexao();
            ResultSet rs;
            Statement stmt;
            stmt = theConn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                 associado.setDataFilacaoPasa(rs.getDate("DT_ASSOCIACAO"));
                 associado.setIdentificadorValia(rs.getString("MATR_VALIA_PARTICIPANTE"));
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
        return associado; 
    }
}
