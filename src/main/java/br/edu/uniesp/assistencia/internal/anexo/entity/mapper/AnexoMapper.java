package br.edu.uniesp.assistencia.internal.anexo.entity.mapper;

import br.edu.uniesp.assistencia.internal.anexo.entity.AnexoEntity;
import br.edu.uniesp.assistencia.internal.anexo.entity.dto.AnexoResumoResponse;
import br.edu.uniesp.assistencia.internal.anexo.entity.dto.CriarAnexoRequest;
import br.edu.uniesp.assistencia.internal.anexo.entity.dto.CriarAnexoResponse;
import br.edu.uniesp.assistencia.internal.ordemservico.entity.OrdemServicoEntity;

public final class AnexoMapper {

    private AnexoMapper() {
    }

    public static AnexoEntity converteParaEntidade(CriarAnexoRequest request, OrdemServicoEntity ordemServico) {
        return new AnexoEntity(
                ordemServico,
                request.nomeOriginal(),
                request.nomeArquivoStorage(),
                request.tipoConteudo(),
                request.tamanhoBytes(),
                request.caminhoStorage()
        );
    }

    public static CriarAnexoResponse converterParaResposta(AnexoEntity anexo) {
        return new CriarAnexoResponse(
                anexo.getCaminhoStorage(),
                anexo.getDataUpload(),
                anexo.getNomeArquivoStorage(),
                anexo.getNomeOriginal(),
                anexo.getTamanhoBytes(),
                anexo.getTipoConteudo(),
                anexo.getId()
        );
    }

    public static AnexoResumoResponse paraResumoResposta(
            AnexoEntity anexo) {
        return new AnexoResumoResponse(
                anexo.getCaminhoStorage(),
                anexo.getDataUpload(),
                anexo.getNomeArquivoStorage(),
                anexo.getNomeOriginal(),
                anexo.getTamanhoBytes(),
                anexo.getTipoConteudo(),
                anexo.getId()
        );
    }

}
