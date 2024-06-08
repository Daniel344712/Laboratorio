package model;

import java.util.Date;

public class PedidoModel {
    private int id;
    private int idUsuario;
    private Date fecha;
    private double total;
    private int idSede;

    public PedidoModel(int idUsuario, Date fecha, double total, int idSede) {
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.total = total;
        this.idSede = idSede;
    }

    public PedidoModel(int id) {
        this.id = id;
    }
    public PedidoModel(int id, int idUsuario, Date fecha, double total, int idSede) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.total = total;
        this.idSede = idSede;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public java.sql.Date getFecha() {
        return (java.sql.Date) fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }
}
