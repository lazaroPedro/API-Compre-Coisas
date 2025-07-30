package com.lazaro.comprecoisas.mappers;

import com.lazaro.comprecoisas.model.Pagamento;
import com.lazaro.comprecoisas.model.dtos.PagamentoDTO;

public class MapperPagamento {
    public static Pagamento toEntity(PagamentoDTO pagamento) {
        Pagamento pagamentoRetorno = new Pagamento();
        pagamentoRetorno.setId(pagamento.getId());
        pagamentoRetorno.setValorTotal(pagamento.getValorTotal());
        pagamentoRetorno.setTipoPagamento(pagamento.getTipoPagamento());
        pagamentoRetorno.setDataPagamento(pagamento.getDataPagamento());
        pagamentoRetorno.setStatusPagamento(pagamento.getStatusPagamento());
        pagamentoRetorno.setIdTransacao(pagamento.getIdTransacao());
        return pagamentoRetorno;
    }
    public static PagamentoDTO toDTO(Pagamento pagamento) {
        PagamentoDTO pagamentoRetorno = new PagamentoDTO();
        pagamentoRetorno.setId(pagamento.getId());
        pagamentoRetorno.setValorTotal(pagamento.getValorTotal());
        pagamentoRetorno.setTipoPagamento(pagamento.getTipoPagamento());
        pagamentoRetorno.setDataPagamento(pagamento.getDataPagamento());
        pagamentoRetorno.setStatusPagamento(pagamento.getStatusPagamento());
        pagamentoRetorno.setIdTransacao(pagamento.getIdTransacao());
        return pagamentoRetorno;
    }
}
