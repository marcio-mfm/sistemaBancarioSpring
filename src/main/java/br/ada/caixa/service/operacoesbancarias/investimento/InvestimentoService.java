package br.ada.caixa.service.operacoesbancarias.investimento;

import br.ada.caixa.respository.ContaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class InvestimentoService {

    private final ContaRepository contaRepository;

    public InvestimentoService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public void investir(Long numeroConta, BigDecimal valor) {
//        var conta = contaRepository.findById(numeroConta)
//                .filter(conta -> (conta instanceof ContaInvestimento));
//        if ()

    }

}
