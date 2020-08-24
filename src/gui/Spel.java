package gui;
import java.util.HashMap;
import java.util.Map;
import domein.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;


public class Spel extends GridPane{
	private Hoofdpaneel hoofdpaneel;
	private Button btnToonSpelerAanBeurt;
	Label lblNaam1Inventory = new Label();
	Label lblNaam2Inventory = new Label();
	Label lblNaam3Inventory = new Label();
	Label lblNaam4Inventory = new Label();
	Label lblNaam5Inventory = new Label();
	Button btnStapel1 = new Button();
	Button btnStapel2 = new Button();
	Button btnStapel3 = new Button();
	Button btnStapel4 = new Button();
	Button btnStapel5 = new Button();
	private int spelerNummer;
	Label lblWarning = new Label();
	/*
	private String blauw = "-fx-background-color: #33A9FF";
	private String bruin = "-fx-background-color: #89430F";
	private String geel = "-fx-background-color: #EEDA32";
	private String groen = "-fx-background-color: #6AD03C";
	private String paars = "-fx-background-color: #B144DA";
	private String rood = "-fx-background-color: #DA4944";
	private String orange = "-fx-background-color: #FF8D1E";
	//joker == zwart
	private String joker = "-fx-background-color: #373535";
	//+2 == appelblauwzeegroen
	private String plusTwee = "-fx-background-color: #21FFD3";
	*/
	

	//alle fotos aan de bepaalde kaartnaam mappen 
	private static final Map<String, Image> kaarten = new HashMap<String, Image>();
	public Spel (Hoofdpaneel hoofdpaneel) {
		this.hoofdpaneel = hoofdpaneel;

		/*kaarten.put("+2", new Image(getClass().getResourceAsStream("/fotos/+2.GIF")));
		kaarten.put("blauw", new Image(getClass().getResourceAsStream("/fotos/blauw.GIF")));
		kaarten.put("bruin", new Image(getClass().getResourceAsStream("/fotos/bruin.GIF")));
		kaarten.put("geel", new Image(getClass().getResourceAsStream("/fotos/geel.GIF")));
		kaarten.put("groen", new Image(getClass().getResourceAsStream("/fotos/groen.GIF")));
		kaarten.put("joker", new Image(getClass().getResourceAsStream("/fotos/joker.GIF")));
		kaarten.put("orange", new Image(getClass().getResourceAsStream("/fotos/orange.GIF")));
		kaarten.put("paars", new Image(getClass().getResourceAsStream("/fotos/paars.GIF")));
		kaarten.put("rood", new Image(getClass().getResourceAsStream("/fotos/rood.GIF")));*/
		
		btnToonSpelerAanBeurt = new Button("Laat het spel zien");
		super.add(btnToonSpelerAanBeurt, 1, 1);		
		btnToonSpelerAanBeurt.setOnAction(this::toonSpelerAanBeurd);
	}
	
