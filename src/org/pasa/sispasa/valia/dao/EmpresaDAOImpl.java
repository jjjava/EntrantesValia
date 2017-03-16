
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
 */
public class EmpresaDAOImpl implements EmpresaDAO{
    
    private final static Logger LOGGER = Logger.getLogger(EmpresaDAOImpl.class);
    
    public EmpresaDAOImpl(){
    }
    
    @Override
    public String getCdEmpresaVale(Long idEmpresa){
        String sql = "SELECT empresa.cd_empresa_vale FROM empresa WHERE empresa.id_empresa = " + idEmpresa;
        String cdEmpresaVale = "";
        Connection theConn = null;
        try {
            theConn = ConexaoSQLServer.getConexao();
            ResultSet rs;
            Statement stmt;
            stmt = theConn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                cdEmpresaVale = rs.getString("CD_EMPRESA_VALE");
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
        return cdEmpresaVale;
    }
}
