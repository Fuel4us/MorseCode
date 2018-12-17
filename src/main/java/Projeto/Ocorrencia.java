/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto;

/**
 *
 * @author Miura
 */
public class Ocorrencia implements Comparable<Ocorrencia>{
    private String palavra;
    private int ocorrencia1;
    private int ocorrencia2;
    private int ocorrencia3;
    private int ocorrencia4;
    
    
    public Ocorrencia(String palavra) {
        this.palavra=palavra;
        this.ocorrencia1=0;
        this.ocorrencia2=0;
        this.ocorrencia3=0;
        this.ocorrencia4=0;
    }

    public Ocorrencia(String palavra, int o1, int o2, int o3 , int o4){
        this.palavra=palavra;
        this.ocorrencia1=o1;
        this.ocorrencia2=o2;
        this.ocorrencia3=o3;
        this.ocorrencia4=o4;
    }
    /**
     * @return the palavra
     */
    public String getPalavra() {
        return palavra;
    }

    /**
     * @param palavra the palavra to set
     */
    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    /**
     * @return the ocorrencia1
     */
    public int getOcorrencia1() {
        return ocorrencia1;
    }

    /**
     * @param ocorrencia1 the ocorrencia1 to set
     */
    public void setOcorrencia1(int ocorrencia1) {
        this.ocorrencia1 = ocorrencia1;
    }

    /**
     * @return the ocorrencia2
     */
    public int getOcorrencia2() {
        return ocorrencia2;
    }

    /**
     * @param ocorrencia2 the ocorrencia2 to set
     */
    public void setOcorrencia2(int ocorrencia2) {
        this.ocorrencia2 = ocorrencia2;
    }

    /**
     * @return the ocorrencia3
     */
    public int getOcorrencia3() {
        return ocorrencia3;
    }

    /**
     * @param ocorrencia3 the ocorrencia3 to set
     */
    public void setOcorrencia3(int ocorrencia3) {
        this.ocorrencia3 = ocorrencia3;
    }

    /**
     * @return the ocorrencia4
     */
    public int getOcorrencia4() {
        return ocorrencia4;
    }

    /**
     * @param ocorrencia4 the ocorrencia4 to set
     */
    public void setOcorrencia4(int ocorrencia4) {
        this.ocorrencia4 = ocorrencia4;
    }
    
    @Override
    public int compareTo(Ocorrencia o) {
        return palavra.compareTo(o.getPalavra());
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
        Ocorrencia obj1 = (Ocorrencia) obj;
        return this.palavra == obj1.palavra ;
    }

}
