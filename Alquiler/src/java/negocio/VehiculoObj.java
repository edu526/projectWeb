package negocio;

public class VehiculoObj {
    
    private String codVeh, NFlota, matricuVeh, modelVeh, motorVeh, serieVeh, anioVeh, estadVeh, tipoVeh;
    private double precVeh;
    private EmpleadoObj codEmp;

    public VehiculoObj() {
        this.codVeh = " ";
        this.NFlota = " ";
        this.matricuVeh = " ";
        this.modelVeh = " ";
        this.motorVeh = " ";
        this.serieVeh = " ";
        this.anioVeh = " ";
        this.estadVeh = " ";
        this.tipoVeh = " ";
        this.precVeh = 0.00;
        this.codEmp = new EmpleadoObj();
    }

    public String getCodVeh() {
        return codVeh;
    }

    public void setCodVeh(String codVeh) {
        this.codVeh = codVeh;
    }

    public String getNFlota() {
        return NFlota;
    }

    public void setNFlota(String NFlota) {
        this.NFlota = NFlota;
    }

    public String getMatricuVeh() {
        return matricuVeh;
    }

    public void setMatricuVeh(String matricuVeh) {
        this.matricuVeh = matricuVeh;
    }

    public String getModelVeh() {
        return modelVeh;
    }

    public void setModelVeh(String modelVeh) {
        this.modelVeh = modelVeh;
    }

    public String getMotorVeh() {
        return motorVeh;
    }

    public void setMotorVeh(String motorVeh) {
        this.motorVeh = motorVeh;
    }

    public String getSerieVeh() {
        return serieVeh;
    }

    public void setSerieVeh(String serieVeh) {
        this.serieVeh = serieVeh;
    }

    public String getAnioVeh() {
        return anioVeh;
    }

    public void setAnioVeh(String anioVeh) {
        this.anioVeh = anioVeh;
    }

    public String getEstadVeh() {
        return estadVeh;
    }

    public void setEstadVeh(String estadVeh) {
        this.estadVeh = estadVeh;
    }

    public String getTipoVeh() {
        return tipoVeh;
    }

    public void setTipoVeh(String tipoVeh) {
        this.tipoVeh = tipoVeh;
    }

    public EmpleadoObj getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(EmpleadoObj codEmp) {
        this.codEmp = codEmp;
    }

    
    
    public double getPrecVeh() {
        return precVeh;
    }

    public void setPrecVeh(double precVeh) {
        this.precVeh = precVeh;
    }
    
}
