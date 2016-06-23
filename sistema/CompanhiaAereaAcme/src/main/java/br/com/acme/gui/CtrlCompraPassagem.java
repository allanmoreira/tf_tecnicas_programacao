package br.com.acme.gui;

import br.com.acme.persistencia.postgre.InicializadorBancoDadosDataSource;

public class CtrlCompraPassagem {
    public static void main(String[] args) throws Exception{
        InicializadorBancoDadosDataSource i = new InicializadorBancoDadosDataSource();
        i.conectarBd();
    }
}
