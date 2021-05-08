package setup;

import java.util.ResourceBundle;

public class GetProperty {

	public String getPropertyByValue(String key){
		ResourceBundle rb = ResourceBundle.getBundle("config");
		return rb.getString(key);
	}
}
