package br.ada.caixa.service.operacoesbancarias.saque;

import br.ada.caixa.entity.Conta;
import br.ada.caixa.exceptions.ValidacaoException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Order(1)
@Service
public class OperacaoSaqueSaldoPF implements OperacaoSaque {

    @Override
    public void êxecutar(Conta conta, BigDecimal valorSaque) {
        if (valorSaque.compareTo(conta.getSaldo()) > 0) {
            throw new ValidacaoException("Saldo insuficiente!");
        }
    }

}
