/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import persistencia.Empleado;
import persistencia.Ruta;
import persistencia.Vehiculo;

/**
 *
 * @author Miriam
 */
public interface Servicio {
        public String grabarEmp(String codEmp, String nomEmp, String apeEmp, String dirEmp, String dniEmp, String licCon, String telEmp, String seguroEmp, String emailEmp);
        public Empleado buscarEmp(String codEmp);
        public String actualizarEmp(String codEmp, String nomEmp, String apeEmp, String dirEmp, String dniEmp, String licCon, String telEmp, String seguroEmp, String emailEmp);
        
        public String grabarVeh(String codVeh,String matricuVeh, String modelVeh, String motorVeh, String serieVeh, String anioVeh, String estadVeh, String tipoVeh, double precVeh);
        public Vehiculo buscarVeh(String codVeh);
        public String actualizarVeh(String codVeh,String matricuVeh, String modelVeh, String motorVeh, String serieVeh, String anioVeh, String estadVeh, String tipoVeh, double precVeh);
        
        public String grabarRut(String codRut, String origRut, String destRut, String paradAut, double precRut);
        public Ruta buscarRut(String codRut);
        public String actualizarRut(String codRut, String origRut, String destRut, String paradAut, double precRut);
}
