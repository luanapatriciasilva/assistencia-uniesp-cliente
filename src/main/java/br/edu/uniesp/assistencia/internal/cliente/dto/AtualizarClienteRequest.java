package br.edu.uniesp.assistencia.internal.cliente.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record AtualizarClienteRequest(

        @NotNull
        String nome,

        @CPF
        String cpf,

        @Email
        String email

) {
}