package dao;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestionProduitImp gestion =new GestionProduitImp();
		//List<Produit> lp = gestion.getAllProduits();
		//Produit p= new Produit(1,"clavier",12.5,45);
	//	gestion.ajoutProduit(p);
		//gestion.supprimeProduit(4);
		//gestion.modifProduit(p);
		
		System.out.println(gestion.getAllProduitsParNom("pc"));
		User u = new User("amine","amine@gmail.com","1234");
		GestionUserImp gestionU = new 	GestionUserImp();
		System.out.println(gestionU.verification(u));
		
	}

}
