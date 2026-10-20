package br.edu.uniesp.assistencia.internal.anexo.entity.repository;

import br.edu.uniesp.assistencia.internal.anexo.entity.AnexoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnexoRepository extends JpaRepository<AnexoEntity, Long> {
}
