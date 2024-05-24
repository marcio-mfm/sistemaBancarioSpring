package br.ada.caixa.service.operacoesbancarias.transferencia;

import br.ada.caixa.entity.Conta;
import br.ada.caixa.respository.ContaRepository;
import br.ada.caixa.service.operacoesbancarias.deposito.DepositoService;
import br.ada.caixa.service.operacoesbancarias.saque.SaqueService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferenciaService {

    private static SaqueService saqueService;
    private static DepositoService depositoService;

    public static void transferir(Long numeroContaOrigem,
                                  Long numeroContaDestino,
                                  BigDecimal valor) {

        saqueService.sacar(numeroContaOrigem, valor);
        depositoService.depositar(numeroContaDestino, valor);

    }

}
