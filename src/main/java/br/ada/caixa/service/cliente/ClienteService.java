package br.ada.caixa.service.cliente;

import br.ada.caixa.dto.response.ClienteResponseDto;
import br.ada.caixa.entity.Cliente;
import br.ada.caixa.respository.ClienteRespository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRespository clienteRespository;
    private final ModelMapper modelMapper;

    public ClienteService(ClienteRespository clienteRespository, ModelMapper modelMapper) {
        this.clienteRespository = clienteRespository;
        this.modelMapper = modelMapper;
    }

    public List<ClienteResponseDto> listarTodos() {
        List<Cliente> clientes = clienteRespository.findAll();
        return clientes.stream().map(cliente -> {
            ClienteResponseDto clienteResponseDto = modelMapper.map(cliente, ClienteResponseDto.class);
            clienteResponseDto.setTipo(cliente.getTipo());
            return clienteResponseDto;
        }).collect(Collectors.toList());
    }

}
