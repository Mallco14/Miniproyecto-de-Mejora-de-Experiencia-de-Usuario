package hunt.software.gestionradios.Model;

public class Radios {
    private int id;
    private String num_serie;
    private String indicativo_mtc;
    private String estado_mtc;
    private String reportado_mtc;
    private String fecha_mantenimiento;
    private String representante_hunt;
    private String representante_contrc;
    private String departamento;
    private String marca;
    private String modelo;
    private String condicion;
    private String estado;
    private String comentarios;
    private String ubicacion;

    public Radios() {

    }


    @Override
    public String toString() {
        return "Radios{" +
                "id=" + id +
                ", num_serie='" + num_serie + '\'' +
                ", indicativo_mtc='" + indicativo_mtc + '\'' +
                ", estado_mtc='" + estado_mtc + '\'' +
                ", reportado_mtc='" + reportado_mtc + '\'' +
                ", fecha_mantenimiento='" + fecha_mantenimiento + '\'' +
                ", representante_hunt='" + representante_hunt + '\'' +
                ", representante_contrc='" + representante_contrc + '\'' +
                ", departamento='" + departamento + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", condicion='" + condicion + '\'' +
                ", estado='" + estado + '\'' +
                ", comentarios='" + comentarios + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }


    public Radios(String num_serie, String report_mtc, String departamento, String fecha_manten, String indicativo_mtc, String rhunt, String r_contratista, String modelo, String marca, String condicion, String estado, String ubicacion, String comentario, String estado_mtc){
        this.num_serie = num_serie;
        this.reportado_mtc = report_mtc;
        this.departamento = departamento;
        this.fecha_mantenimiento = fecha_manten;
        this.indicativo_mtc = indicativo_mtc;
        this.representante_hunt = rhunt;
        this.representante_contrc = r_contratista;
        this.modelo = modelo;
        this.marca = marca;
        this.condicion = condicion;
        this.estado = estado;
        this.ubicacion = ubicacion;
        this.comentarios = comentario;
        this.estado_mtc = estado_mtc;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNum_serie() {
        return num_serie;
    }


    public void setNum_serie(String num_serie) {
        this.num_serie = num_serie;
    }


    public String getIndicativo_mtc() {
        return indicativo_mtc;
    }


    public void setIndicativo_mtc(String indicativo_mtc) {
        this.indicativo_mtc = indicativo_mtc;
    }


    public String getEstado_mtc() {
        return estado_mtc;
    }


    public void setEstado_mtc(String estado_mtc) {
        this.estado_mtc = estado_mtc;
    }


    public String getReportado_mtc() {
        return reportado_mtc;
    }


    public void setReportado_mtc(String reportado_mtc) {
        this.reportado_mtc = reportado_mtc;
    }


    public String getFecha_mantenimiento() {
        return fecha_mantenimiento;
    }


    public void setFecha_mantenimiento(String fecha_mantenimiento) {
        this.fecha_mantenimiento = fecha_mantenimiento;
    }


    public String getRepresentante_hunt() {
        return representante_hunt;
    }


    public void setRepresentante_hunt(String representante_hunt) {
        this.representante_hunt = representante_hunt;
    }


    public String getRepresentante_contrc() {
        return representante_contrc;
    }


    public void setRepresentante_contrc(String representante_contrc) {
        this.representante_contrc = representante_contrc;
    }


    public String getDepartamento() {
        return departamento;
    }


    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }


    public String getMarca() {
        return marca;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }


    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public String getCondicion() {
        return condicion;
    }


    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public String getComentarios() {
        return comentarios;
    }


    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }


    public String getUbicacion() {
        return ubicacion;
    }


    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}

