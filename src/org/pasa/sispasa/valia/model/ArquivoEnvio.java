package org.pasa.sispasa.valia.model;

import java.util.Date;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ArquivoEnvio {
    
    private String empresa;
    private String matricula;
    private String cpf;
    private char tipoValia;
    private Date dtFiliacaoPasa;
    private Date dtDesligamentoPasa;
    private String identificadorValia;
    
    public ArquivoEnvio(){   
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public char getTipoValia() {
        return tipoValia;
    }

    public void setTipoValia(char tipoValia) {
        this.tipoValia = tipoValia;
    }

    public Date getDtFiliacaoPasa() {
        return dtFiliacaoPasa;
    }

    public void setDtFiliacaoPasa(Date dtFiliacaoPasa) {
        this.dtFiliacaoPasa = dtFiliacaoPasa;
    }

    public Date getDtDesligamentoPasa() {
        return dtDesligamentoPasa;
    }

    public void setDtDesligamentoPasa(Date dtDesligamentoPasa) {
        this.dtDesligamentoPasa = dtDesligamentoPasa;
    }

    public String getIdentificadorValia() {
        return identificadorValia;
    }

    public void setIdentificadorValia(String identificadorValia) {
        this.identificadorValia = identificadorValia;
    }
}
