package com.example.syncmobile;

public class Ordem {
    private Integer id;
    private String dataOrdem;
    private String valorOrdem;
    private String status;
    private String nomeUsuario;
    private String observacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer numero_ordem) {
        this.id = numero_ordem;
    }

    public String getDataOrdem() {
        return dataOrdem;
    }

    public void setDataOrdem(String data_ordem) {
        this.dataOrdem = data_ordem;
    }

    public String getValorOrdem() {return valorOrdem;}

    public void setValorOrdem(String valorOrdem) {this.valorOrdem = valorOrdem;}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNomeUsuario() {return nomeUsuario;}

    public void setNomeUsuario(String nomeUsuario) {this.nomeUsuario = nomeUsuario;}

    public String getObservacao() {return observacao;}

    public void setObservacao(String observacao) {this.observacao = observacao;}
}
