package br.com.projetoapp.sharepages.gui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import br.com.projetoapp.sharepages.R;


public class TelaInicial extends Activity implements View.OnClickListener {

    private static final String CATEGORIA = "Script";

    EditText textoUsuario;
    EditText textoSenha;
    Button botaoEntrar;
    TextView botaoFazerCadastro;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        Log.i(CATEGORIA, getLocalClassName() + ".onCreate();");

        textoUsuario = (EditText) findViewById(R.id.textoUsuario);
        textoSenha = (EditText) findViewById(R.id.textoSenha);
        botaoEntrar = (Button) findViewById(R.id.botaoEntrar);
        botaoFazerCadastro = (TextView) findViewById(R.id.botaoFazerCadastro);

       /// botaoEntrar.setOnClickListener(this);
        botaoFazerCadastro.setOnClickListener(this);

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textoUsuario.getText().length() == 0 ||textoSenha.getText().length()==0){
                    Toast.makeText(getApplication(),"Campos Obrigatorios",Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(getApplication(),"Bem-vindo ao SharePages",Toast.LENGTH_LONG).show();
                }

            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.botaoEntrar:


                break;

            case R.id.botaoFazerCadastro:

                Intent intent = new Intent(this, CadastroUsuario.class);
                startActivity(intent);

                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "TelaInicial Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://br.com.projetoapp.sharepages.gui/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "TelaInicial Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://br.com.projetoapp.sharepages.gui/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    //   chamando a tela de cadastro

//    public void ChamarCadastro(View view){
//
//        Intent intent = new Intent(this, CadastroUsuario.class);
//        startActivity(intent);
//
//        Log.i(CATEGORIA, getLocalClassName()+".cadastroChamado");
//    }


}