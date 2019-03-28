package com.prototipo_danilo.tasks.views;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.prototipo_danilo.tasks.R;
import com.prototipo_danilo.tasks.infra.SecurityPreferences;

public class TaskFormActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_form);

        // Inicializa variáveis
        this.mViewHolder.editDescription = (EditText) this.findViewById(R.id.edit_description);
        this.mViewHolder.checkComplete = (CheckBox) this.findViewById(R.id.check_complete);
        this.mViewHolder.spinnerPriority = (Spinner) this.findViewById(R.id.spinner_priority);
        this.mViewHolder.buttonDate = (Button) this.findViewById(R.id.button_date);
        this.mViewHolder.buttonSave = (Button) this.findViewById(R.id.button_save);
        this.mViewHolder.progressDialog = new ProgressDialog(this);

        // Atribui eventos
        this.mViewHolder.buttonSave.setOnClickListener(this);
        this.mViewHolder.buttonDate.setOnClickListener(this);

        //consulta API no sharedPreferences, e atribui valor apenas como teste da integracao da API
        SecurityPreferences securityPreferences = new SecurityPreferences(getApplicationContext());
        String titulo = securityPreferences.getStoredString("titulo");
        this.mViewHolder.editDescription.setText(titulo);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.button_save) {
            // TODO
        } else if (id == R.id.button_date) {
            // TODO
        }
    }

    /**
     * ViewHolder
     */
    private static class ViewHolder {
        private EditText editDescription;
        private CheckBox checkComplete;
        private Spinner spinnerPriority;
        private Button buttonDate;
        private Button buttonSave;
        private ProgressDialog progressDialog;
    }
}
