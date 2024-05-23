package br.ada.caixa.controller;


import br.ada.caixa.dto.request.DepositoRequestDto;
import br.ada.caixa.dto.request.SaqueRequestDto;
import br.ada.caixa.dto.request.TransferenciaRequestDto;
import br.ada.caixa.dto.response.SaldoResponseDto;
import br.ada.caixa.service.operacoesbancarias.deposito.DepositoService;
import br.ada.caixa.service.operacoesbancarias.saldo.SaldoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operacoes")
public class OperacoesBancariasController {

    @PostMapping("/deposito")
    public void depositar(@RequestBody DepositoRequestDto depositoRequestDto) {

        DepositoService.depositar(Long.valueOf(depositoRequestDto.getNumeroConta()), depositoRequestDto.getValor());
    }

    @PostMapping("/saque")
    public void sacar(@RequestBody SaqueRequestDto saqueRequestDto) {
        System.out.println(saqueRequestDto);
    }

    @PostMapping("/transferencia")
    public void transferencia(@RequestBody TransferenciaRequestDto transferenciaRequestDto) {
        System.out.println(transferenciaRequestDto);
    }

    @GetMapping("/saldo/{numeroConta}")
    public ResponseEntity<SaldoResponseDto> consultarSaldo(@PathVariable String numeroConta) {
        System.out.println("numeroConta = " + numeroConta);

        SaldoResponseDto saldoResponseDto = new SaldoResponseDto();
        saldoResponseDto.setNumeroConta(numeroConta);
        saldoResponseDto.setSaldo(SaldoService.consultarSaldo(Long.valueOf(numeroConta)));

        return ResponseEntity.status(HttpStatus.OK).body(saldoResponseDto);
    }

    @PostMapping("/investimento")
    public void investir() {

    }

}
