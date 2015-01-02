package es.uvigo.esei.dm1415.p04.whatsforlunch.Utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.Comida;

/**
 * Created by AliothAntonio on 01/01/2015.
 */
public class ReceiverComida extends BroadcastReceiver {
    public static final String NOMBRE ="VER_COMIDA";
    public static final int VER_COMIDA = 1;
    public static final int LISTAR_COMIDA = 2;
    public static final int LISTAR_TIPO_COMIDA =3;
    private Comida c;

    public ReceiverComida(Comida c) {
        c=this.c;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int operacion = intent.getIntExtra("operacion",-1);
        switch (operacion){
            case VER_COMIDA: verComida(intent);break;
            case LISTAR_COMIDA: break;
            case LISTAR_TIPO_COMIDA: break;
        }
    }

    private void verComida(Intent intent) {
        this.c=(Comida)intent.getSerializableExtra("comida");
    }
}
