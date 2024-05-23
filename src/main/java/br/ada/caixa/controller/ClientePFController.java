package br.ada.caixa.controller;

import br.ada.caixa.dto.request.RegistrarClientePFRequestDto;
import br.ada.caixa.dto.response.ClientePFResponseDto;
import br.ada.caixa.enums.StatusCliente;
import br.ada.caixa.service.cliente.ClientePFService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes/pf")
public class ClientePFController {

    private final ClientePFService clientePFService;

    public ClientePFController(ClientePFService clientePFService) {
        this.clientePFService = clientePFService;
    }

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody RegistrarClientePFRequestDto clienteDto) {
        clientePFService.registrar(clienteDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/{cpf}/{status}")
    public ResponseEntity<?> atualizarStatus(@PathVariable String cpf,
                                             @PathVariable StatusCliente status) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<ClientePFResponseDto>> listarTodos() {
        return ResponseEntity.ok(clientePFService.listarTodos());
    }

}
