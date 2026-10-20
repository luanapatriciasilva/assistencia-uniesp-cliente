package br.edu.uniesp.assistencia.internal.equipamento.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AtualizarEquipamentoRequest(

        @NotBlank(message = "O tipo é obrigatório")
        @Size(max = 50, message = "O tipo do deve possuir no máximo 50 caracteres")
        String tipo,

        @NotBlank(message = "A marca é obrigatória")
        @Size(max = 100, message = "A marca deve possuir no máximo 100 caracteres")
        String marca,

        @NotBlank(message = "O modelo é obrigatório")
        @Size(max = 100, message = "O modelo deve possuir no máximo 100 caracteres")
        String modelo,

        @NotBlank(message = "O número de série é obrigatório")
        @Size(max = 100, message = "O número de série deve possuir no máximo 100 caracteres")
        String numeroSerie

) {
}