package com.prototipo_danilo.tasks.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.prototipo_danilo.tasks.R;
import com.prototipo_danilo.tasks.infra.operation.OperationListener;
import com.prototipo_danilo.tasks.manager.PersonManager;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private Context mcontext;
    private PersonManager mPersonManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializa elementos
        this.mViewHolder.editEmail = (EditText) this.findViewById(R.id.edit_email);
        this.mViewHolder.editPassword = (EditText) this.findViewById(R.id.edit_password);
        this.mViewHolder.buttonLogin = (Button) this.findViewById(R.id.button_login);
        this.mViewHolder.textRegister = (TextView) this.findViewById(R.id.text_register);
        this.mViewHolder.txt_aviso = (TextView) this.findViewById(R.id.text_aviso);
        this.mPersonManager = new PersonManager(this);

        // Inicializa eventos
        this.mViewHolder.buttonLogin.setOnClickListener(this);
        this.mViewHolder.textRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_login) {

            if( ValidaLogin(this.mViewHolder.editEmail.getText().toString(), this.mViewHolder.editPassword.getText().toString()) ){
                startActivity(new Intent(this, MainActivity.class));
            }
            else{
                this.mViewHolder.txt_aviso.setVisibility(View.VISIBLE);
                this.mViewHolder.txt_aviso.setText("Login/Senha inválido");
            }

        } else if (id == R.id.text_register) {
            startActivity(new Intent(this, RegisterActivity.class));
        }
    }

    /**
     * ViewHolder
     */
    private static class ViewHolder {
        private EditText editEmail;
        private EditText editPassword;
        private Button buttonLogin;
        private TextView textRegister;
        private TextView txt_aviso;
    }

    private Boolean ValidaLogin(String email, String senha)  {
        Boolean retorno;

        if( email.contains("lamarca.danilo@gmail.com") ) { //força este login apenas como teste da api
            //chamada da API:
            this.mPersonManager.Create("Danilo",email,senha,registerListener());//criado o listener para receber o retorno
            retorno= true;
        }else{
            retorno= false;
        }
        return retorno;
    }

    private OperationListener registerListener(){
        return new OperationListener<Boolean>(){
            @Override
            public void OnSucess(Boolean result){

            }

            @Override
            public void OnError(int errorCode, String errorMessage){

            }
        };
    }

}
