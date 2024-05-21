package br.com.marcos.crudMusicas.util.mapper;

import br.com.marcos.crudMusicas.dto.MusicaDTO;
import br.com.marcos.crudMusicas.entity.MusicaEntity;

public class Mapper {

    private Mapper() {

    }

    public static MusicaDTO convertMusicaEntityToMusicaDTO(MusicaEntity musicaEntity) {
        MusicaDTO musicaDTO = new MusicaDTO();

        musicaDTO.setId(musicaEntity.getId());
        musicaDTO.setTitulo(musicaEntity.getTitulo());
        musicaDTO.setAnoLancamento(musicaDTO.getAnoLancamento());
        musicaDTO.setAutor(musicaEntity.getAutor());
        return musicaDTO;
    }

    public static MusicaEntity convertMusicaDTOToMusicaEntity(MusicaDTO musicaDTO) {
        MusicaEntity musicaEntity = new MusicaEntity();

        musicaEntity.setId(musicaDTO.getId());
        musicaEntity.setTitulo(musicaDTO.getTitulo());
        musicaEntity.setAnoLancamento(musicaDTO.getAnoLancamento());
        musicaEntity.setAutor(musicaDTO.getAutor());
        return musicaEntity;
    }
}
