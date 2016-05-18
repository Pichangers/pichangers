package pe.edu.ulima.pichangers.beans;

/**
 * Created by W3214 on 18/05/2016.
 */
public class AgregarIntegranteRequest {
    private int id;
    private String codigo;

    public AgregarIntegranteRequest(){}

    public AgregarIntegranteRequest(int id, String codigo) {
        this.id = id;
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
