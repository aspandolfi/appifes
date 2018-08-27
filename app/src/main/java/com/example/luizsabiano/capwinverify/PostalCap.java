package com.example.luizsabiano.capwinverify;

public class PostalCap {
    public int id;
    public String cpf;
    public String sorte;
    public String titulo;
    public String dtCompra;
    public String dtResgate;
    public String sort1;
    public String sort2;
    public String sort3;
    public String sort4;
    public String sort5;

    public PostalCap (int id, String cpf,  String sorte,  String titulo, String dtCompra, String dtResgate, String sort1, String sort2, String sort3, String sort4, String sort5) {
        this.id = id;
        this.cpf = cpf;
        this.sorte = sorte;
        this.titulo = titulo;
        this.dtCompra = dtCompra;
        this.dtResgate = dtResgate;
        this.sort1 = sort1;
        this.sort2 = sort2;
        this.sort3 = sort3;
        this.sort4 = sort4;
        this.sort5 = sort5;
    }

    //getting id
    public int getId() {
        return id;
    }
    //setting id
    public void setId(int id) {
        this.id = id;
    }
    //getting cpf
    public String getCpf() {
        return cpf;
    }
    //setting cpf
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    //getting sorte
    public String getSorte() {
        return sorte;
    }
    //setting sorte
    public void setSorte(String sorte) {
        this.sorte = sorte;
    }
    //getting titulo
    public String getTitulo() {
        return titulo;
    }
    //setting titulo
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    //getting dtCompra
    public String getDtCompra() {
        return dtCompra;
    }
    //setting dtCompra
    public void setDtCompra(String dtCompra) {
        this.dtCompra = dtCompra;
    }
    //getting dtResgate
    public String getDtResgate() {
        return dtResgate;
    }
    //setting dtResgate
    public void setDtResgate(String dtResgate) {
        this.dtResgate = dtResgate;
    }

    //getting sort1
    public String getSort1() {
        return sort1;
    }
    //setting sorte1
    public void setSort1(String sort1) {
        this.sort1 = sort1;
    }

    //getting sort2
    public String getSort2() {
        return sort2;
    }
    //setting sort2
    public void setSort2(String sort2) {
        this.sort2 = sort2;
    }

    //getting sort3
    public String getSort3() {
        return sort3;
    }
    //setting sort3
    public void setSort3(String sort3) {
        this.sort3 = sort3;
    }

    //getting sort4
    public String getSort4() {
        return sort4;
    }
    //setting sort4
    public void setSort4(String sort4) {
        this.sort4 = sort4;
    }

    //getting sort5
    public String getSort5() {
        return sort5;
    }
    //setting sort5
    public void setSort5(String sort5) {
        this.sort5 = sort5;
    }
}
