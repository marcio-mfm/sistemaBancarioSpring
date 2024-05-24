package br.ada.caixa.service.operacoesbancarias.saque;


import br.ada.caixa.exceptions.ValidacaoException;
import br.ada.caixa.respository.ContaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SaqueService {

    private static ContaRepository contaRepository;
    private static List<OperacaoSaqueSaldo> operacaoSaqueList;

    public SaqueService(ContaRepository contaRepository, List<OperacaoSaqueSaldo> operacaoSaqueList) {
        this.contaRepository = contaRepository;
        this.operacaoSaqueList = operacaoSaqueList;
    }
    public static void sacar(Long numeroConta, BigDecimal valor) {
        contaRepository.findById(numeroConta)
                        .ifPresent(conta -> {operacaoSaqueList.forEach(operacaoSaque -> operacaoSaque.executar(conta, valor));
                                contaRepository.save(conta);
                        } );


    }

}
