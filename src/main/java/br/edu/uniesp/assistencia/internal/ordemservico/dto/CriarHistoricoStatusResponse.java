package br.edu.uniesp.assistencia.internal.ordemservico.dto;

import br.edu.uniesp.assistencia.internal.ordemservico.entity.OrdemServicoEntity;
import br.edu.uniesp.assistencia.internal.ordemservico.entity.StatusOrdemServico;

import java.time.LocalDateTime;

public record CriarHistoricoStatusResponse(
        OrdemServicoEntity ordemServico,
        StatusOrdemServico statusAnterior,
        StatusOrdemServico novoStatus,
        String responsavel,
        String observacao,
        LocalDateTime dataAlteracao
) {
}
