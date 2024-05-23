package br.ada.caixa.service.operacoesbancarias.saque;

import br.ada.caixa.entity.Conta;

import java.math.BigDecimal;

public interface OperacaoSaque {

    void êxecutar(Conta conta, BigDecimal valorSaque);

}
