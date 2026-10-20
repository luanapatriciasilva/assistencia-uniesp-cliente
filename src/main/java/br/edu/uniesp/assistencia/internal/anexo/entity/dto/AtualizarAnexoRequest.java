package br.edu.uniesp.assistencia.internal.anexo.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AtualizarAnexoRequest(

        @NotBlank(message = "O caminho de armazenamento é obrigatório")
        @Size(max = 255, message = "O caminho deve possuir no máximo 255 caracteres")
        String caminho_storage,

        @NotBlank(message = "A data de upload é obrigatória!")
        LocalDate data_upload,

        @NotBlank(message = "O Nome do arquivo é obrigatório!")
        @Size(max = 255, message = "O nome do arquivo não pode ter mais de 255 caracteres!")
        String nome_arquivo_storage,

        @NotBlank(message = "O nome original é obrigatório!")
        @Size(max = 255, message = "O nome original não pode ter mais de 255 caracteres!")
        String nome_original,

        @NotBlank(message = "O tamanho do arquivo é obrigatório!")
        Long tamanho_bytes,

        @NotBlank(message = "A informação do tipo de conteúdo é obrigatória!")
        @Size(max = 100)
        String tipo_conteudo,

        @NotBlank(message = "Identificador da ordem de serviço não preenchido!")
        Long ordem_servico_id
) {
}