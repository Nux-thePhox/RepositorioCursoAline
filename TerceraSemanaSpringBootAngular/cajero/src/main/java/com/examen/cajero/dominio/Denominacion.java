package com.examen.cajero.dominio;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DENOMINACION")
public class Denominacion {

    @Id
    private int idDenominacion;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TIPO_MONEDA_ID")
    private TipoMoneda tipoMonedaId;
    private float valor;

    @OneToMany(mappedBy = "denominacionId", cascade = CascadeType.ALL)
    private List<Cantidad> fondos = new ArrayList<>();

    public Denominacion() {
    }

    public Denominacion(int idDenominacion, TipoMoneda tipoMonedaId, float valor) {
        this.idDenominacion = idDenominacion;
        this.tipoMonedaId = tipoMonedaId;
        this.valor = valor;
    }

    public int getIdDenominacion() {
        return idDenominacion;
    }

    public void setIdDenominacion(int idDenominacion) {
        this.idDenominacion = idDenominacion;
    }

    public TipoMoneda getTipoMonedaId() {
        return tipoMonedaId;
    }

    public void setTipoMonedaId(TipoMoneda tipoMonedaId) {
        this.tipoMonedaId = tipoMonedaId;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "\n Denominacion{" +
                "idDenominacion=" + idDenominacion +
                ", tipoMonedaId=" + tipoMonedaId +
                ", valor=" + valor +
                '}';
    }
}
