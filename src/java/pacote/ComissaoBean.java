package pacote;

/**
 *
 * @author wendhio
 */
public class ComissaoBean {
    private String vendedor;
    private double vendas, comissao;

    public ComissaoBean() {
      
    }
    
    public void setVendedor( String vendedor){
        this.vendedor = vendedor;
    }
    
    public String getVendedor(){
        return this.vendedor;
    }
    
    public void setVendas(double vendas){
        this.vendas = vendas;
    }
    
    public double getVendas(){
        return this.vendas;
    }
    
    public void setComissao( double comissao){
        this.comissao = comissao;
    }
    
    public double getComissao(){
        return this.comissao;
    }
    
    
    public double calculaComissao(){
        if( vendas >= 3000 && vendas <= 5000)
            comissao = 100;
        else if(vendas > 5000 && vendas <= 10000)
            comissao = vendas*0.04;
        else if( vendas > 10000 && vendas <= 15000)
            comissao = vendas*0.035;
        else if( vendas > 15000)
            comissao = vendas*0.02;
        else
            comissao = 0;
        
        return this.comissao;
    }
}
