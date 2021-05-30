package nit.sid.eboutique.DAO;

import java.util.List;



import nit.sid.eboutique.entities.*;





public interface IBoutiqueDAO {
  
	/* CATEGORIE  */
	public Long ajouterCategorie(Categorie c );
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCat);
	public void supprimerCategorie(Long idcat);
	public void modifierCategorie(Categorie c);
	/* PRODUIT  */
	public Long ajouterProduit(Produit p, Long  idCat);
	public List<Produit> listProduits();
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitsSelectionnes();
	public List<Produit> produitsParCategorie(Long idCat);
	public Produit getProduit(Long idP);
	public void supprimerProduit(Long idP);
	public void modifierProduit(Produit p);
	
	/* USER  */
	public void ajouterUser(User u );
	public void attribuerRole(Role r, Long userID);
	
	public Commande enrigistrerCommande(Panier p , Client c);

	}
