package br.edu.uniesp.assistencia.internal.equipamento.dto;

import jakarta.validation.constraints.NotNull;

public record CriarEquipamentoRequest(
        @NotNull String tipo,
        @NotNull String marca,
        @NotNull String modelo,
        @NotNull String numeroSerie,
        @NotNull Long clienteId
) {
}
