package br.edu.uniesp.assistencia.internal.anexo.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CriarAnexoRequest(

        @NotBlank(message = "O caminho de armazenamento é obrigatório")
        @Size(max = 255, message = "O caminho deve possuir no máximo 255 caracteres")
        String caminhoStorage,

        @NotBlank(message = "O Nome do arquivo é obrigatório!")
        @Size(max = 255, message = "O nome do arquivo não pode ter mais de 255 caracteres!")
        String nomeArquivoStorage,

        @NotBlank(message = "O nome original é obrigatório!")
        @Size(max = 255, message = "O nome original não pode ter mais de 255 caracteres!")
        String nomeOriginal,

        @NotNull(message = "O tamanho do arquivo é obrigatório!")
        Long tamanhoBytes,

        @NotBlank(message = "A informação do tipo de conteúdo é obrigatória!")
        @Size(max = 100)
        String tipoConteudo,

        @NotNull(message = "Identificador da ordem de serviço não preenchido!")
        Long ordemServicoId

) {
}
