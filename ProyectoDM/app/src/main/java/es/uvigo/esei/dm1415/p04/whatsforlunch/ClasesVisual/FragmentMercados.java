package es.uvigo.esei.dm1415.p04.whatsforlunch.ClasesVisual;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.uvigo.esei.dm1415.p04.whatsforlunch.R;


public class FragmentMercados extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_mercados, container, false);
        inicializarComponenter(rootview);
        return rootview;
    }

    private void inicializarComponenter(final View rootview) {

    }
}