package hunt.software.gestionradios.Controller;

import hunt.software.gestionradios.Model.Radios;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;


public class viewController {
    @FXML
    public Button btnAgregar;
    public Button btnEliminar;
    public TextField txtNumSerie;
    public TextField txtReportMTC;
    public TextField txtDepartamento;
    public TextField txtFechaManten;
    public TextField txtRHunt;
    public TextField txtRContratista;
    public TextField txtModelo;
    public TextField txtMarca;
    public TextField txtCondicion;
    public TextField txtEstado;
    public TextField txtUbicacion;
    public TextField txtComentario;
    public TextField txtIndicativoMTC;
    public TextField txtEstadoMTC;
    public Button btnBuscar;
    public Button btnReporte;
    public Button btnActualizar;
    public static void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private boolean validarCampos(TextField... campos) {
        for (TextField campo : campos) {
            if (campo.getText().isEmpty()) {
                // Mostrar un mensaje de error
                showAlert(Alert.AlertType.ERROR,"Error","Por favor, asegúrate de completar todos los campos antes de continuar.");
                return false; // Al menos un campo está vacío
            }
        }
        return true; // Todos los campos están llenos
    }
    @FXML
    public void OnClickAddRadios() {
        if(validarCampos(txtNumSerie,txtReportMTC,txtDepartamento,txtFechaManten,txtIndicativoMTC,
                txtRHunt,txtRContratista,txtModelo,txtMarca,txtCondicion,txtEstado,txtUbicacion,txtComentario,
                txtEstadoMTC)){
            //creamos el objeto radios
            Radios radio = new Radios(
                    txtNumSerie.getText(),
                    txtReportMTC.getText(),
                    txtDepartamento.getText(),
                    txtFechaManten.getText(),
                    txtIndicativoMTC.getText(),
                    txtRHunt.getText(),
                    txtRContratista.getText(),
                    txtModelo.getText(),
                    txtMarca.getText(),
                    txtCondicion.getText(),
                    txtEstado.getText(),
                    txtUbicacion.getText(),
                    txtComentario.getText(),
                    txtEstadoMTC.getText());
            //llamalos a la funcionalidades
            radioController controller = new radioController();
            controller.addNewRadios(radio);
            showAlert(Alert.AlertType.INFORMATION,"Informacion","Radio agregada al inventario exitosamente.");
        }
    }

    @FXML
    public void OnClickSearchRadios() {
        //capturamos valor
        String num_serie = txtNumSerie.getText();
        //llamalo al metodo
        radioController search = new radioController();
        Radios radio_encontrada = search.searchRadios(num_serie);
        //CONDICION
        if(radio_encontrada !=null){
            showAlert(Alert.AlertType.INFORMATION,"Informacion","¡Radio encontrada con éxito!");
            txtNumSerie.setText(radio_encontrada.getNum_serie());
            txtIndicativoMTC.setText(radio_encontrada.getIndicativo_mtc());
            txtEstadoMTC.setText(radio_encontrada.getEstado_mtc());
            txtReportMTC.setText(radio_encontrada.getReportado_mtc());
            txtDepartamento.setText(radio_encontrada.getDepartamento());
            txtFechaManten.setText(radio_encontrada.getFecha_mantenimiento());
            txtRHunt.setText(radio_encontrada.getRepresentante_hunt());
            txtRContratista.setText(radio_encontrada.getRepresentante_contrc());
            txtDepartamento.setText(radio_encontrada.getDepartamento());
            txtModelo.setText(radio_encontrada.getModelo());
            txtMarca.setText(radio_encontrada.getMarca());
            txtCondicion.setText(radio_encontrada.getCondicion());
            txtEstado.setText(radio_encontrada.getEstado());
            txtComentario.setText(radio_encontrada.getComentarios());
            txtUbicacion.setText(radio_encontrada.getUbicacion());
        }
        else{
            showAlert(Alert.AlertType.ERROR, "Error","Radio no encontrada. Por favor, revisa el número de serie e intenta nuevamente.");
        }

    }

    public void OnClickDeleteRadios() {
    }

    public void OnClickUpdateRadios() {
        if(validarCampos(txtNumSerie,txtReportMTC,txtDepartamento,txtFechaManten,txtIndicativoMTC,
                txtRHunt,txtRContratista,txtModelo,txtMarca,txtCondicion,txtEstado,txtUbicacion,txtComentario,
                txtEstadoMTC)){
            Radios radioUpdate = new Radios(
                    txtNumSerie.getText(),
                    txtReportMTC.getText(),
                    txtDepartamento.getText(),
                    txtFechaManten.getText(),
                    txtIndicativoMTC.getText(),
                    txtRHunt.getText(),
                    txtRContratista.getText(),
                    txtModelo.getText(),
                    txtMarca.getText(),
                    txtCondicion.getText(),
                    txtEstado.getText(),
                    txtUbicacion.getText(),
                    txtComentario.getText(),
                    txtEstadoMTC.getText());
            radioController newUpdate = new radioController();
            newUpdate.updateRadios(radioUpdate);
            showAlert(Alert.AlertType.CONFIRMATION,"Confirmacion","Se actualizó correctamente el radio");
        }else {
            showAlert(Alert.AlertType.ERROR, "Error","Por favor, completa todos los campos.");

        }

    }
    public void OnClickReporteRadios() {
        //llamamos a la funcion de REPORTRADIOS
        radioController report = new radioController();
        //ruta
        String filePath ="reportes\\reporteNuevo.xls";
        //validaciones
        if (!radioController.isFileInUse(filePath)) {
            radioController.exportToExcel(report.getRadios(), filePath);
            showAlert(Alert.AlertType.INFORMATION,"Información","El informe se ha generado correctamente. Puede revisar los resultados.");
        } else {
            showAlert(Alert.AlertType.WARNING, "Advertencia", "El archivo Excel está en uso. Ciérrelo antes de generar otro informe.");
            ///mostrarAlerta("Error", "El archivo Excel está en uso. Ciérrelo antes de generar otro informe.");
        }
    }
}