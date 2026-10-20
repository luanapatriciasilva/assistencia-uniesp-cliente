package br.edu.uniesp.assistencia.internal.equipamento.controller;

import br.edu.uniesp.assistencia.internal.equipamento.dto.AtualizarEquipamentoRequest;
import br.edu.uniesp.assistencia.internal.equipamento.dto.CriarEquipamentoRequest;
import br.edu.uniesp.assistencia.internal.equipamento.dto.CriarEquipamentoResponse;
import br.edu.uniesp.assistencia.internal.equipamento.dto.EquipamentoResumoResponse;
import br.edu.uniesp.assistencia.internal.equipamento.service.EquipamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("equipamentos")
@RequiredArgsConstructor
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    @PostMapping
    public ResponseEntity<CriarEquipamentoResponse> criar(@Valid @RequestBody CriarEquipamentoRequest request) {
        CriarEquipamentoResponse response = equipamentoService.criarEquipamento(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipamentoResumoResponse> buscarPorId(@PathVariable Long id) {
        EquipamentoResumoResponse response = equipamentoService.buscarEquipamentoPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<EquipamentoResumoResponse>> listarTodos(Pageable pageable) {
        Page<EquipamentoResumoResponse> page = equipamentoService.listarTodos(pageable);
        return ResponseEntity.ok(page);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EquipamentoResumoResponse> atualizar(@PathVariable Long id, @Valid @RequestBody AtualizarEquipamentoRequest request) {
        EquipamentoResumoResponse response = equipamentoService.atualizarEquipamento(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        equipamentoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
