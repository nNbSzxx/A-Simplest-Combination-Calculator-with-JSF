/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combinator;

import java.math.BigInteger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.convert.LongConverter;

/**
 *
 * @author Jason
 */
@ManagedBean
@RequestScoped
public class Combinator {
    private long n;
    private long m;
    private BigInteger result;
    String outcome = "/result.xhtml";

    public BigInteger getResult() {
        return result;
    }

    public void setResult(BigInteger result) {
        this.result = result;
    }

    public String outcome() {
        return outcome;
    }
    
    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public long getN() {
        return n;
    }

    public void setN(long n) {
        this.n = n;
    }

    public long getM() {
        return m;
    }

    public void setM(long m) {
        this.m = m;
    }
    
    public void validateNum(FacesContext context, 
                          UIComponent toValidate,
                          Object value) {
        long num = (Long) value;

        if (num < 0) {
            ((UIInput)toValidate).setValid(false);
            FacesMessage message = new FacesMessage("不能是负数！");
            context.addMessage(toValidate.getClientId(context), message);
        }
    }
    
    public void cal() {
        if (this.m > this.n) {
            result = BigInteger.ZERO;
            return;
        }
        if (this.m > this.n / 2) {
            this.m = this.n - this.m;
        }

        BigInteger n = BigInteger.valueOf(this.n);
        BigInteger m = BigInteger.valueOf(this.m);
        result = BigInteger.ONE;
        for (BigInteger i = n; !(i.equals(n.subtract(m))); i = i.subtract(BigInteger.ONE)) {
            result = result.multiply(i);
        }
        for (BigInteger i = m; !(i.equals(BigInteger.ZERO)); i = i.subtract(BigInteger.ONE)) {
            result = result.divide(i);
        }
        return;
    }
    
    
}
