package sistema;

import java.time.DayOfWeek;
import exceptions.*;
import java.time.LocalDate;
import model.*;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private List<Servicio> lstServicio;

    public Sistema() {
        this.lstServicio = new ArrayList<>();
    }

    public List<Servicio> getLstServicio() {
        return lstServicio;
    }

    public void setLstServicio(List<Servicio> lstServicio) {
        this.lstServicio = lstServicio;
    }

    public Servicio traerServicio(String codServicio) {
        Servicio retorna = null;

        for (Servicio servicio : this.lstServicio) {
            if (codServicio.equals(servicio.getCodServicio())) {
                retorna = servicio;
            }
        }
        return retorna;
    }

    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> lstPromocion = new ArrayList<>();

        for (Servicio servicio : this.lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                if (servicio instanceof Gastronomia gastronomia) {
                    lstPromocion.add(gastronomia); 
                }
                else if (servicio instanceof Hospedaje hospedaje) {
                    lstPromocion.add(hospedaje); 
                }
            }
        }
        return lstPromocion;
    }

    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
    List<Servicio> lstPromocionDia = new ArrayList<>();

    for (Servicio servicio : this.lstServicio) {
        if (servicio.isEnPromocion() == enPromocion) {
            if (servicio instanceof Gastronomia) {
                lstPromocionDia.add(servicio);
            } 
            else if (servicio instanceof Hospedaje) {
                int diaSemana = dia.getDayOfWeek().getValue();
                if (diaSemana != 6 && diaSemana != 7) {
                    lstPromocionDia.add(servicio); 
                }
            }
        }
    }

    return lstPromocionDia;
    }
    
    public boolean agregarGastronomia(String codSrvicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws ServicioYaExistenteException {
        for (Servicio servicio : this.lstServicio){
            if (servicio.getCodServicio().equals(codServicio)){
            throw new ServicioYaExistenteException("El servicio con el codigo "+ codServicio + "ya existe");
            }
        }
        Gastronomia nuevoServicio = new Gastronomia 
    }
  
}
