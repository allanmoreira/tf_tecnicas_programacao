package br.com.acme.negocio.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by allanmoreira on 23/06/16.
 */
public class CalculoMonetario {

    private BigDecimal valor1, valor2, resultado;

    public BigDecimal multiplica(BigDecimal valor1, BigDecimal valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;

        resultado = this.valor1.multiply(this.valor2);
        resultado = resultado.setScale(2, RoundingMode.HALF_EVEN);
        return resultado;
    }

    public BigDecimal divide(BigDecimal valor1, BigDecimal valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;

        resultado = this.valor1.divide(this.valor2, 2, RoundingMode.HALF_EVEN);
        return resultado;
    }
}
