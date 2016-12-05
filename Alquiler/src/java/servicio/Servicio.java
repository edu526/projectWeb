/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import negocio.AlquilerObj;

/**
 *
 * @author edd
 */
public interface Servicio {
    public AlquilerObj nuevoAlquiler();
    public String grabar();
    public void agregarVeh(String cod);
    public void agregarRut(String cod);
}
