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
public class FuncionarioDAOImpl implements FuncionarioDAO {

    private final static Logger LOGGER = Logger.getLogger(FuncionarioDAOImpl.class);

    public FuncionarioDAOImpl() {
    }

    @Override
    public Long getIdPessoa(Long idFuncionario) {
        String sql = "SELECT funcionario.id_pessoa FROM funcionario WHERE funcionario.id_funcionario = " + idFuncionario;
        long idPessoa = 0L;
        Connection theConn = null;
        try {
            theConn = ConexaoSQLServer.getConexao();
            ResultSet rs;
            Statement stmt;
            stmt = theConn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                idPessoa = rs.getLong("ID_PESSOA");
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
        return idPessoa;
    }

    @Override
    public Long getIdEmpresa(Long idFuncionario) {
        String sql = "SELECT funcionario.id_empresa FROM funcionario WHERE funcionario.id_funcionario = " + idFuncionario;
        long idEmpresa = 0L;
        Connection theConn = null;
        try {
            theConn = ConexaoSQLServer.getConexao();
            ResultSet rs;
            Statement stmt;
            stmt = theConn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                idEmpresa = rs.getLong("ID_EMPRESA");
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
        return idEmpresa;
    }
    
    @Override
    public String getMatriculaSIP(Long idFuncionario){
        String sql = "SELECT funcionario.matr_origem FROM funcionario WHERE funcionario.id_funcionario = " + idFuncionario;
        String matriculaSIP = "";
        Connection theConn = null;
        try {
            theConn = ConexaoSQLServer.getConexao();
            ResultSet rs;
            Statement stmt;
            stmt = theConn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                matriculaSIP = rs.getString("MATR_ORIGEM");
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
        return matriculaSIP;
    }
}
