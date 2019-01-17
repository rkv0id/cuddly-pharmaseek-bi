package com.dminers.pharmabi.external.beans;

public class ArticleBean {
    private int idArticle;
    private String categorie;
    private String designation;
    private String dci1;
    private String dci2;
    private String dci3;

    public ArticleBean(){}

    public ArticleBean(int idArticle, String categorie, String designation, String dci1, String dci2, String dci3) {
        this.idArticle = idArticle;
        this.categorie = categorie;
        this.designation = designation;
        this.dci1 = dci1;
        this.dci2 = dci2;
        this.dci3 = dci3;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDci1() {
        return dci1;
    }

    public void setDci1(String dci1) {
        this.dci1 = dci1;
    }

    public String getDci2() {
        return dci2;
    }

    public void setDci2(String dci2) {
        this.dci2 = dci2;
    }

    public String getDci3() {
        return dci3;
    }

    public void setDci3(String dci3) {
        this.dci3 = dci3;
    }

    @Override
    public String toString() {
        return "ArticleBean{" +
                "idArticle=" + idArticle +
                ", categorie='" + categorie + '\'' +
                ", designation='" + designation + '\'' +
                ", dci1='" + dci1 + '\'' +
                ", dci2='" + dci2 + '\'' +
                ", dci3='" + dci3 + '\'' +
                '}';
    }
}
