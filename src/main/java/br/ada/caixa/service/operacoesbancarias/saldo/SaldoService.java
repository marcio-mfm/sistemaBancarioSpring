package br.ada.caixa.service.operacoesbancarias.saldo;

import br.ada.caixa.entity.Conta;
import br.ada.caixa.exceptions.ValidacaoException;
import br.ada.caixa.respository.ContaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SaldoService {

    private static ContaRepository contaRepository;

    public SaldoService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public static BigDecimal consultarSaldo(Long numeroConta) {
        return contaRepository.findById(numeroConta)
                .map(Conta::getSaldo)
                .orElseThrow(() -> new ValidacaoException("Conta inexistente!"));
    }

}
