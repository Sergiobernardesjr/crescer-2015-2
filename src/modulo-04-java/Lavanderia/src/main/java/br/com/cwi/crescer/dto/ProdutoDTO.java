package br.com.cwi.crescer.dto;

import java.math.BigDecimal;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import br.com.cwi.crescer.domain.Produto.SituacaoProduto;

public class ProdutoDTO {

    private Long idProduto;

    private Long idServico;

    private String servico;

    private Long idMaterial;

    private String material;

    @NotNull
    private BigDecimal valor;

    @Enumerated
    private SituacaoProduto situacao;

    @NotNull
    private Integer prazo;

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getPrazo() {
        return prazo;
    }

    public void setPrazo(Integer prazo) {
        this.prazo = prazo;
    }



    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public SituacaoProduto getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoProduto situacao) {
        this.situacao = situacao;
    }

}
