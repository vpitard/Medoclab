package model;
import java.util.ArrayList;


public class Composant {

	private int id;
	private String name;
	public static ArrayList<Composant> allTheComposant = new ArrayList<Composant>();
	
	public Composant(int id, String name) {
		super();
		this.id=id;
		this.name=name;
		allTheComposant.add(this);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
	public static Composant getComposantById(int id){
		Composant found = null;
		for(Composant c: Composant.allTheComposant){
			if(c.getId()==id)
				found=c;
		}
		return found;
	}
	
	public static Composant getComposantByNom(String name) {
		Composant found = null;
		for(Composant c : Composant.allTheComposant){
			if(c.getName().equals(name))
				found=c;
		}
		return found;
	}

}
