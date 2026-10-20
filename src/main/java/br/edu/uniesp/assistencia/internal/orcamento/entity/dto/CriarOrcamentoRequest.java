package br.edu.uniesp.assistencia.internal.orcamento.entity.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CriarOrcamentoRequest(

        @NotBlank(message="Data da criação deve ser informada")
        LocalDateTime data_criacao,

        LocalDateTime data_expiracao,
        LocalDateTime data_resposta,

        String justificativa_cliente,

        @NotBlank(message = "Deve ser informado um STATUS para o orçamento.")
        String status,

        @DecimalMin(value = "0.00", message = "O valor mínimo para a mão-de-obra é 0,00 (zero)")
        BigDecimal valor_mao_de_obra,

        @DecimalMin(value = "0.00", message = "O valor mínimo para peças é 0,00 (zero)")
        BigDecimal valor_pecas,

        @DecimalMin(value = "0.00", message = "O valor mínimo para o total do orçamento é 0,00 (zero)")
        BigDecimal valor_total,

        Long ordem_servico_id

) {
}
