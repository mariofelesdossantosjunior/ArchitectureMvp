package br.com.architecturemvp.Interfaces;

/**
 * @autor Mario Feles dos Santos Junior
 * @email mario_feles@live.com
 * @project ArchitectureMvp @data 29/11/16
 */

public interface OnLoginFinishListener {
    void onUserNameError();
    void onPasswordError();
    void onSucess();
}
