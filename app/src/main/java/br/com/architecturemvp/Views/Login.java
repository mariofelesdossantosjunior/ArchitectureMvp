package br.com.architecturemvp.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import br.com.architecturemvp.Interfaces.LoginPresenter;
import br.com.architecturemvp.Interfaces.LoginView;
import br.com.architecturemvp.Presenters.LoginPresenterImpl;
import br.com.architecturemvp.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends AppCompatActivity implements LoginView {

    @BindView(R.id.etLogin)
    EditText etLogin;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.btLogin)
    Button btLogin;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenterImpl(this);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setErrorUser() {
        etLogin.setError("Campo Obrigatório");
    }

    @Override
    public void setErrorPassword() {
        etPassword.setError("Campo Obrigatório");
    }

    @Override
    public void setNavigateHome() {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();
    }

    @OnClick(R.id.btLogin)
    public void validacion() {
        presenter.validaUser(etLogin.getText().toString(),etPassword.getText().toString());
    }
}
