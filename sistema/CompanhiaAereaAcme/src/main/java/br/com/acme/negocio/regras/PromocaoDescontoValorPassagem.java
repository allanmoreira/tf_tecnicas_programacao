package br.com.acme.negocio.regras;

import br.com.acme.negocio.modelo.Passagem;
import br.com.acme.negocio.util.CalculoMonetario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PromocaoDescontoValorPassagem implements RegraPromocao {

	/**
	 * Verifica se o passageiro está apto para a promoção. Comprando uma passagem com valor maior de R$ 1000,00,
	 * o cliente ganha 50% de desconto no valor total da compra.
	 *
	 * @return true se apto, false caso contrário
     */
	public boolean passageiroAptoPromocao(Passagem passagem) {
		BigDecimal valorMinimo = new BigDecimal("1000");
		return (passagem.getPrecoCompra().compareTo(valorMinimo) == 1);
	}

	public void aplicaPromocao(Passagem passagem) {
		BigDecimal valor = passagem.getPrecoCompra();
		valor = new CalculoMonetario().divide(valor, new BigDecimal(2));
		passagem.setPrecoCompra(valor);
	}

}
