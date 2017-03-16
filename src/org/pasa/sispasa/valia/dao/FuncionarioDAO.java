
package org.pasa.sispasa.valia.dao;

/**
 *
 * @author Hudson Schumaker
 */
public interface FuncionarioDAO {
    
    Long getIdPessoa(Long idFuncionario);
    Long getIdEmpresa(Long idFuncionario);
    String getMatriculaSIP(Long idFuncionario);
}
