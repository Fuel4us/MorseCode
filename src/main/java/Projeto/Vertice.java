/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto;

/**
 *
 * 
 */
public class Vertice implements Comparable<Vertice>{
    public char letra;
    public String tipo;
    public String codigo;

    public Vertice(char letra, String tipo, String codigo) {
        this.letra = letra;
        this.tipo = tipo;
        this.codigo = codigo;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }   
    
    @Override
    public int compareTo(Vertice o) {
        return codigo.compareTo(o.getCodigo());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vertice other = (Vertice) obj;
        return this.compareTo(other) == 0;
    }
}
