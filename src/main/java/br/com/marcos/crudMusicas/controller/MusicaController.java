package br.com.marcos.crudMusicas.controller;

import br.com.marcos.crudMusicas.dto.MusicaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    private MusicaDTO musicaDTO = new MusicaDTO();
    @GetMapping("/{id}")
    public ResponseEntity<MusicaDTO> findMusicaById(@PathVariable(value = "id") Long id) {
        musicaDTO.setId(id);
        return ResponseEntity.ok(musicaDTO);
    }

    @GetMapping
    public ResponseEntity<List<MusicaDTO>> findAllMusics() {
        List<MusicaDTO> musicas = new ArrayList<>();

        musicas.add(new MusicaDTO(2L, "teste", "teste", "2000"));
        musicas.add(new MusicaDTO(2L, "teste", "teste", "2000"));
        musicas.add(new MusicaDTO(2L, "teste", "teste", "2000"));

        return ResponseEntity.ok().body(musicas);
    }

    @PostMapping
    public ResponseEntity<MusicaDTO> createNewMusica(@RequestBody MusicaDTO musicaDTO) {
        musicaDTO.setId(666L);
        return ResponseEntity.status(HttpStatus.CREATED).body(musicaDTO);
    }

    @PutMapping
    public ResponseEntity<MusicaDTO> updateMusica(@RequestBody MusicaDTO musicaDTO) {
        musicaDTO.setTitulo("atualizaduuu");
        return ResponseEntity.status(HttpStatus.OK).body(musicaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMusica(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
