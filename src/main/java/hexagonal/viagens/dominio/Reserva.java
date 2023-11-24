package hexagonal.viagens.dominio;

public class Reserva {
    private int id;
    private String codigoVoo;
    private String classeAssento;
    private String dataPartida;

    public Reserva() {
    }

    public Reserva(int id, String codigoVoo, String classeAssento, String dataPartida) {
        this.id = id;
        this.codigoVoo = codigoVoo;
        this.classeAssento = classeAssento;
        this.dataPartida = dataPartida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(String dataPartida) {
        this.dataPartida = dataPartida;
    }
}
