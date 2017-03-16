
package org.pasa.sispasa.valia.model;

import java.util.Date;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class Associado {
    
    private Date dataFilacaoPasa;
    private Date dataDesligamentoPasa;
    private String identificadorValia;
   
    public Associado(){
    }

    public Date getDataFilacaoPasa() {
        return dataFilacaoPasa;
    }

    public void setDataFilacaoPasa(Date dataFilacaoPasa) {
        this.dataFilacaoPasa = dataFilacaoPasa;
    }

    public Date getDataDesligamentoPasa() {
        return dataDesligamentoPasa;
    }

    public void setDataDesligamentoPasa(Date dataDesligamentoPasa) {
        this.dataDesligamentoPasa = dataDesligamentoPasa;
    }

    public String getIdentificadorValia() {
        return identificadorValia;
    }

    public void setIdentificadorValia(String identificadorValia) {
        this.identificadorValia = identificadorValia;
    }
}
