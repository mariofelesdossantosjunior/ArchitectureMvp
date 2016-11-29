package br.com.architecturemvp.Interactors;

import android.text.TextUtils;
import android.os.Handler;

import br.com.architecturemvp.Interfaces.LoginInteractor;
import br.com.architecturemvp.Interfaces.OnLoginFinishListener;

/**
 * @autor Mario Feles dos Santos Junior
 * @email mario_feles@live.com
 * @project ArchitectureMvp @data 28/11/16
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void validaUser(final String login, final String password, final OnLoginFinishListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(login)){
                    listener.onUserNameError();
                    error = true;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error = true;
                }
                if (!error){
                    listener.onSucess();
                }
            }
        }, 2000);
    }
}
