package br.com.marcos.crudMusicas.util.mapper;

import br.com.marcos.crudMusicas.dto.MusicaDTO;
import br.com.marcos.crudMusicas.entity.MusicaEntity;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    private Mapper() {

    }

    public static MusicaDTO convertMusicaEntityToMusicaDTO(MusicaEntity musicaEntity) {
        MusicaDTO musicaDTO = new MusicaDTO();

        musicaDTO.setId(musicaEntity.getId());
        musicaDTO.setTitulo(musicaEntity.getTitulo());
        musicaDTO.setAnoLancamento(musicaEntity.getAnoLancamento());
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

    public static List<MusicaDTO> convertListMusicaEntityToListMusicaDTO(List<MusicaEntity> musicaEntities) {
        List<MusicaDTO> musicaDTOs = new ArrayList<MusicaDTO>();
        musicaEntities.forEach(musicaEntity -> musicaDTOs.add(convertMusicaEntityToMusicaDTO(musicaEntity)));
        return musicaDTOs;
    }

    public static List<MusicaEntity> convertListMusicaDTOToListMusicaEntity(List<MusicaDTO> musicaDTOs) {
        List<MusicaEntity> musicaEntities = new ArrayList<MusicaEntity>();
        musicaDTOs.forEach(musicaDTO -> musicaEntities.add(convertMusicaDTOToMusicaEntity(musicaDTO)));
        return musicaEntities;
    }
}
