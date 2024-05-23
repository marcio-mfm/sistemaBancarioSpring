package br.ada.caixa.service.cliente;

import br.ada.caixa.dto.request.RegistrarClientePJRequestDto;
import br.ada.caixa.entity.ClientePJ;
import br.ada.caixa.entity.ContaCorrente;
import br.ada.caixa.enums.StatusCliente;
import br.ada.caixa.respository.ClienteRespository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

@Service
public class ClientePJService {

    private final ClienteRespository clienteRespository;
    private final ModelMapper modelMapper;

    public ClientePJService(ClienteRespository clienteRespository, ModelMapper modelMapper) {
        this.clienteRespository = clienteRespository;
        this.modelMapper = modelMapper;
    }

    public void registrar(RegistrarClientePJRequestDto clienteDto) {
        ClientePJ cliente = modelMapper.map(clienteDto, ClientePJ.class);
        cliente.setStatus(StatusCliente.ATIVO);

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setCliente(cliente);
        contaCorrente.setSaldo(BigDecimal.ZERO);

        cliente.setContas(new ArrayList<>());
        cliente.getContas().add(contaCorrente);

        clienteRespository.save(cliente);
    }

}
