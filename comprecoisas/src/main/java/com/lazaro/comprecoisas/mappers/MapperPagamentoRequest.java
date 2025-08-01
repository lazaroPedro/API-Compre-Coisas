package com.lazaro.comprecoisas.mappers;

import com.lazaro.comprecoisas.model.Pagamento;
import com.lazaro.comprecoisas.model.dtos.PagamentoRequestDTO;

public class MapperPagamentoRequest {
    public static Pagamento toEntity(PagamentoRequestDTO pagamento) {
        Pagamento pagamentoRetorno = new Pagamento();
        pagamentoRetorno.setTipoPagamento(pagamento.getTipoPagamento());

        return pagamentoRetorno;
    }
    public static PagamentoRequestDTO toDTO(Pagamento pagamento) {
        PagamentoRequestDTO pagamentoRetorno = new PagamentoRequestDTO();
        pagamentoRetorno.setTipoPagamento(pagamento.getTipoPagamento());

        return pagamentoRetorno;
    }
}
