package org.example.producer;

import org.example.channel.Canal;
import org.example.message.Mensaje;

public abstract class Productor {

    private Canal canal;

    public Productor(Canal canal){
        this.canal = canal;
    }

    public void publicar(Mensaje mensaje){
        canal.pasarMensaje(mensaje);
    }

}
