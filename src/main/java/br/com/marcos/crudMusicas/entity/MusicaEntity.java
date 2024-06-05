package br.com.marcos.crudMusicas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_musica")
public class MusicaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 200)
    @Size(min = 1, max = 200, message = "O campo titulo deve ter entre 1 e 200 caracteres")
    private String titulo;

    @Column(name = "autor", nullable = false, length = 150)
    @Size(min = 1, max = 150, message = "O campo autor deve ter entre 1 e 150 caracteres.")
    private String autor;

    @Column(name = "data", nullable = false, length = 4)
    @Size(min = 4, max = 4, message = "O campo de data deve estar no formato YYYY.")
    @Pattern(regexp = "\\d{4}", message = "O campo de ano deve estar no formato YYYY")
    private String anoLancamento;

    public MusicaEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MusicaEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTitulo(), that.getTitulo()) && Objects.equals(getAutor(), that.getAutor()) && Objects.equals(getAnoLancamento(), that.getAnoLancamento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitulo(), getAutor(), getAnoLancamento());
    }
}
