package br.com.marcos.crudMusicas.controller;

import br.com.marcos.crudMusicas.dto.MusicaDTO;
import br.com.marcos.crudMusicas.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private MusicaService musicaService;

    @GetMapping("/{id}")
    public ResponseEntity<MusicaDTO> findMusicaById(@PathVariable(value = "id") Long id) {
        return musicaService.mostrarMusica(id);
    }

    @GetMapping
    public ResponseEntity<List<MusicaDTO>> findAllMusics() {
        return musicaService.mostrarMusicas();
    }

    @PostMapping
    public ResponseEntity<MusicaDTO> createNewMusica(@RequestBody MusicaDTO musicaDTO) {
        return musicaService.salvarMusica(musicaDTO);
    }

    @PutMapping
    public ResponseEntity<MusicaDTO> updateMusica(@RequestBody MusicaDTO musicaDTO) {
        return musicaService.alterarMusica(musicaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMusica(@PathVariable(value = "id") Long id) {
        return musicaService.removerMusica(id);
    }
}
