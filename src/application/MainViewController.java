package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXTextField;
import application.models.FDInterest;
import application.models.RDInterest;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable{

	ObservableList<String> list =  FXCollections.observableArrayList();
	
    @FXML
    private JFXTextField amount;

    @FXML
    private JFXTextField age;

    @FXML
    private Label finalAmount;

    @FXML
    private JFXTextField maturityPeriod;

    @FXML
    private JFXTextField country;
    
    @FXML
    private ListView<String> mp;

    @FXML
    private ListView<Double> gci;

    @FXML
    private ListView<Double> sci;
    @FXML
    private Label finalAmountRD;

    @FXML
    private ListView<String> mpRD;

    @FXML
    private ListView<Double> gciRD;

    @FXML
    private ListView<Double> sciRD;
    
    @FXML
    private JFXTextField amountRD;

    @FXML
    private JFXTextField ageRD;

    @FXML
    private JFXTextField countryRD;

    @FXML
    private JFXTextField maturityPeriodRD;
    
    @FXML
    private VBox calcIcon;

    @FXML
    public void caculateFD(ActionEvent event) {
    	if(!(amount.getText().isEmpty() || country.getText().isEmpty() ||  age.getText().isEmpty() || maturityPeriod.getText().isEmpty())) {
    		FDInterest f = new FDInterest(Double.parseDouble(amount.getText()), country.getText(), Integer.parseInt(age.getText()), maturityPeriod.getText());
    		finalAmount.setText("Rs."+f.calcInterest());
        	finalAmount.getStyleClass().add("result");
        	}else {
        		Alert alert = new Alert(Alert.AlertType.ERROR);
        		alert.setHeaderText(null);
        		alert.setContentText("Fields should not be empty");
        		alert.showAndWait();
        	}
    	
    	
    }
    
    @FXML
    public void calculateRD() {
    	if(!(amount.getText().isEmpty() || country.getText().isEmpty() ||  age.getText().isEmpty() || maturityPeriod.getText().isEmpty())) {
    	RDInterest r = new RDInterest(Double.parseDouble(amountRD.getText()), countryRD.getText(), Integer.parseInt(ageRD.getText()), maturityPeriodRD.getText());
    	finalAmountRD.setText("Rs. "+r.calcInterest());
    	finalAmountRD.getStyleClass().add("result");
    	}else {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setHeaderText(null);
    		alert.setContentText("Fields should not be empty");
    		alert.showAndWait();
    	}
    }
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		calcIcon.getChildren().add(GlyphsDude.createIcon(FontAwesomeIcon.CALCULATOR));
		loadData();
	
		
	}
	
	public void loadData() {
		list.add("7-14 days");
		list.add("15-29 days");
		list.add("30-45 days");
		list.add("45-60 days");
		list.add("61-184 days");
		list.add("184-1 year");
		mp.getItems().setAll(list);
		FDInterest f = new FDInterest(0, "", 0, "");
		gci.getItems().setAll(sortedList(f.getRate_of_interest_general().values()));
		sci.getItems().setAll(sortedList(f.getRate_of_interest_senior().values()));
		list.clear();
		list.add("6 moths");
		list.add("9 moths");
		list.add("12 moths");
		list.add("15 moths");
		list.add("18 moths");
		list.add("21 moths");
		mpRD.getItems().setAll(list);
		RDInterest r = new RDInterest(0, "", 0, "");
		gciRD.getItems().setAll(sortedList(r.getRate_of_interest_general().values()));
		sciRD.getItems().setAll(sortedList(r.getRate_of_interest_senior().values()));
		
		
	}
	
	public ArrayList<Double> sortedList(Collection<Double> list2){
		ArrayList<Double> sl = new ArrayList<Double>();
		Iterator<Double> itr = list2.iterator();
		while(itr.hasNext()) {
			sl.add((Double) itr.next());
		}
		Collections.sort(sl);
		return sl;
	}
	
}
