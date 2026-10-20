package br.edu.uniesp.assistencia.internal.ordemservico.dto;

import br.edu.uniesp.assistencia.internal.ordemservico.entity.OrdemServicoEntity;
import br.edu.uniesp.assistencia.internal.ordemservico.entity.StatusOrdemServico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizarHistoricoStatusResponse(

        @NotNull(message = "A ordem de serviço é obrigatória para atualização do status!")
        OrdemServicoEntity ordemServico,

        @NotNull(message = "É obrigatório o preenchimento do STATUS anterior da ordem de serviço!")
        StatusOrdemServico statusAnterior,

        @NotNull(message = "É obrigatório o preenchimento do novo STATUS da ordem de serviço!")
        StatusOrdemServico novoStatus,

        @NotBlank(message = "O preenchimento do responsável é obrigatório!")
        String responsavel,

        String observacao

) {
}
