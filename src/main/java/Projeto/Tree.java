/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto;

import PL.BST;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * 
 * @author ISEP
 * 
 */
public class Tree extends BST<Vertice> {
   
   BST<Vertice> arvore = new BST<>();
   BST<Vertice> arvoreTree = new BST<>();

   //ex 1 read tree
   public void read(File ficheiro) {
        try {
            Scanner read = new Scanner(ficheiro,"utf-8");
            while (read.hasNext()) {
                String line[] = read.nextLine().split(" ");
                if (line.length != 0 && line.length == 3) {
                    Vertice v = new Vertice(line[1].charAt(0), line[2], line[0]);
                    arvore.insertToTree(v);
                }
            }
            read.close();
        } catch (FileNotFoundException e) {
            System.err.println("Ficheiro não encontrado");
        }
    }
   //ex2 descodificar um codigo retornar a palavra
   public String descodificacao (String codigo){
       String temp[] = codigo.split(" ");
       String palavra = "";
       for(int i=0; i<temp.length;i++){
           palavra = palavra + arvore.descodificar(temp[i]);
       }
       return palavra;
   }
   //ex3 read tree so com letras
   public void LetterTree(File ficheiro){
       try {
            Scanner read = new Scanner(ficheiro);
            while (read.hasNext()) {
                String line[] = read.nextLine().split(" ");
                if (line.length != 0 && line.length == 3) {
                    Vertice v = new Vertice(line[1].charAt(0), line[2], line[0]);
                    if(line[2].compareTo("Letter") == 0){
                        arvoreTree.insertToTree(v);
                    }
                }
            }
            read.close();
        } catch (FileNotFoundException e) {
            System.err.println("Ficheiro não encontrado");
        }
   }
   //ex4 codificar uma palavra
   public String codificarLetterTree (String palavra){
       String codigo = "";
       for(int i=0; i<palavra.length();i++){
           codigo = codigo + arvore.codificarPalavra(palavra.charAt(i)) + " ";
       }
       return codigo;
   }
   
   //ex5 retornar a sequencia em comum entre 2 letras nas mesma pos
    // era ate ser diferente ou até ao fim
   public String sequenciaComum (char l1, char l2){
       String codigo1 = arvore.codificarPalavra(l1);
       String codigo2 = arvore.codificarPalavra(l2);
       String aux = "";
       String result = "";
       if(codigo1.length()>codigo2.length()){
           codigo1 = aux;
           codigo1 = codigo2;
           codigo2 = aux;
       }
       for(int i=0; i<codigo1.length();i++){
           if(codigo1.charAt(i) == codigo2.charAt(i)){
               result = result + codigo1.charAt(i);
           }
        }
       return result;
   }
   
   //ex6
   public ArrayList<Ocorrencia> OrdenarPorOcorrencias(String codigo){
       ArrayList<Ocorrencia> OrdByLetter = new ArrayList<Ocorrencia>();
       ArrayList<Ocorrencia> OrdByNon_English = new ArrayList<Ocorrencia>();
       ArrayList<Ocorrencia> OrdByNumber = new ArrayList<Ocorrencia>();
       ArrayList<Ocorrencia> OrdByPunctuation = new ArrayList<Ocorrencia>();
       ArrayList<Ocorrencia> res = new ArrayList<Ocorrencia>();
       
       OrdByLetter.add(new Ocorrencia("Letter:"));
       OrdByNon_English.add(new Ocorrencia("Non_English:"));
       OrdByNumber.add(new Ocorrencia("Number:"));
       OrdByPunctuation.add(new Ocorrencia("Punctuation:"));
       
       

       String listaCodigo[] = codigo.split("/");
       String lista[] = codigo.split("/");
       
       for(int i=0; i<listaCodigo.length ; i++){
           lista[i]=descodificacao(listaCodigo[i]);
       }
       
       for(int i=0; i<lista.length ; i++){
           res.add(new Ocorrencia(lista[i]));

           for(int j=0; j<lista[i].length();j++){
               char letra = lista[i].charAt(j);
               String tipo = arvore.tipoOcorrencia(letra);
               if(tipo.compareTo("Letter")==0){
                   res.get(i).setOcorrencia1((res.get(i).getOcorrencia1()+1));
               }else if(tipo.compareTo("Non-English")==0){
                   res.get(i).setOcorrencia2((res.get(i).getOcorrencia2()+1));
               }else if(tipo.compareTo("Number")==0){
                   res.get(i).setOcorrencia3((res.get(i).getOcorrencia3()+1));
               }else if(tipo.compareTo("Punctuation")==0){
                   res.get(i).setOcorrencia4((res.get(i).getOcorrencia4()+1));
               }   
           }
       }
       
       
       for(int i=1 ; i<OrdByLetter.size();i++){
           if(OrdByLetter.get(i).getOcorrencia1() == 0)
               OrdByLetter.remove(i);
       }
       Collections.sort(res, new Comparator<Ocorrencia>() {
        @Override
        public int compare(Ocorrencia t1, Ocorrencia t2)
        {
            return  t2.getOcorrencia2()-t1.getOcorrencia2();
        }
        });
       OrdByNon_English.addAll(res);
              for(int i=1 ; i<OrdByNon_English.size();i++){
           if(OrdByNon_English.get(i).getOcorrencia2() == 0)
               OrdByNon_English.remove(i);
       }
       Collections.sort(res, new Comparator<Ocorrencia>() {
        @Override
        public int compare(Ocorrencia t1, Ocorrencia t2)
        {
            return  t2.getOcorrencia3()-t1.getOcorrencia3();
        }
        });
       OrdByNumber.addAll(res);
              for(int i=1 ; i<OrdByNumber.size();i++){
           if(OrdByNumber.get(i).getOcorrencia3() == 0)
               OrdByNumber.remove(i);
       }
       Collections.sort(res, new Comparator<Ocorrencia>() {
        @Override
        public int compare(Ocorrencia t1, Ocorrencia t2)
        {
            return  t2.getOcorrencia1()-t1.getOcorrencia1();
        }
        });
       OrdByPunctuation.addAll(res);
                for(int i=1 ; i<OrdByPunctuation.size();i++){
           if(OrdByPunctuation.get(i).getOcorrencia4() == 0)
               OrdByPunctuation.remove(i);
       }
       Collections.sort(res, new Comparator<Ocorrencia>() {
        @Override
        public int compare(Ocorrencia t1, Ocorrencia t2)
        {
            return  t2.getOcorrencia1()-t1.getOcorrencia1();
        }
        });
       OrdByLetter.addAll(res);
        return res;
   }
}
