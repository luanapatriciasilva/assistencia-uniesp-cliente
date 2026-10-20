package br.edu.uniesp.assistencia.internal.anexo.entity.dto;

import java.time.LocalDateTime;

public record AnexoResumoResponse(
        String caminho_storage,
        LocalDateTime data_upload,
        String nome_arquivo_storage,
        String nome_original,
        Long tamanho_bytes,
        String tipo_conteudo,
        Long ordem_servico_id
) {
}

