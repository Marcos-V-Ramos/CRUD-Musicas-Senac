package br.com.marcos.crudMusicas.service;

import br.com.marcos.crudMusicas.dto.MusicaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MusicaService {
    ResponseEntity<MusicaDTO> salvarMusica(MusicaDTO musicaDTO);
    ResponseEntity<MusicaDTO> mostrarMusica(Long id);
    ResponseEntity<List<MusicaDTO>> mostrarMusicas();
    ResponseEntity<MusicaDTO> alterarMusica(MusicaDTO musica);
    ResponseEntity<Void> removerMusica(Long id);
}
