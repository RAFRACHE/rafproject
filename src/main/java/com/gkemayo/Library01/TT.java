package com.gkemayo.Library01;

import net.bytebuddy.utility.RandomString;

import java.util.Collection;
import java.util.Objects;
import java.util.Random;

public class TT {
    private int id;
    private String nom;
    private String desc;

    public TT() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TT tt = (TT) o;
        return id == tt.id &&
                Objects.equals(nom, tt.nom) &&
                Objects.equals(desc, tt.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, desc);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public TT(int id, String nom, String desc) {
        this.id = id;
        this.nom = nom;
        this.desc = desc;
    }

    public static void main(String[] args){
      Random rnd = new Random();
        int nbr=0;
        Collection<TT> tts = null;
        while (nbr<10){
            TT t = new TT();
            t.nom= RandomString.make(18);
            t.id= 100+rnd.nextInt(1000);
            t.desc=RandomString.make(18);
            System.out.println("le resultat de toString: "+t.toString()+"");
            System.out.println("//le resultat de hashCode"+t.hashCode()+"\n");
            nbr++;
            //tts.add(t);
        }




    }
}
