package eis;

public class Eis {

	double preis;
	String behaeltnis, art, name;
	String [] sorten, extras ;
	String[] spagettieisSorten={"Vanille"};
	String[] spagettieisExtras={"Kokosraspeln"};
	String[] bananasplitSorten={"Vanille"};
	String[] bananasplitExtras={"Sahne", "Bananen"};
	String[] schokobecherSorten ={"Schokolade","Haselnuss"};
	String[] schokobecherExtras={"Sahne","Kekse"};
	
	
	Eis(String name, String art, String behaeltnis, double preis, String[]sorten, String[]extras){
		this.name = name;
		this.art = art;
		this.behaeltnis=behaeltnis;
		this.preis=preis;
		this.sorten =sorten;
		this.extras = extras;	
		this.vorbereiten();
		this.fuellen();
		this.dekorieren();
	}
	
	void vorbereiten(){
		System.out.println("Nehme "+behaeltnis);
	}
	
	void fuellen(){
		System.out.print("Fülle "+behaeltnis+" mit: ");
		for(int i=0; i<=sorten.length-1;i++){
			System.out.print(sorten[i]+", ");
		}
		System.out.println("als "+art+".");
	}
	
	void dekorieren(){
		System.out.print("Dekoriere Eis mit: ");
		for(int i=0; i<=extras.length-1;i++){
			System.out.print(extras[i]+", ");
		}
		System.out.println("dekorieren");
	}
	
	double getPreis(){
		return preis;
	}
	
	
}


