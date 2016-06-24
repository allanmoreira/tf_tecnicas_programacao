/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.acme.gui;

import br.com.acme.exception.VooDAOException;
import br.com.acme.negocio.fachada.VooFachada;
import br.com.acme.negocio.modelo.Voo;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author allanmoreira
 */
public class CtrlVoo {
    private VooFachada vooFachada;
    
    public CtrlVoo () {
        vooFachada = new VooFachada();
    }
    
    public JComboBox listaVoosDisponiveis(JComboBox dropDownListaVoos) throws VooDAOException{
        dropDownListaVoos.removeAllItems();
        List<Voo> listaVoosDisponiveis = vooFachada.listaVoosDisponiveis();
        
        for (int i = 0; i < listaVoosDisponiveis.size(); i++) {
            dropDownListaVoos.addItem(listaVoosDisponiveis.get(i).getPartida().getAeroporto().getNome() + 
                                     " - " +
                                     listaVoosDisponiveis.get(i).getChegada().getDataChegada() + " - " +
                    
                                     listaVoosDisponiveis.get(i).getChegada().getAeroporto().getNome());    
        }
        
        return dropDownListaVoos;
    }
    
}
