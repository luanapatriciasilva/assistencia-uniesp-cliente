package br.edu.uniesp.assistencia.internal.equipamento.dto;

public record EquipamentoResumoResponse(
        Long id,
        String nome,
        String cpf,
        String email,
        String numeroSerie
) {
}

