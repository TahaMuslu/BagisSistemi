package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;


public class LoginScreenController {
	@FXML
	private Hyperlink hyplink = new Hyperlink();
	@FXML
	public void hyplinkUnderlineT() {
		hyplink.setUnderline(true);
	}
	
	public void hyplinkUnderlineF() {
		hyplink.setUnderline(false);
	}
	
	
	
}
