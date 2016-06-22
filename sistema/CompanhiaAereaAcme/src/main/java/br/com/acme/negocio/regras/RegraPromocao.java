package br.com.acme.negocio.regras;

import br.com.acme.negocio.modelo.Passagem;

public interface RegraPromocao {

	public boolean passageiroAptoPromocao(Passagem passagem);

	public void aplicaPromocao(Passagem passagem);

}
