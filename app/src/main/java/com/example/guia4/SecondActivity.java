package com.example.guia4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.inmite.android.lib.validations.form.FormValidator;
import eu.inmite.android.lib.validations.form.annotations.MinLength;
import eu.inmite.android.lib.validations.form.annotations.MinValue;
import eu.inmite.android.lib.validations.form.annotations.NotEmpty;
import eu.inmite.android.lib.validations.form.callback.SimpleErrorPopupCallback;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.edtNombre)
    @NotEmpty(messageId = R.string.ValidarNombre, order = 1)
    EditText edtNombre;

    @BindView(R.id.edtTel)
    @NotEmpty(messageId =R.string.ValidarTelefono, order = 2)
    @MinLength(value = 8, messageId = R.string.Tamanio,order=3)
    EditText edtTel;

    @BindView(R.id.edtOrg)
    @NotEmpty(messageId =R.string.ValidarOrganizacion, order = 4)
    EditText edtOrg;

    @BindView(R.id.btnGuardar)
    Button btnGuardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        btnGuardar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnGuardar:{
                if(FormValidator.validate(this, new SimpleErrorPopupCallback(this))){
                    Toast.makeText(this, "Hola", Toast.LENGTH_LONG).show();
                }
            }
                break;
        }
    }
}
