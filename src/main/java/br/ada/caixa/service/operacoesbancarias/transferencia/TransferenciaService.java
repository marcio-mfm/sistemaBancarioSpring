package br.ada.caixa.service.operacoesbancarias.transferencia;

import br.ada.caixa.service.operacoesbancarias.deposito.DepositoService;
import br.ada.caixa.service.operacoesbancarias.saque.SaqueService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferenciaService {

    private SaqueService saqueService;
    private DepositoService depositoService;

    public void transferir(Long numeroContaOrigem,
                           Long numeroContaDestino,
                           BigDecimal valor) {

        saqueService.sacar(numeroContaDestino, valor);
        depositoService.depositar(numeroContaDestino, valor);

    }

}
