package com.lazaro.comprecoisas.mappers;

import com.lazaro.comprecoisas.model.Pagamento;
import com.lazaro.comprecoisas.model.dtos.PagamentoResponseDTO;

public class MapperPagamento {
    public static Pagamento toEntity(PagamentoResponseDTO pagamento) {
        Pagamento pagamentoRetorno = new Pagamento();
        pagamentoRetorno.setId(pagamento.getId());
        pagamentoRetorno.setValorTotal(pagamento.getValorTotal());
        pagamentoRetorno.setTipoPagamento(pagamento.getTipoPagamento());
        pagamentoRetorno.setDataPagamento(pagamento.getDataPagamento());
        pagamentoRetorno.setStatusPagamento(pagamento.getStatusPagamento());
        pagamentoRetorno.setIdTransacao(pagamento.getIdTransacao());
        return pagamentoRetorno;
    }
    public static PagamentoResponseDTO toDTO(Pagamento pagamento) {
        PagamentoResponseDTO pagamentoRetorno = new PagamentoResponseDTO();
        pagamentoRetorno.setId(pagamento.getId());
        pagamentoRetorno.setValorTotal(pagamento.getValorTotal());
        pagamentoRetorno.setTipoPagamento(pagamento.getTipoPagamento());
        pagamentoRetorno.setDataPagamento(pagamento.getDataPagamento());
        pagamentoRetorno.setStatusPagamento(pagamento.getStatusPagamento());
        pagamentoRetorno.setIdTransacao(pagamento.getIdTransacao());
        return pagamentoRetorno;
    }
}