	private void toonSpelerAanBeurd(ActionEvent event) {
		getChildren().remove(btnToonSpelerAanBeurt);
		Button btnNaam1 = new Button();
		btnNaam1.setText("Speler 1: " + hoofdpaneel.dc.getSpelers().get(0).getNaam() + " ");
		super.add(btnNaam1, 6, 3);
		EventHandler<ActionEvent> eventNaam1 = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	showButtonStapelKiezen();
            	spelerNummer = 1;
            }
		};

		lblNaam1Inventory.setText(hoofdpaneel.dc.getInventaris(0).toString());
		super.add(lblNaam1Inventory, 7, 3);
		
		btnNaam1.setOnAction(eventNaam1);
		
		
		
		Button btnNaam2 = new Button();
		btnNaam2.setText("Speler 2: " + hoofdpaneel.dc.getSpelers().get(1).getNaam() + " ");
		super.add(btnNaam2, 6, 4);

		lblNaam2Inventory.setText(hoofdpaneel.dc.getInventaris(1).toString());
		super.add(lblNaam2Inventory, 7, 4);
		EventHandler<ActionEvent> eventNaam2 = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	showButtonStapelKiezen();
            	spelerNummer = 2;
            }
		};
		btnNaam2.setOnAction(eventNaam2);
		
		
		
		Button btnNaam3 = new Button();
		btnNaam3.setText("Speler 3: " + hoofdpaneel.dc.getSpelers().get(2).getNaam() + " ");
		super.add(btnNaam3, 6, 5);

		lblNaam3Inventory.setText(hoofdpaneel.dc.getInventaris(2).toString());
		super.add(lblNaam3Inventory, 7, 5);
		EventHandler<ActionEvent> eventNaam3 = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	showButtonStapelKiezen();
            	spelerNummer = 3;
            }
		};
		btnNaam3.setOnAction(eventNaam3);
		
		
		
		Button btnNaam4 = new Button();
		btnNaam4.setText("Speler 4: " + hoofdpaneel.dc.getSpelers().get(3).getNaam() + " ");
		super.add(btnNaam4, 6, 6);

		lblNaam4Inventory.setText(hoofdpaneel.dc.getInventaris(3).toString());
		super.add(lblNaam4Inventory, 7, 6);
		EventHandler<ActionEvent> eventNaam4 = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	showButtonStapelKiezen();
            	spelerNummer = 4;
            }
		};
		btnNaam4.setOnAction(eventNaam4);
		
		
		
		if (hoofdpaneel.dc.getSpelers().size() == 5) {
			Button btnNaam5 = new Button();
			btnNaam5.setText("Speler 5: " + hoofdpaneel.dc.getSpelers().get(4).getNaam() + " ");
			super.add(btnNaam5, 6, 7);

			lblNaam5Inventory.setText(hoofdpaneel.dc.getInventaris(4).toString());
			super.add(lblNaam5Inventory, 7, 7);
			EventHandler<ActionEvent> eventNaam5 = new EventHandler<ActionEvent>() { 
	            public void handle(ActionEvent e) 
	            { 
	            	showButtonStapelKiezen();
	            	spelerNummer = 5;
	            }
			};
			btnNaam5.setOnAction(eventNaam5);
		}
		
		
		
		Label lblError = new Label();
		lblError.setText("");
		super.add(lblError, 7, 8);
		lblWarning.setText("");
		super.add(lblWarning, 7, 9);
		
		hoofdpaneel.dc.neemKaart();
		Button btnKaart = new Button();
		super.add(btnKaart, 0, 2);
		btnKaart.setText(hoofdpaneel.dc.getInHand().toString());
		
		
		Button btn1 = new Button();
		btn1.setText("Stapel 1");
		super.add(btn1, 1, 2);
		Label lbl1 = new Label();
		super.add(lbl1, 1, 1);
		EventHandler<ActionEvent> eventB1 = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	if (hoofdpaneel.dc.isStapelVol(1) == true) {
            		lblError.setText("Deze stapel zit helaas al vol.");
            	} else {
            	hoofdpaneel.dc.plaatsKaartOpStapel(1, hoofdpaneel.dc.getInHand());
            	btnKaart.setText("");
            	lbl1.setText(lbl1.getText() +"\n " + hoofdpaneel.dc.getInHand().toString());
            	//
        		hoofdpaneel.dc.neemKaart();
        		btnKaart.setText(hoofdpaneel.dc.getInHand().toString());
        		checkLastRound();
        		//btnKaart.setStyle();
            	}
            } 
        }; 
        btn1.setOnAction(eventB1);
		EventHandler<ActionEvent> eventActie1 = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	hoofdpaneel.dc.stapelNemen(spelerNummer-1, 1);
            	lbl1.setText(" ");
            	spelersInventoryWeergeven();
            	hideButtonStapelKiezen();
            	checkLastRound();
            }
        }; 
        btnStapel1.setOnAction(eventActie1);
		
		Button btn2 = new Button();
		btn2.setText("Stapel 2");
		super.add(btn2, 2, 2);
		Label lbl2 = new Label();
		super.add(lbl2,2 , 1);
		EventHandler<ActionEvent> eventB2 = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	if (hoofdpaneel.dc.isStapelVol(2) == true) {
            		lblError.setText("Deze stapel zit helaas al vol.");
            	} else {
            	hoofdpaneel.dc.plaatsKaartOpStapel(2, hoofdpaneel.dc.getInHand());
            	btnKaart.setText("");
            	lbl2.setText(lbl2.getText() +"\n " + hoofdpaneel.dc.getInHand().toString());
            	
        		hoofdpaneel.dc.neemKaart();
        		btnKaart.setText(hoofdpaneel.dc.getInHand().toString());
        		checkLastRound();
            	}
            } 
        }; 
        btn2.setOnAction(eventB2);
		EventHandler<ActionEvent> eventActie2 = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	hoofdpaneel.dc.stapelNemen(spelerNummer-1, 2);
            	lbl2.setText(" ");
            	spelersInventoryWeergeven();
            	hideButtonStapelKiezen();
            	checkLastRound();
            }
        }; 
        btnStapel2.setOnAction(eventActie2);
		
		Button btn3 = new Button();
		btn3.setText("Stapel 3");
		super.add(btn3, 3, 2);
		Label lbl3 = new Label();
		super.add(lbl3, 3, 1);
		EventHandler<ActionEvent> eventB3 = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	if (hoofdpaneel.dc.isStapelVol(3) == true) {
            		lblError.setText("Deze stapel zit helaas al vol.");
            	} else {
            	hoofdpaneel.dc.plaatsKaartOpStapel(3, hoofdpaneel.dc.getInHand());
            	btnKaart.setText("");
            	lbl3.setText(lbl3.getText() +"\n " + hoofdpaneel.dc.getInHand().toString());
            	
        		hoofdpaneel.dc.neemKaart();
        		btnKaart.setText(hoofdpaneel.dc.getInHand().toString());
        		checkLastRound();
            	}
            } 
        }; 
        btn3.setOnAction(eventB3);
		EventHandler<ActionEvent> eventActie3 = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	hoofdpaneel.dc.stapelNemen(spelerNummer-1, 3);
            	lbl3.setText(" ");
            	spelersInventoryWeergeven();
            	hideButtonStapelKiezen();
            	checkLastRound();
            }
        }; 
        btnStapel3.setOnAction(eventActie3);
		
		Button btn4 = new Button();
		btn4.setText("Stapel 4");
		super.add(btn4, 4, 2);
		Label lbl4 = new Label();
		super.add(lbl4, 4, 1);
		EventHandler<ActionEvent> eventB4 = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	if (hoofdpaneel.dc.isStapelVol(4) == true) {
            		lblError.setText("Deze stapel zit helaas al vol.");
            	} else {
            	hoofdpaneel.dc.plaatsKaartOpStapel(4, hoofdpaneel.dc.getInHand());
            	btnKaart.setText("");
            	lbl4.setText(lbl4.getText() +"\n " + hoofdpaneel.dc.getInHand().toString());
            	
        		hoofdpaneel.dc.neemKaart();
        		btnKaart.setText(hoofdpaneel.dc.getInHand().toString());
        		checkLastRound();
            	}
            } 
        }; 
        btn4.setOnAction(eventB4);
		EventHandler<ActionEvent> eventActie4 = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	hoofdpaneel.dc.stapelNemen(spelerNummer-1, 4);
            	lbl4.setText(" ");
            	spelersInventoryWeergeven();
            	hideButtonStapelKiezen();
            	checkLastRound();
            }
        }; 
        btnStapel4.setOnAction(eventActie4);
		
		if (hoofdpaneel.dc.getSpelers().size() == 5) {
			Button btn5 = new Button();
			btn5.setText("Stapel 5");
			super.add(btn5, 5, 2);
			Label lbl5 = new Label();
			super.add(lbl5, 5, 1);
			
			EventHandler<ActionEvent> eventB5 = new EventHandler<ActionEvent>() { 
	            public void handle(ActionEvent e) 
	            { 
	            	if (hoofdpaneel.dc.isStapelVol(5) == true) {
	            		lblError.setText("Deze stapel zit helaas al vol.");
	            	} else {
	            	hoofdpaneel.dc.plaatsKaartOpStapel(5, hoofdpaneel.dc.getInHand());
	            	btnKaart.setText("");
	            	lbl5.setText(lbl5.getText() +"\n " + hoofdpaneel.dc.getInHand().toString());
	            	
	        		hoofdpaneel.dc.neemKaart();
	        		btnKaart.setText(hoofdpaneel.dc.getInHand().toString());
	        		checkLastRound();
	            	}
	            }
	        }; 
	        btn5.setOnAction(eventB5);
			EventHandler<ActionEvent> eventActie5 = new EventHandler<ActionEvent>() { 
	            public void handle(ActionEvent e) 
	            { 
	            	hoofdpaneel.dc.stapelNemen(spelerNummer-1, 5);
	            	lbl5.setText(" ");
	            	spelersInventoryWeergeven();
	            	hideButtonStapelKiezen();
	            	checkLastRound();
	            }
	        }; 
	        btnStapel5.setOnAction(eventActie5);
	        
	        


		} 
	}
	private void spelersInventoryWeergeven() {
		lblNaam1Inventory.setText(hoofdpaneel.dc.getInventaris(0).toString());
		lblNaam2Inventory.setText(hoofdpaneel.dc.getInventaris(1).toString());
		lblNaam3Inventory.setText(hoofdpaneel.dc.getInventaris(2).toString());
		lblNaam4Inventory.setText(hoofdpaneel.dc.getInventaris(3).toString());
		if (hoofdpaneel.dc.getSpelers().size() == 5) {
			lblNaam5Inventory.setText(hoofdpaneel.dc.getInventaris(4).toString());
		}
	}
	private void showButtonStapelKiezen() {
		btnStapel1.setText("Stapel 1 nemen");
		super.add(btnStapel1, 1, 0);
		btnStapel2.setText("Stapel 2 nemen");
		super.add(btnStapel2, 2, 0);
		btnStapel3.setText("Stapel 3 nemen");
		super.add(btnStapel3, 3, 0);
		btnStapel4.setText("Stapel 4 nemen");
		super.add(btnStapel4, 4, 0);
		if (hoofdpaneel.dc.getSpelers().size() == 5) {
			btnStapel5.setText("Stapel 5 nemen");
			super.add(btnStapel5, 5, 0);
		}
	}
	private void hideButtonStapelKiezen() {
		getChildren().remove(btnStapel1);
		getChildren().remove(btnStapel2);
		getChildren().remove(btnStapel3);
		getChildren().remove(btnStapel4);
		if (hoofdpaneel.dc.getSpelers().size() == 5) {
			getChildren().remove(btnStapel5);
		}
	}
	private void checkLastRound() {
		if (hoofdpaneel.dc.getDeck() <= 16) {
			lblWarning.setText("Laatste ronde!");
		}
	}
}
