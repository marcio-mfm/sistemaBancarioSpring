package br.ada.caixa.dto.request;

import br.ada.caixa.enums.Classificacao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrarClientePJRequestDto {

    private String cnpj;
    private String nomeFantasia;
    private String razaoSocial;
    private Classificacao classificacao = Classificacao.CNPJ;

}
