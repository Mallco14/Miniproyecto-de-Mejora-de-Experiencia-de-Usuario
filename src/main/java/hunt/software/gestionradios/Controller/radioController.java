package hunt.software.gestionradios.Controller;

import hunt.software.gestionradios.Model.Radios;
import hunt.software.gestionradios.Util.ConnectBD;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.Workbook;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class radioController {

    //creacion de los metodos
    ConnectBD newConnectBD =new ConnectBD();

    public void addNewRadios(Radios radios) {
            //Consulta SQL
            String sql = "INSERT INTO dbo.inventarioRadios VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                //Preparar la consulta
                PreparedStatement prt = newConnectBD.getConnection().prepareStatement(sql);
                //insertamos
                prt.setString(1, radios.getNum_serie());
                prt.setString(2, radios.getIndicativo_mtc());
                prt.setString(3, radios.getEstado_mtc());
                prt.setString(4, radios.getReportado_mtc());
                prt.setString(5, radios.getFecha_mantenimiento());
                prt.setString(6, radios.getRepresentante_hunt());
                prt.setString(7, radios.getRepresentante_contrc());
                prt.setString(8, radios.getDepartamento());
                prt.setString(9, radios.getMarca());
                prt.setString(10, radios.getModelo());
                prt.setString(11, radios.getCondicion());
                prt.setString(12, radios.getEstado());
                prt.setString(13, radios.getComentarios());
                prt.setString(14, radios.getUbicacion());
                //realizara cambios
                int value = prt.executeUpdate();
                if (value > 0){
                    System.out.println("Se inserto la radio : "+ radios);
                }else {
                    System.out.println("Error al insertar la radio, vuevla a intentalo");
                }
            }catch (SQLException ex){
                System.out.println("error : "+ex.getMessage());
            }


    }

    public Radios searchRadios(String num_serie) {
        String sql = "SELECT * FROM dbo.inventarioRadios where num_serie =?";


        Radios radio = null;
        try {
            PreparedStatement prt = newConnectBD.getConnection().prepareStatement(sql);
            prt.setString(1, num_serie);
            ResultSet rs = prt.executeQuery();
            while (rs.next()) {
                radio = new Radios();
                radio.setNum_serie(rs.getString("num_serie"));
                radio.setIndicativo_mtc(rs.getString("indicativo_mtc"));
                radio.setEstado_mtc(rs.getString("estado_mtc"));
                radio.setReportado_mtc(rs.getString("reportado_mtc"));
                radio.setFecha_mantenimiento(rs.getString("fecha_mantenimiento"));
                radio.setRepresentante_hunt(rs.getString("representante_hunt"));
                radio.setRepresentante_contrc(rs.getString("representante_contrc"));
                radio.setDepartamento(rs.getString("departamento"));
                radio.setMarca(rs.getString("marca"));
                radio.setModelo(rs.getString("modelo"));
                radio.setCondicion(rs.getString("condicion"));
                radio.setEstado(rs.getString("estado"));
                radio.setComentarios(rs.getString("comentarios"));
                radio.setUbicacion(rs.getString("ubicacion"));
                //creado
                System.out.println("radio encontrada" + radio);
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar la Radio" + e.getMessage());
        }
        return radio;
    }

    public void updateRadios(Radios radios){
        //sql
        String sql = "UPDATE nombre_de_la_tabla SET indicativo_mtc = ?, " +
                "estado_mtc = ?, reportado_mtc = ?, " +
                "fecha_mantenimiento = ?, representante_hunt = ?, " +
                "representante_contrc = ?, departamento = ?, " +
                "marca = ?, modelo = ?, condicion = ?, " +
                "estado = ?, comentarios = ?, ubicacion = ? " +
                "WHERE num_serie = ?";
        try {
            //PREPARAMOS
            PreparedStatement prt = newConnectBD.getConnection().prepareStatement(sql);
            prt.setString(1, radios.getIndicativo_mtc());
            prt.setString(2, radios.getEstado_mtc());
            prt.setString(3,radios.getReportado_mtc());
            prt.setString(4, radios.getFecha_mantenimiento());
            prt.setString(5, radios.getRepresentante_hunt());
            prt.setString(6, radios.getRepresentante_contrc());
            prt.setString(7,radios.getDepartamento());
            prt.setString(8, radios.getMarca());
            prt.setString(9, radios.getModelo());
            prt.setString(10, radios.getCondicion());
            prt.setString(11, radios.getEstado());
            prt.setString(12, radios.getComentarios());
            prt.setString(13, radios.getUbicacion());
            prt.setString(14, radios.getNum_serie());
            int value = prt.executeUpdate();
            if(value > 0){
                System.out.println("Se actualizo la radio : "+ radios);
            }
            else{
                System.out.println("Error al actualizar la radio, vuevla a intentalo");
            }
        }catch (SQLException e){
            System.out.println("Error al actualizar la radio" + e.getMessage());
        }


    }

    public List<Radios> getRadios(){
        List<Radios> listaRadios = new ArrayList<>();
        try {
            String sql = "SELECT * FROM dbo.inventarioRadios";
            Statement stm = newConnectBD.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                Radios radios = new Radios();
                radios.setId(rs.getInt("id"));
                radios.setNum_serie(rs.getString("num_serie"));
                radios.setIndicativo_mtc(rs.getString("indicativo_mtc"));
                radios.setEstado_mtc(rs.getString("estado_mtc"));
                radios.setReportado_mtc(rs.getString("reportado_mtc"));
                radios.setFecha_mantenimiento(rs.getString("fecha_mantenimiento"));
                radios.setRepresentante_hunt(rs.getString("representante_hunt"));
                radios.setRepresentante_contrc(rs.getString("representante_contrc"));
                radios.setDepartamento(rs.getString("departamento"));
                radios.setMarca(rs.getString("marca"));
                radios.setModelo(rs.getString("modelo"));
                radios.setCondicion(rs.getString("condicion"));
                radios.setEstado(rs.getString("estado"));
                radios.setComentarios(rs.getString("comentarios"));
                radios.setUbicacion(rs.getString("ubicacion"));
                listaRadios.add(radios);
            }

        }catch (SQLException E){
            System.out.println(E.getMessage());
        }
        return listaRadios;
    }

    public static void exportToExcel(List<Radios> radiosList, String filePath) {
        try
        {
            // Crear un libro de trabajo (Workbook)
            WritableWorkbook workbook = Workbook.createWorkbook(new File(filePath));


            // Crear una hoja de trabajo (Sheet)
            WritableSheet sheet = workbook.createSheet("Radios", 0);

            // Encabezados
            sheet.addCell(new Label(0, 0, "id"));
            sheet.addCell(new Label(1, 0, "num_serie"));
            sheet.addCell(new Label(2, 0, "estado_mtc"));
            sheet.addCell(new Label(3, 0, "reportado_mtc"));
            sheet.addCell(new Label(4, 0, "fecha_mantenimiento"));
            sheet.addCell(new Label(5, 0, "representante_hunt"));
            sheet.addCell(new Label(6, 0, "representante_contrc"));
            sheet.addCell(new Label(7, 0, "departamento"));
            sheet.addCell(new Label(8, 0, "marca"));
            sheet.addCell(new Label(9, 0, "modelo"));
            sheet.addCell(new Label(10,0,"condicion"));
            sheet.addCell(new Label(11,0,"estado"));
            sheet.addCell(new Label(12,0,"comentarios"));
            sheet.addCell(new Label(13,0,"ubicacion"));


            // Datos
            int rowNum = 1;

            for (Radios radios : radiosList) {
                sheet.addCell(new Number(0, rowNum, radios.getId()));
                sheet.addCell(new Label(1, rowNum, radios.getNum_serie()));
                sheet.addCell(new Label(2, rowNum, radios.getEstado_mtc()));
                sheet.addCell(new Label(3, rowNum, radios.getReportado_mtc()));
                sheet.addCell(new Label(4, rowNum, radios.getFecha_mantenimiento()));
                sheet.addCell(new Label(5, rowNum, radios.getRepresentante_hunt()));
                sheet.addCell(new Label(6, rowNum, radios.getRepresentante_contrc()));
                sheet.addCell(new Label(7, rowNum, radios.getDepartamento()));
                sheet.addCell(new Label(8, rowNum, radios.getMarca()));
                sheet.addCell(new Label(9, rowNum, radios.getModelo()));
                sheet.addCell(new Label(10,rowNum,radios.getCondicion()));
                sheet.addCell(new Label(11,rowNum,radios.getEstado()));
                sheet.addCell(new Label(12,rowNum,radios.getComentarios()));
                sheet.addCell(new Label(13,rowNum,radios.getUbicacion()));
                rowNum++;
            }

            // Escribir y cerrar el libro de trabajo
            workbook.write();//escribiendo el libro de excel
            workbook.close();//liberando

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static boolean isFileInUse(String filePath) {
        try (FileChannel channel = FileChannel.open(Paths.get(filePath), StandardOpenOption.WRITE);
             FileLock lock = channel.tryLock()) {
            return lock == null;
        } catch (IOException e) {
            return true; // El archivo está en uso o no se puede abrir
        }

    }
}

