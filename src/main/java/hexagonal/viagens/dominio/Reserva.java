package hexagonal.viagens.dominio;

import java.util.Date;

public class Reserva {
    private Long id;
    private String codigoVoo;
    private String classeAssento;
    private Date dataPartida;

    public Reserva() {
    }

    public Reserva(Long id, String codigoVoo, String classeAssento, Date dataPartida) {
        this.id = id;
        this.codigoVoo = codigoVoo;
        this.classeAssento = classeAssento;
        this.dataPartida = dataPartida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
