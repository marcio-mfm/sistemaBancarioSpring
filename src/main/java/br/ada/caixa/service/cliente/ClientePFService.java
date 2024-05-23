package br.ada.caixa.service.cliente;

import br.ada.caixa.dto.request.RegistrarClientePFRequestDto;
import br.ada.caixa.dto.response.ClientePFResponseDto;
import br.ada.caixa.entity.ClientePF;
import br.ada.caixa.entity.ContaCorrente;
import br.ada.caixa.enums.StatusCliente;
import br.ada.caixa.respository.ClienteRespository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientePFService {

    private final ClienteRespository clienteRespository;
    private final ModelMapper modelMapper;

    public ClientePFService(ClienteRespository clienteRespository, ModelMapper modelMapper) {
        this.clienteRespository = clienteRespository;
        this.modelMapper = modelMapper;
    }

    public void registrar(RegistrarClientePFRequestDto clienteDto) {
        ClientePF cliente = modelMapper.map(clienteDto, ClientePF.class);
        cliente.setStatus(StatusCliente.ATIVO);

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setCliente(cliente);
        contaCorrente.setSaldo(BigDecimal.ZERO);

        cliente.setContas(new ArrayList<>());
        cliente.getContas().add(contaCorrente);

        clienteRespository.save(cliente);
    }

    public List<ClientePFResponseDto> listarTodos() {
        List<ClientePF> clientes = clienteRespository.findAllPF();
        return clientes.stream()
                .map(clientePF -> modelMapper.map(clientePF, ClientePFResponseDto.class))
                .collect(Collectors.toList());
    }

}
