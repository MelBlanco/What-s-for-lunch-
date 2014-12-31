package es.esei.uvigo.melalioth.whatsforlunch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.OnTabChangeListener;

public class MainWflActivity extends Activity{

	TabHost tabhost;
	EditText txtView;
	Button btn1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_wfl);
		
		tabhost = (TabHost) findViewById(R.id.tabMode);

		tabhost.setup();

		TabHost.TabSpec spec;

		//Es la capa con el boton de generar una comid aleatoria
		spec = tabhost.newTabSpec("generar");
		spec.setContent(R.id.comida_alea);
		spec.setIndicator("1-Alea",null);
		tabhost.addTab(spec);

		//Es la capa con el GripView para mostrar las fotos de los ingredientes
		spec = tabhost.newTabSpec("que");
		spec.setContent(R.id.que_comer);
		spec.setIndicator("2-Comer", null);
		tabhost.addTab(spec);
		
		
		spec = tabhost.newTabSpec("ver");
		spec.setContent(R.id.ver_super);
		spec.setIndicator("3-Super", null);
		tabhost.addTab(spec);

		tabhost.setCurrentTab(0); // tabhost.setCurrentTabByTag("generar");

		tabhost.setOnTabChangedListener(new OnTabChangeListener() {
			@Override
			public void onTabChanged(String tagId) {
				// do something useful with the selected screen
				String text = "Im currently in: " + tagId + "\nindex: " + tabhost.getCurrentTab();
				Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
			}
		});
		
		txtView = (EditText) findViewById(R.id.TextView1);
		
		btn1 = (Button) findViewById(R.id.button1);
		btn1.setOnClickListener( new OnClickListener() { 
			public void onClick(View v) {				
				if(v.getId()==findViewById(R.id.button1).getId()){
					String theUser = txtView.getText().toString();
					txtView.setText("Hola " + theUser);
				}//if
			}//onClick
		});//OnClickListener
	}//OnCreate
	
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_wfl, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}*/
}//MainWflActivity
