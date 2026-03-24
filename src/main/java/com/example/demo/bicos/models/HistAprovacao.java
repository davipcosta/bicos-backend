package com.example.demo.bicos.models;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

//historico_aprov - fk_candidatura, fk_user_aprovador, decisao enum(aprovado ou rejeitado), motivo, data_aprovacao 
@Entity
@Table(name="hist_aprov")
public class HistAprovacao {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "candidatura_id")
    private Candidatura candidatura;

    @Enumerated(EnumType.STRING)
    @Column(name="decisao")
    private HistAprovacaoStatus decisao;

    @Column(name="motivo")
    private String motivo;

    @CreationTimestamp
    @Column(name="data_aprovacao")
    private Instant dataAprovacao;

    public HistAprovacao() {
    }

    public HistAprovacao(Long id, Candidatura candidatura, HistAprovacaoStatus decisao, String motivo,
            Instant dataAprovacao) {
        this.id = id;
        this.candidatura = candidatura;
        this.decisao = decisao;
        this.motivo = motivo;
        this.dataAprovacao = dataAprovacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Candidatura getCandidatura() {
        return candidatura;
    }

    public void setCandidatura(Candidatura candidatura) {
        this.candidatura = candidatura;
    }

    public HistAprovacaoStatus getDecisao() {
        return decisao;
    }

    public void setDecisao(HistAprovacaoStatus decisao) {
        this.decisao = decisao;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Instant getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(Instant dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    
}
