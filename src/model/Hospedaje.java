package model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import exceptions.*;

public class Hospedaje extends Servicio {

    private String hospedaje;
    private double precioPorNoche;

    public Hospedaje(String hospedaje, double precioPorNoche, String codServicio, double porcentajeDescuento, boolean enPromocion) throws codServicioDiferenteASeisException {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;

        if (codServicio.length() != 6) {
            throw new codServicioDiferenteASeisException("El codigo del servicio debe tener 6 caracteres");
        }
    }

    public String getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(String hospedaje) {
        this.hospedaje = hospedaje;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public String getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(String codServicio) {
        this.codServicio = codServicio;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }

    public void setEnPromocion(boolean enPromocion) {
        this.enPromocion = enPromocion;
    }

    @Override
    public String toString() {
        return "Hospedaje{" + "hospedaje=" + hospedaje + ", precioPorNoche=" + precioPorNoche + '}';
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = precioPorNoche; 
        if (isEnPromocion()) {
            DayOfWeek diaSemana = dia.getDayOfWeek();
            if (diaSemana != DayOfWeek.SATURDAY && diaSemana != DayOfWeek.SUNDAY) {         
                double descuento = precioPorNoche * porcentajeDescuento; 
                precioFinal -= descuento; 
            }
        }
        return precioFinal;
    }

}
