package pe.edu.ulima.pichangers.beans;

/**
 * Created by W3214 on 18/05/2016.
 */
public class AgregarIntegranteResponse {
    private String msg;

    public AgregarIntegranteResponse(){}
    public AgregarIntegranteResponse(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
