module BagisSistemi {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens GUI to javafx.graphics, javafx.fxml;
}
