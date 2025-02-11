package com.example.jamiltondamasceno.organizze.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jamiltondamasceno.organizze.R;
import com.example.jamiltondamasceno.organizze.activity.CadastroActivity;
import com.example.jamiltondamasceno.organizze.activity.LoginActivity;
import com.example.jamiltondamasceno.organizze.config.ConfiguracaoFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

public class MainActivity extends IntroActivity {

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        setButtonBackVisible(false);
        setButtonNextVisible(false);

        addSlide( new FragmentSlide.Builder()
                .background(R.color.colorBackground)
                .fragment(R.layout.intro_1)
                .build());

        addSlide( new FragmentSlide.Builder()
                .background(R.color.colorBackground)
                .fragment(R.layout.intro_2)
                .build());

        addSlide( new FragmentSlide.Builder()
                .background(R.color.colorBackground)
                .fragment(R.layout.intro_3)
                .build());

        addSlide( new FragmentSlide.Builder()
                .background(R.color.colorBackground)
                .fragment(R.layout.intro_4)
                .build());

        addSlide( new FragmentSlide.Builder()
                .background(R.color.colorBackground)
                .fragment(R.layout.intro_cadastro)
                .build());


    }

    @Override
    protected void onStart() {
        super.onStart();
        verificarUsuarioLogado();
    }

    public void btEntrar(View view){
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void btCadastrar(View view){
        startActivity(new Intent(this, CadastroActivity.class));
    }

    public void verificarUsuarioLogado(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        //autenticacao.signOut();
        if( autenticacao.getCurrentUser() != null ){
            abrirTelaPrincipal();
        }
    }

    public void abrirTelaPrincipal(){
        startActivity(new Intent(this, PrincipalActivity.class));
    }

}
