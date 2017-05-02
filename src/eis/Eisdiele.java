package eis;

public class Eisdiele {
	String[] spagettieisSorten={"Vanille"};
	String[] spagettieisExtras={"Kokosraspeln"};
	String[] bananasplitSorten={"Vanille"};
	String[] bananasplitExtras={"Sahne", "Bananen"};
	String[] schokobecherSorten ={"Schokolade","Haselnuss"};
	String[] schokobecherExtras={"Sahne","Kekse"};
	Eis eis;
	

	void bestellen(String typ){
		this.begruessen();
		
		if(typ.equals("Bananasplit")){
			Eis bananasplit = new Eis("Bananasplit", "Kugeln", "Glas", 5.20, bananasplitSorten, bananasplitExtras);
			eis = bananasplit;
			}
		else{
		if(typ.equals("Spagettieis")){
			Eis spagettieis = new Eis("Spagettieis", "Spagetti", "Teller", 3.40, spagettieisSorten, spagettieisExtras);
			eis = spagettieis;
			}
		else{
		
		if(typ.equals("Schokobecher")){
			Eis schokoeis = new Eis("Schokoeis", "Kugeln", "Glas", 5.40, schokobecherSorten, schokobecherExtras);
			eis =schokoeis;
			}
		
		else{
			this.entschuldigen();
			return;
			}
		}
	}
		this.kassieren(eis);
		this.verabschieden();
		
		
				
	}
	void begruessen(){System.out.println("Willkommen in unserer Eisdiele");};
	void kassieren(Eis eis){
		System.out.println("Das macht: "+eis.getPreis()+"€");
		
	};
	void verabschieden(){System.out.println("Auf Wiedersehen!");};
	void entschuldigen(){System.out.println("Es tut uns leid diese Sorte haben wir leider nicht mehr da!");};

}
