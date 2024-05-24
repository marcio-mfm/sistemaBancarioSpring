package br.ada.caixa.enums;

import java.math.BigDecimal;

public enum Classificacao {

        CPF("Pessoa Física", BigDecimal.valueOf(0.0), BigDecimal.valueOf(0.01)), CNPJ("Pessoa Jurídica", BigDecimal.valueOf(0.005), BigDecimal.valueOf(0.02));

        private final String descricao;
        private final BigDecimal taxaSaque;
        private final BigDecimal taxaInvestimento;

        Classificacao(String descricao, BigDecimal taxaSaque, BigDecimal taxaInvestimento){
                this.descricao = descricao;
                this.taxaSaque = taxaSaque;
                this.taxaInvestimento = taxaInvestimento;
        }

        public String getDescricao() {
                return descricao;
        }

        public BigDecimal getTaxaSaque() {
                return taxaSaque;
        }

        public BigDecimal getTaxaInvestimento() { return taxaInvestimento; }
}
