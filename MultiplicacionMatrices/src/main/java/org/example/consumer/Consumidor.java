package org.example.consumer;

import org.example.message.Mensaje;

public abstract class Consumidor {

    public abstract void procesarMensaje(Mensaje mensaje);

}
