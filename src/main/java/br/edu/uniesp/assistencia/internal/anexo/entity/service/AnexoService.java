package br.edu.uniesp.assistencia.internal.anexo.entity.service;

import br.edu.uniesp.assistencia.internal.anexo.entity.AnexoEntity;
import br.edu.uniesp.assistencia.internal.anexo.entity.dto.AnexoResumoResponse;
import br.edu.uniesp.assistencia.internal.anexo.entity.dto.CriarAnexoRequest;
import br.edu.uniesp.assistencia.internal.anexo.entity.dto.CriarAnexoResponse;
import br.edu.uniesp.assistencia.internal.anexo.entity.mapper.AnexoMapper;
import br.edu.uniesp.assistencia.internal.anexo.entity.repository.AnexoRepository;
import br.edu.uniesp.assistencia.internal.cliente.dto.ClienteResumoResponse;
import br.edu.uniesp.assistencia.internal.equipamento.dto.EquipamentoResumoResponse;
import br.edu.uniesp.assistencia.internal.equipamento.mapper.EquipamentoMapper;
import br.edu.uniesp.assistencia.internal.ordemservico.repository.OrdemServicoRepository;
import br.edu.uniesp.assistencia.shared.exception.RecursoNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
public class AnexoService {

    private final AnexoRepository anexoRepository;
    private final OrdemServicoRepository ordemServicoRepository;

    @Transactional
    public CriarAnexoResponse criarAnexo(CriarAnexoRequest request, Long ordemServicoId) {
        AnexoEntity anexo = AnexoMapper.converteParaEntidade(request, ordemServicoRepository.findById(ordemServicoId)
                .orElseThrow(() -> new RecursoNaoEncontradoException
                        ("Ordem de Serviço", request.ordemServicoId())));
        anexoRepository.save(anexo);
        return AnexoMapper.converterParaResposta(anexo);
    }

    public AnexoResumoResponse buscarAnexoPorId(Long id) {
        AnexoEntity anexo = anexoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Ordem de Serviço", id));
        return AnexoMapper.paraResumoResposta(anexo);
    }

    @Transactional(readOnly = true)
    public Page<AnexoResumoResponse> listarTodos(Pageable pageable) {
        return anexoRepository.findAll(pageable)
                .map(AnexoMapper::paraResumoResposta);
    }

    @Transactional
    public AnexoResumoResponse atualizarAnexo(Long id) {
        AnexoEntity anexo = anexoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Ordem de Serviço", id));
        anexoRepository.save(anexo);
        return AnexoMapper.paraResumoResposta(anexo);
    }

    @Transactional
    public void excluir(Long id) {
        anexoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Anexo", id));
        anexoRepository.deleteById(id);
    }

}
