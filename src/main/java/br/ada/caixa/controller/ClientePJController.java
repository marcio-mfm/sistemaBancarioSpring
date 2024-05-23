package br.ada.caixa.controller;

import br.ada.caixa.dto.request.RegistrarClientePJRequestDto;
import br.ada.caixa.service.cliente.ClientePJService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes/pj")
public class ClientePJController {

    private final ClientePJService clientePJService;

    public ClientePJController(ClientePJService clientePJService) {
        this.clientePJService = clientePJService;
    }

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody RegistrarClientePJRequestDto clienteDto) {
        clientePJService.registrar(clienteDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
