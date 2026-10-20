package br.edu.uniesp.assistencia.internal.equipamento.mapper;

import br.edu.uniesp.assistencia.internal.cliente.entity.ClienteEntity;
import br.edu.uniesp.assistencia.internal.equipamento.dto.CriarEquipamentoRequest;
import br.edu.uniesp.assistencia.internal.equipamento.dto.CriarEquipamentoResponse;
import br.edu.uniesp.assistencia.internal.equipamento.dto.EquipamentoResumoResponse;
import br.edu.uniesp.assistencia.internal.equipamento.entity.EquipamentoEntity;

public final class EquipamentoMapper {

    private EquipamentoMapper() {
    }

    public static EquipamentoEntity converteParaEntidade(CriarEquipamentoRequest request, ClienteEntity cliente) {
        return new EquipamentoEntity(
                request.tipo(),
                request.marca(),
                request.modelo(),
                request.numeroSerie(),
                cliente
        );
    }
    public static CriarEquipamentoResponse converterParaResposta(EquipamentoEntity equipamento) {
        return new CriarEquipamentoResponse(
                equipamento.getTipo(),
                equipamento.getMarca(),
                equipamento.getModelo(),
                equipamento.getNumeroSerie(),
                equipamento.getCliente().getId()
        );
    }

    public static EquipamentoResumoResponse paraResumoResposta(
            EquipamentoEntity equipamento) {
        return new EquipamentoResumoResponse(
                equipamento.getId(),
                equipamento.getTipo(),
                equipamento.getMarca(),
                equipamento.getModelo(),
                equipamento.getNumeroSerie()
        );
    }

}
