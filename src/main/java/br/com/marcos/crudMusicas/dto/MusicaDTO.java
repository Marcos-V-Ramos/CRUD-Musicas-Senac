package br.com.marcos.crudMusicas.dto;

import java.io.Serializable;
import java.util.Objects;

public class MusicaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public MusicaDTO() {}

    public MusicaDTO(Long id, String titulo, String autor, String anoLancamento) {
        setId(id);
        setAutor(autor);
        setTitulo(titulo);
        setAnoLancamento(anoLancamento);
    }

    private Long id;
    private String titulo;
    private String autor;
    private String anoLancamento;

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
        if (!(o instanceof MusicaDTO musicaDTO)) return false;
        return Objects.equals(getId(), musicaDTO.getId()) && Objects.equals(getTitulo(), musicaDTO.getTitulo()) && Objects.equals(getAutor(), musicaDTO.getAutor()) && Objects.equals(getAnoLancamento(), musicaDTO.getAnoLancamento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitulo(), getAutor(), getAnoLancamento());
    }
}
