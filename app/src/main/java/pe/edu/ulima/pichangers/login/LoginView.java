package pe.edu.ulima.pichangers.login;

/**
 * Created by W3214 on 18/05/2016.
 */
public interface LoginView {
    public void setPresenter(LoginPresenter presenter);
    public void onLoginCorrecto();
    public void onLoginIncorrecto(String msg);
}