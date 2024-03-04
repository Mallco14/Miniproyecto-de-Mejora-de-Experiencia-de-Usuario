module hunt.software.gestionradios {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires jxl;


    opens hunt.software.gestionradios to javafx.fxml;
    exports hunt.software.gestionradios;
    exports hunt.software.gestionradios.Controller;
    exports hunt.software.gestionradios.Model;
    opens hunt.software.gestionradios.Controller to javafx.fxml;
}