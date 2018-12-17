/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto;

import PL.BST;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ISEP
 */
public class TreeTest {

    Tree instance;
    Tree instance2;
    
    public TreeTest() {
        instance = new Tree();
        instance.read(new File("morse_v1.csv"));
        instance2 = new Tree();
        instance2.read(new File("morse_v3.csv"));
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of read method, of class Tree. ex1 
     */
    @Test
    public void testRead() {
        Vertice A = new Vertice('E', "Letter", ".");
        Vertice B = new Vertice('T', "Letter", "_");
        Vertice C = new Vertice('I', "Letter", "..");
        Vertice D = new Vertice('A', "Letter", "._");
        Vertice E = new Vertice('N', "Letter", "_.");
        Vertice F = new Vertice('M', "Letter", "__");
        
        BST<Vertice> arvore = new BST<>();
        arvore.insertToTree(A);
        arvore.insertToTree(B);
        arvore.insertToTree(C);
        arvore.insertToTree(D);
        arvore.insertToTree(F);
        arvore.insertToTree(E);
        
        System.out.println("read");
        Map<Integer, List<Vertice>> nodesByLevel = instance.arvore.nodesByLevel();
        assertTrue("Level 1 has E and T: ", nodesByLevel.get(1).contains(A));        
    }


    /**
     * Test of LetterTree method, of class Tree. ex3
     */
    @Test
    public void testLetterTree() {
        System.out.println("LetterTree");
        instance2.LetterTree(new File("morse_teste.csv"));
    }

    /**
     * Test of descodificacao method, of class Tree. ex2
     */
    @Test
    public void testDescodificacao() {
        System.out.println("Descodificacao");
        String morse_code = ". ... .. _. .._.";
        String expResult = "ESINF";
        String result = instance2.descodificacao(morse_code);
        assertEquals(expResult, result);
    }

    
    
    
    
    
    /**
     * Test of codificarLetterTree method, of class Tree. ex4
     */
    @Test
    public void testCodificarLetterTree() {
        System.out.println("codificarLetterTree");
        instance2.LetterTree(new File("morse_v3.csv"));
        String palavra = "ESINF";
        String expResult = ". ... .. _. .._. ";
        String result = instance2.codificarLetterTree(palavra);
        assertEquals(expResult, result);
    }

    /**
     * Test of sequenciaComum method, of class Tree. ex5
     */
    @Test
    public void testSequenciaComum() {
        System.out.println("sequenciaComum");
        char l1 = '5';
        char l2 = '4';
        String expResult = "....";
        String result = instance2.sequenciaComum(l1, l2);
        assertEquals(expResult, result);
    }

    /**
     * Test of OrdenarPorOcorrencias method, of class Tree. ex6
     */
    @Test
    public void testOrdenarPorOcorrencias() {
        System.out.println("OrdenarPorOcorrencias");
        String codigo = ".... .. ..... _ ./_._ ... _/__ ..";
        Ocorrencia oc = new Ocorrencia("HI5TE", 4, 0 ,1, 0);
        Ocorrencia oc1 = new Ocorrencia("KST", 3, 0 , 0 , 0);
        Ocorrencia oc2 = new Ocorrencia("MI", 2, 0 , 0 , 0);
        ArrayList<Ocorrencia> expResult =  new ArrayList<Ocorrencia>();
        expResult.add(oc);
        expResult.add(oc1);
        expResult.add(oc2);
        ArrayList<Ocorrencia> result = instance2.OrdenarPorOcorrencias(codigo);
        assertEquals(expResult.get(0).getPalavra(),result.get(0).getPalavra());
    }
}
