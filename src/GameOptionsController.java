import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;



public class GameOptionsController {
	
	@FXML
	Button saveButton;
	Slider playerSlider;
	
	@FXML
	protected void saveSettings()
	{
		playerSlider.valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> ov,
					Number old_val, Number new_val) {
				System.out.println(new_val.doubleValue());
				
			}
			
		});
	}

}
