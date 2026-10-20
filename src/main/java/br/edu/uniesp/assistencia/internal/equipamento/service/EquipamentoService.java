package br.edu.uniesp.assistencia.internal.equipamento.service;

import br.edu.uniesp.assistencia.internal.cliente.entity.ClienteEntity;
import br.edu.uniesp.assistencia.internal.cliente.repository.ClienteRepository;
import br.edu.uniesp.assistencia.internal.equipamento.dto.AtualizarEquipamentoRequest;
import br.edu.uniesp.assistencia.internal.equipamento.dto.CriarEquipamentoRequest;
import br.edu.uniesp.assistencia.internal.equipamento.dto.CriarEquipamentoResponse;
import br.edu.uniesp.assistencia.internal.equipamento.dto.EquipamentoResumoResponse;
import br.edu.uniesp.assistencia.internal.equipamento.entity.EquipamentoEntity;
import br.edu.uniesp.assistencia.internal.equipamento.mapper.EquipamentoMapper;
import br.edu.uniesp.assistencia.internal.equipamento.repository.EquipamentoRepository;
import br.edu.uniesp.assistencia.internal.ordemservico.service.OrdemServicoService;
import br.edu.uniesp.assistencia.shared.exception.RecursoNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;
    private final ClienteRepository clienteRepository;

    @Transactional
    public CriarEquipamentoResponse criarEquipamento(CriarEquipamentoRequest request) {

        ClienteEntity cliente = clienteRepository.findById(request.clienteId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente", request.clienteId()));

        EquipamentoEntity equipamento = EquipamentoMapper.converteParaEntidade(request, cliente);
        equipamentoRepository.save(equipamento);
        return EquipamentoMapper.converterParaResposta(equipamento);
    }

    public EquipamentoResumoResponse buscarEquipamentoPorId(Long id) {
        EquipamentoEntity equipamento = equipamentoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Equipamento", id));
        return EquipamentoMapper.paraResumoResposta(equipamento);
    }

    @Transactional(readOnly = true)
    public Page<EquipamentoResumoResponse> listarTodos(Pageable pageable) {
        return equipamentoRepository.findAll(pageable)
                .map(EquipamentoMapper::paraResumoResposta);
    }

    @Transactional
    public EquipamentoResumoResponse atualizarEquipamento(Long id, AtualizarEquipamentoRequest request) {
        EquipamentoEntity equipamento = equipamentoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Equipamento", id));
        equipamento.alterarDados(request.tipo(),
                                 request.marca(),
                                 request.modelo(),
                                 request.numeroSerie());
        return EquipamentoMapper.paraResumoResposta(equipamento);
    }

    @Transactional
    public void excluir(Long id) {
        EquipamentoEntity equipamento = equipamentoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Equipamento", id));
        equipamentoRepository.deleteById(id);
    }

}
