package com.lazaro.comprecoisas.infra.utils;

import com.lazaro.comprecoisas.model.Entrega;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

public class EntregaGenerator {
    private static final String[] PREFIXOS = {"LB", "AA", "PQ", "CA", "SE", "CD", "NX"};
    private static final String SUFIXO = "BR";

    private static String gerarCodigoRastreio() {
        Random random = new Random();
        String prefixo = PREFIXOS[random.nextInt(PREFIXOS.length)];

        StringBuilder numeros = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            numeros.append(random.nextInt(10));
        }

        return prefixo + numeros + SUFIXO;
    }
    public static Entrega gerarEntrega(Entrega entrega) {
        Random r = new Random();
        entrega.setPrevisaoEntrega(LocalDate.now().plusDays(r.nextInt(10, 31)));
        entrega.setFrete(BigDecimal.valueOf(r.nextInt(0, 51)));
        entrega.setIdRastreamento(gerarCodigoRastreio());
        return entrega;
    }
}
