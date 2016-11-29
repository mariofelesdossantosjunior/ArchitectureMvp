package br.com.architecturemvp.Presenters;

import br.com.architecturemvp.Interactors.LoginInteractorImpl;
import br.com.architecturemvp.Interfaces.LoginInteractor;
import br.com.architecturemvp.Interfaces.LoginPresenter;
import br.com.architecturemvp.Interfaces.LoginView;
import br.com.architecturemvp.Interfaces.OnLoginFinishListener;

/**
 * @autor Mario Feles dos Santos Junior
 * @email mario_feles@live.com
 * @project ArchitectureMvp @data 28/11/16
 */

public class LoginPresenterImpl implements LoginPresenter,OnLoginFinishListener{
    private LoginView view;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        interactor = new LoginInteractorImpl();
    }

    @Override
    public void validaUser(String login, String password) {
        if(view != null)  {
            view.showProgress();
        }
        interactor.validaUser(login,password,this);
    }

    @Override
    public void onUserNameError() {
        if(view != null)  {
            view.hideProgress();
            view.setErrorUser();
        }
    }

    @Override
    public void onPasswordError() {
        if(view != null) {
            view.hideProgress();
            view.setErrorPassword();
        }

    }

    @Override
    public void onSucess() {
        if(view != null) {
            view.hideProgress();
            view.setNavigateHome();
        }
    }
}
