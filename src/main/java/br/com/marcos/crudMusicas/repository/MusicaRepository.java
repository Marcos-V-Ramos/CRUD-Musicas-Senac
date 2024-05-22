package br.com.marcos.crudMusicas.repository;

import br.com.marcos.crudMusicas.entity.MusicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository extends JpaRepository<MusicaEntity, Long> {
}
