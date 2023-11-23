package hexagonal.viagens.dominio;

import java.util.Date;

public class ReservaDto {
    private String codigoVoo;
    private String classeAssento;
    private Date dataPartida;

    public ReservaDto() {
    }

    public ReservaDto(String codigoVoo, String classeAssento, Date dataPartida) {
        this.codigoVoo = codigoVoo;
        this.classeAssento = classeAssento;
        this.dataPartida = dataPartida;
    }

    public String getCodigoVoo() {
        return codigoVoo;
    }

    public void setCodigoVoo(String codigoVoo) {
        this.codigoVoo = codigoVoo;
    }

    public String getClasseAssento() {
        return classeAssento;
    }

    public void setClasseAssento(String classeAssento) {
        this.classeAssento = classeAssento;
    }

    public Date getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
    }
}
