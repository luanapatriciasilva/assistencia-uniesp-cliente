package br.edu.uniesp.assistencia.internal.anexo.entity.controller;

import br.edu.uniesp.assistencia.internal.anexo.entity.AnexoEntity;
import br.edu.uniesp.assistencia.internal.anexo.entity.dto.AnexoResumoResponse;
import br.edu.uniesp.assistencia.internal.anexo.entity.dto.CriarAnexoRequest;
import br.edu.uniesp.assistencia.internal.anexo.entity.dto.CriarAnexoResponse;
import br.edu.uniesp.assistencia.internal.anexo.entity.mapper.AnexoMapper;
import br.edu.uniesp.assistencia.internal.anexo.entity.repository.AnexoRepository;
import br.edu.uniesp.assistencia.internal.anexo.entity.service.AnexoService;
import br.edu.uniesp.assistencia.internal.ordemservico.entity.OrdemServicoEntity;
import br.edu.uniesp.assistencia.internal.ordemservico.repository.OrdemServicoRepository;
import br.edu.uniesp.assistencia.shared.exception.RecursoNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("anexos")
@RequiredArgsConstructor
public class AnexoController {

    private final AnexoService anexoService;
    private final OrdemServicoRepository ordemServicoRepository;
    private final AnexoRepository anexoRepository;

    @PostMapping
    @Transactional
    public CriarAnexoResponse criar(CriarAnexoRequest request) {

        OrdemServicoEntity ordemServico = ordemServicoRepository.findById(request.ordemServicoId())
            .orElseThrow(() -> new RecursoNaoEncontradoException("Ordem de Serviço", request.ordemServicoId()));

        AnexoEntity anexo = AnexoMapper.converteParaEntidade(request, ordemServico);
        anexoRepository.save(anexo);
        return AnexoMapper.converterParaResposta(anexo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnexoResumoResponse> buscarPorId(@PathVariable Long id) {
        AnexoResumoResponse response = anexoService.buscarAnexoPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<AnexoResumoResponse>> listarTodos(Pageable pageable) {
        org.springframework.data.domain.Page<AnexoResumoResponse> page = anexoService.listarTodos(pageable);
        return ResponseEntity.ok(page);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AnexoResumoResponse> atualizar(@PathVariable Long id) {
        AnexoResumoResponse response = anexoService.atualizarAnexo(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        anexoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
