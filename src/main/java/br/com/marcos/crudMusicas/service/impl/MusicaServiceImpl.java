package br.com.marcos.crudMusicas.service.impl;

import br.com.marcos.crudMusicas.dto.MusicaDTO;
import br.com.marcos.crudMusicas.entity.MusicaEntity;
import br.com.marcos.crudMusicas.repository.MusicaRepository;
import br.com.marcos.crudMusicas.service.MusicaService;
import br.com.marcos.crudMusicas.util.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    MusicaRepository musicaRepository;

    @Override
    public ResponseEntity<MusicaDTO> salvarMusica(MusicaDTO musicaDTO) {
       MusicaEntity musicaEntity = musicaRepository.save(Mapper.convertMusicaDTOToMusicaEntity(musicaDTO));
       return ResponseEntity.status(HttpStatus.CREATED).body(Mapper.convertMusicaEntityToMusicaDTO(musicaEntity));
    }

    @Override
    public ResponseEntity<MusicaDTO> mostrarMusica(Long id) {
        MusicaEntity musicaEntity = musicaRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource Not Founded!"));
        return ResponseEntity.status(HttpStatus.OK).body(Mapper.convertMusicaEntityToMusicaDTO(musicaEntity));
    }

    @Override
    public ResponseEntity<List<MusicaDTO>> mostrarMusicas() {
        List<MusicaDTO> musicaDTOS = Mapper.convertListMusicaEntityToListMusicaDTO(musicaRepository.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(musicaDTOS);
    }

    @Override
    public ResponseEntity<MusicaDTO> alterarMusica(MusicaDTO musica) {
        musicaRepository.findById(musica.getId()).orElseThrow(() -> new RuntimeException("Resource Not Founded!"));
        MusicaEntity musicaEntityUpdated = musicaRepository.save(Mapper.convertMusicaDTOToMusicaEntity(musica));

        return ResponseEntity.status(HttpStatus.OK).body(Mapper.convertMusicaEntityToMusicaDTO(musicaEntityUpdated));
    }

    @Override
    public ResponseEntity<Void> removerMusica(Long id) {
        Optional<MusicaEntity> musicaEntity = musicaRepository.findById(id);
        if (musicaEntity.isPresent()) {
            musicaRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
