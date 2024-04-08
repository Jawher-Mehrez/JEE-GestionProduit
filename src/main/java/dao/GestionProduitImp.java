package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionProduitImp implements IGestionProduit {
	
	Connection connection = ConnectionBD.getConnection();

	@Override
	public void ajoutProduit(Produit p) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=connection.prepareStatement("INSERT INTO produit (nom,prix,quantite) VALUES (?,?,?)");
		    ps.setString(1, p.getNom());
		    ps.setDouble(2, p.getPrix());
		    ps.setInt(3, p.getQuantite());
		    ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void supprimeProduit(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=connection.prepareStatement("DELETE FROM produit WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Produit rechercherParId(int id) {
		// TODO Auto-generated method stub
		Produit p=null;
		try {
			PreparedStatement ps=connection.prepareStatement("select * from produit where id = ?");
			ps.setInt(1,id);
			ResultSet rs= ps.executeQuery();
			if (rs.next()) {
				p= new Produit(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
			}
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return p ;
	}

	@Override
	public List<Produit> getAllProduits() {
		List<Produit> liste =new ArrayList<Produit>();
		try {
		PreparedStatement ps=connection.prepareStatement("select * from produit");
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			Produit p= new Produit(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
			liste.add(p);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public List<Produit> getAllProduitsParNom(String nom) {
		List<Produit> liste =new ArrayList<Produit>();
		try {
		PreparedStatement ps=connection.prepareStatement("select * from produit where nom like ?");
		ps.setString(1, "%" + nom + "%");
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			Produit p= new Produit(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
			liste.add(p);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	
	}

	@Override
	public void modifProduit(Produit p) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		
		 try {			
			 ps=connection.prepareStatement("update produit set nom=?,prix=?,quantite=? where id=?");
		     ps.setString(1,p.getNom());
		     ps.setDouble(2,p.getPrix());
		     ps.setInt(3,p.getQuantite());
		     ps.setInt(4,p.getId());
		     ps.executeUpdate();
		 
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
