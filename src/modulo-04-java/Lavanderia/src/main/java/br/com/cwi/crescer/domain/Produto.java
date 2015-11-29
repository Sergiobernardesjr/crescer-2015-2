package br.com.cwi.crescer.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Produto")
@SequenceGenerator(name = Produto.SEQUENCE_NAME, sequenceName = Produto.SEQUENCE_NAME)
public class Produto {

    public static final String SEQUENCE_NAME = "SEQ_Produto";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name = "IDProduto")
    private Long idProduto;

    @ManyToOne
    @JoinColumn(name = "IDServico")
    @Basic(optional = false)
    private Servico servico;

    @Column(name = "prazo", length = 3)
    private Integer prazo;

    public Integer getPrazo() {
        return prazo;
    }

    public void setPrazo(Integer prazo) {
        this.prazo = prazo;
    }

    @ManyToOne
    @JoinColumn(name = "IDMaterial")
    @Basic(optional = false)
    private Material material;

    @Column(name = "Valor")
    @Basic(optional = false)
    private BigDecimal valor;

    @Column(name = "Situacao")
    @Basic(optional = false)
    private SituacaoProduto situacao;

    public SituacaoProduto getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoProduto situacao) {
        this.situacao = situacao;
    }

    @OneToMany(mappedBy = "produto")
    private List<Item> itens;

    public enum SituacaoProduto {
        ATIVO, INATIVO
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }


    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
    public void setMaterial(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public List<Item> getItens() {
        return itens;
    }
}