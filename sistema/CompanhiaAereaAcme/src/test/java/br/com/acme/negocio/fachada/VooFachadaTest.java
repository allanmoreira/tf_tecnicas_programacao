/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.acme.negocio.fachada;

import br.com.acme.negocio.modelo.Assento;
import br.com.acme.negocio.modelo.Voo;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author allanmoreira
 */
public class VooFachadaTest {
    
    VooFachada vf;
    
    @Before
    public void setUp() {
        vf = new VooFachada();
    }
    

    /**
     * Test of listaVoosDisponiveis method, of class VooFachada.
     */
    @Test
    public void testListaVoosDisponiveis() throws Exception {
        System.out.println("listaVoosDisponiveis");
        VooFachada instance = new VooFachada();
        List<Voo> expResult = null;
        List<Voo> result = instance.listaVoosDisponiveis();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarVoo method, of class VooFachada.
     */
    @Test
    public void testBuscarVoo() throws Exception {
        System.out.println("buscarVoo");
        int idVoo = 0;
        VooFachada instance = new VooFachada();
        Voo expResult = null;
        Voo result = instance.buscarVoo(idVoo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listaAssentos method, of class VooFachada.
     */
    @Test
    public void testListaAssentos() throws Exception {
        System.out.println("listaAssentos");
        Voo voo = null;
        VooFachada instance = new VooFachada();
        List<Assento> expResult = null;
        List<Assento> result = instance.listaAssentos(voo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
