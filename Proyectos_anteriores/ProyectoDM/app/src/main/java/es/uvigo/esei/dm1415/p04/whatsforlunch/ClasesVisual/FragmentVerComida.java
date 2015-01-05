package es.uvigo.esei.dm1415.p04.whatsforlunch.ClasesVisual;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import es.uvigo.esei.dm1415.p04.whatsforlunch.Adapter.AdapterComida;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Adapter.AdapterIngrediente;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Database.DataBaseHelper;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.Comida;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.Ingrediente;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.Receta;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Modelo.RecetaIngrediente;
import es.uvigo.esei.dm1415.p04.whatsforlunch.R;
import es.uvigo.esei.dm1415.p04.whatsforlunch.Utils.Utils;


public class FragmentVerComida extends Fragment {
    private Comida comida;
    private TextView nombrecomida;
    private ImageView fotocomida;
    private ListView listaingredientes;
    private TextView receta;
    SQLiteDatabase db;
    DataBaseHelper helper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview =inflater.inflate(R.layout.fragment_ver_comida,container,false);
        helper=new DataBaseHelper(rootview.getContext());
        comida=(Comida)getArguments().getSerializable("comida");
        db=helper.getWritableDatabase();
        inicializarComponente(rootview);
        return rootview;

    }

    @Override
    public void onPause() {
        super.onPause();
        Bundle b=new Bundle();
        int btnActual=-1;
        b.putInt("btnActual",-1);
        b.putSerializable("comida",comida);
        getActivity().getIntent().putExtras(b);
    }

    public static FragmentVerComida newInstance(Comida comida){
        FragmentVerComida f=new FragmentVerComida();
        if(comida!=null){
            Bundle b=new Bundle();
            b.putSerializable("comida",comida);
            f.setArguments(b);
        }
        return f;
    }

    public FragmentVerComida() {

    }

    private void setComida(Comida comida) {
        this.comida = comida;
    }

    private void inicializarComponente(View rootview) {
        nombrecomida=(TextView)rootview.findViewById(R.id.textViewNombreComida);
        nombrecomida.setText(comida.getNombre());
        fotocomida=(ImageView)rootview.findViewById(R.id.imageViewComida);
        fotocomida.setImageDrawable(getActivity().getResources().getDrawable(comida.getFoto()));
        listaingredientes=(ListView)rootview.findViewById(R.id.listView2);

        String id_receta= ""+comida.getReceta().getIdReceta();
        Cursor c= helper.ListarIngredientesDeUnaComida(db,id_receta);
        ArrayList<RecetaIngrediente> arraydir = Utils.convertirCursor2ArrayIngrediente(c, helper, db);
        AdapterIngrediente adapter = new AdapterIngrediente(getActivity(), arraydir);
        listaingredientes.setAdapter(adapter);
        listaingredientes.setScrollContainer(false);
        receta=(TextView)rootview.findViewById(R.id.editText);
        //receta.setMovementMethod(new ScrollingMovementMethod());
        receta.setText(comida.getReceta().getDescripcionReceta());
    }

}
