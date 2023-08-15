package com.chaqui.sysres.misc;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EstadosComanda {

    public static final Integer ABIERTA = 1;
    public static final Integer CANCELADA = 2;
    public static final Integer PAGADA = 3;
}
