module BagisSistemi {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens GUI to javafx.graphics, javafx.fxml;
}
