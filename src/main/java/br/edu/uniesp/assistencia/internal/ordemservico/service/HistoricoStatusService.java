package br.edu.uniesp.assistencia.internal.ordemservico.service;

import br.edu.uniesp.assistencia.internal.ordemservico.dto.CriarHistoricoStatusRequest;
import br.edu.uniesp.assistencia.internal.ordemservico.dto.CriarHistoricoStatusResponse;
import br.edu.uniesp.assistencia.internal.ordemservico.dto.HistoricoStatusResumoResponse;
import br.edu.uniesp.assistencia.internal.ordemservico.entity.HistoricoStatusEntity;
import br.edu.uniesp.assistencia.internal.ordemservico.entity.OrdemServicoEntity;
import br.edu.uniesp.assistencia.internal.ordemservico.mapper.HistoricoStatusMapper;
import br.edu.uniesp.assistencia.internal.ordemservico.repository.HistoricoStatusRepository;
import br.edu.uniesp.assistencia.internal.ordemservico.repository.OrdemServicoRepository;
import br.edu.uniesp.assistencia.shared.exception.RecursoNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HistoricoStatusService {

    private final HistoricoStatusRepository historicoStatusRepository;
    private final OrdemServicoRepository ordemServicoRepository;

    public CriarHistoricoStatusResponse abrirHistoricoStatus (
            CriarHistoricoStatusRequest request){

        OrdemServicoEntity ordemServico = ordemServicoRepository
                .findById(request.ordemServicoId()).orElseThrow(()
                        -> new RecursoNaoEncontradoException
                        ("Ordem de Serviço", request.ordemServicoId()));

        HistoricoStatusEntity historicoStatusEntity =
                HistoricoStatusMapper.paraEntidade(request,
                        ordemServico);
        historicoStatusRepository.save(historicoStatusEntity);
        return HistoricoStatusMapper.paraResposta(historicoStatusEntity);
    }

    public HistoricoStatusResumoResponse buscarHistoricoStatusPorId(Long id) {
        HistoricoStatusEntity historicoStatus = historicoStatusRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Historico Status", id));
        return HistoricoStatusMapper.paraResumoResposta(historicoStatus);
    }

    @Transactional(readOnly = true)
    public Page<HistoricoStatusResumoResponse> listarTodos(Pageable pageable) {
        return historicoStatusRepository.findAll(pageable)
                .map(HistoricoStatusMapper::paraResumoResposta);
    }

    public void excluir(Long id) {
        historicoStatusRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Historico Status", id));
        historicoStatusRepository.deleteById(id);
    }

}
