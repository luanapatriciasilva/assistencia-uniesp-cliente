package br.edu.uniesp.assistencia.internal.ordemservico.dto;

import br.edu.uniesp.assistencia.internal.ordemservico.entity.StatusOrdemServico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizarHistoricoStatusRequest(

        @NotNull(message = "O ID da ordem de serviço é obrigatório")
        Long ordemServicoId,

        @NotNull(message = "O Status anterior da ordem de serviço é obrigatório")
        StatusOrdemServico statusAnterior,

        @NotNull(message = "O Status atual da ordem de serviço é obrigatório")
        StatusOrdemServico novoStatus,

        @NotBlank(message = "O Nome do responsável  é obrigatório")
        String responsavel,

        @NotBlank(message = "A descrição do problema é obrigatória")
        String observacao

) {
}
