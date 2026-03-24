package com.example.demo.bicos.models;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@SQLDelete(sql = "UPDATE users SET deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted_at is NULL")
@EntityListeners(AuditingEntityListener.class)
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name="id")
    private UUID id;

    @Column
    private String username;

    @Column
    private String mail;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;
    
    @Column(name = "deleted_at")
    private Instant deletedAt;

    @JsonIgnore
    @OneToMany(mappedBy="user")
    private List<Bicos> bicos;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Candidatura> candidaturas;

    public User() {
    }

    public User(UUID id, String username, String mail, String password, Instant createdAt,
            Instant updatedAt, Instant deletedAt) {
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public enum UserRole {
    ADMIN,
    OPERADOR,
    USER
}
//candidatura - fk_user, fk_bico, status enum-(confirmado,pendente, aprovado, rejeitado), data_solicitacao, 
//historico_aprov - fk_candidatura, fk_user_aprovador, decisao enum(aprovado ou rejeitado), motivo, data_aprovacao 
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }


    public Instant getUpdatedAt() {
        return updatedAt;
    }


    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }


    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }


    public List<Bicos> getBicos() {
        return bicos;
    }

    public void setBicos(List<Bicos> bicos) {
        this.bicos = bicos;
    }


    public List<Candidatura> getCandidaturas() {
        return candidaturas;
    }


    public void setCandidaturas(List<Candidatura> candidaturas) {
        this.candidaturas = candidaturas;
    }

}
