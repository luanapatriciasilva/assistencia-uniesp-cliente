package br.edu.uniesp.assistencia.internal.ordemservico.mapper;

import br.edu.uniesp.assistencia.internal.cliente.dto.ClienteResumoResponse;
import br.edu.uniesp.assistencia.internal.cliente.entity.ClienteEntity;
import br.edu.uniesp.assistencia.internal.ordemservico.dto.CriarHistoricoStatusRequest;
import br.edu.uniesp.assistencia.internal.ordemservico.dto.CriarHistoricoStatusResponse;
import br.edu.uniesp.assistencia.internal.ordemservico.dto.HistoricoStatusResumoResponse;
import br.edu.uniesp.assistencia.internal.ordemservico.entity.HistoricoStatusEntity;
import br.edu.uniesp.assistencia.internal.ordemservico.entity.OrdemServicoEntity;

public final class HistoricoStatusMapper {

    private HistoricoStatusMapper() {
    }

    public static HistoricoStatusEntity paraEntidade(CriarHistoricoStatusRequest request, OrdemServicoEntity ordemServico) {
        return new HistoricoStatusEntity(
                ordemServico,
                request.statusAnterior(),
                request.novoStatus(),
                request.responsavel(),
                request.observacao()
        );
    }

    public static CriarHistoricoStatusResponse paraResposta(HistoricoStatusEntity historicoStatus) {
        return new CriarHistoricoStatusResponse(
                historicoStatus.getOrdemServico(),
                historicoStatus.getStatusAnterior(),
                historicoStatus.getNovoStatus(),
                historicoStatus.getResponsavel(),
                historicoStatus.getObservacao(),
                historicoStatus.getDataAlteracao()
        );
    }

    public static HistoricoStatusResumoResponse paraResumoResposta(
            HistoricoStatusEntity historicoStatus) {
        return new HistoricoStatusResumoResponse(
                historicoStatus.getOrdemServico(),
                historicoStatus.getStatusAnterior(),
                historicoStatus.getNovoStatus(),
                historicoStatus.getResponsavel(),
                historicoStatus.getObservacao(),
                historicoStatus.getDataAlteracao()
        );
    }
}
