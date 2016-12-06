package persistencia;

import java.util.List;

public interface Datos {

    public String grabarEmp(String codEmp, String nomEmp, String apeEmp, String dirEmp, String dniEmp, String licCon, String telEmp, String seguroEmp, String emailEmp);

    public Empleado buscarEmp(String codEmp);

    public String actualizarEmp(String codEmp, String nomEmp, String apeEmp, String dirEmp, String dniEmp, String licCon, String telEmp, String seguroEmp, String emailEmp);

    public String grabarVeh(String codVeh, String NFlota, String matricuVeh, String modelVeh, String motorVeh, String serieVeh, String anioVeh, String estadVeh, String tipoVeh, double precVeh, String codEmp);

    public Vehiculo buscarVeh(String codVeh);

    public String actualizarVeh(String codVeh, String NFlota, String matricuVeh, String modelVeh, String motorVeh, String serieVeh, String anioVeh, String estadVeh, String tipoVeh, double precVeh, String codEmp);

    public String grabarRut(String codRut, String paradAut, double precRut);

    public Ruta buscarRut(String codRut);

    public String actualizarRut(String codRut, String paradAut, double precRut);

    public boolean grabarAlquiler(String numAlq, String fecAlq, String estadAlq, String codEmp, String codVeh, double tot, String hora, double desct);

    public String grabarDetalle(String numAlq, String codRut, String dia);
    
    public List listarEmp();
    
    public List listarRutas();
    
    public List listarVehiculos();
    
    public int getNumAlq();
}
