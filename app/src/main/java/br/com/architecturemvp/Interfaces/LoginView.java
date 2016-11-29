package br.com.architecturemvp.Interfaces;

/**
 * @autor Mario Feles dos Santos Junior
 * @email mario_feles@live.com
 * @project ArchitectureMvp @data 28/11/16
 */

public interface LoginView {
    void showProgress();
    void hideProgress();
    void setErrorUser();
    void setErrorPassword();
    void setNavigateHome();

}
