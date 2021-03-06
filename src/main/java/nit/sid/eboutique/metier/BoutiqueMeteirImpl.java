package nit.sid.eboutique.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import nit.sid.eboutique.DAO.IBoutiqueDAO;
import nit.sid.eboutique.entities.Categorie;
import nit.sid.eboutique.entities.Client;
import nit.sid.eboutique.entities.Commande;
import nit.sid.eboutique.entities.Panier;
import nit.sid.eboutique.entities.Produit;
import nit.sid.eboutique.entities.Role;
import nit.sid.eboutique.entities.User;
@Transactional 
public class BoutiqueMeteirImpl implements IAdminCategoriesMetier {
     
	private IBoutiqueDAO dao;
	public void setDao(IBoutiqueDAO dao) {
		this.dao = dao;
	}

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
	
		return dao.ajouterProduit(p, idCat);
	}

	@Override
	public void supprimerProduit(Long idP) {
	    dao.supprimerProduit(idP);
	}

	@Override
	public void modifierProduit(Produit p) {
	  
		dao.modifierProduit(p);
	}

	@Override
	public List<Categorie> listCategories() {
		
		return  dao.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.getCategorie(idCat);
	}

	@Override
	public List<Produit> listproduits() {
		// TODO Auto-generated method stub
		return dao.listProduits() ;
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		// TODO Auto-generated method stub
		return dao.produitsParMotCle(mc);
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
	  
		return dao.produitsParCategorie(idCat);
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		// TODO Auto-generated method stub
		return dao.produitsSelectionnes();
	}

	@Override
	public Produit getProduit(Long idP) {
		// TODO Auto-generated method stub
		return dao.getProduit(idP);
	}

	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		// TODO Auto-generated method stub
		return dao.enrigistrerCommande(p, c);
	}

	@Override
	public Long ajouterCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return dao.ajouterCategorie(c);
	}

	@Override
	public void supprimerCategorie(Long idCat) {
		// TODO Auto-generated method stub
		dao.supprimerCategorie(idCat);
	}

	@Override
	public void modifierCategorie(Categorie c) {
		// TODO Auto-generated method stub
		dao.modifierCategorie(c);
	}

	@Override
	public void ajouterUser(User u) {
		// TODO Auto-generated method stub
		dao.ajouterUser(u);
	}

	@Override
	public void attribuerRole(Role r, Long userID) {
		// TODO Auto-generated method stub
		dao.attribuerRole(r, userID);
	}

}
