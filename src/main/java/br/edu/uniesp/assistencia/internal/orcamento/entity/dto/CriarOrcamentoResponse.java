package br.edu.uniesp.assistencia.internal.orcamento.entity.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CriarOrcamentoResponse(
        LocalDateTime data_criacao,
        LocalDateTime data_expiracao,
        LocalDateTime data_resposta,
        String justificativa_cliente,
        String status,
        BigDecimal valor_mao_de_obra,
        BigDecimal valor_pecas,
        BigDecimal valor_total,
        Long ordem_servico_id
) {
}
