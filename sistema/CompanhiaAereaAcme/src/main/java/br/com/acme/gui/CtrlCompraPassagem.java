package br.com.acme.gui;

import br.com.acme.persistencia.postgre.VooDAOPostgre;

public class CtrlCompraPassagem {
    public static void main(String[] args) throws Exception{
        VooDAOPostgre cli = new VooDAOPostgre();
        System.out.println(cli.selectAll());
    }
}
