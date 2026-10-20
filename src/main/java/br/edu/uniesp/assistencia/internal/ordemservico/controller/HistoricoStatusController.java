package br.edu.uniesp.assistencia.internal.ordemservico.controller;

import br.edu.uniesp.assistencia.internal.ordemservico.dto.CriarHistoricoStatusRequest;
import br.edu.uniesp.assistencia.internal.ordemservico.dto.CriarHistoricoStatusResponse;
import br.edu.uniesp.assistencia.internal.ordemservico.service.HistoricoStatusService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/historicosstatus")
@RequiredArgsConstructor
public class HistoricoStatusController {

    private final HistoricoStatusService historicoStatusService;

    @PostMapping
    public ResponseEntity<CriarHistoricoStatusResponse> abrir(@Valid @RequestBody CriarHistoricoStatusRequest request) {
        CriarHistoricoStatusResponse response = historicoStatusService.abrirHistoricoStatus(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
