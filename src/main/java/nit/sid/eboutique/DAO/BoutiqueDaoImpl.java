package nit.sid.eboutique.DAO;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import nit.sid.eboutique.entities.Categorie;
import nit.sid.eboutique.entities.Client;
import nit.sid.eboutique.entities.Commande;
import nit.sid.eboutique.entities.LigneCommande;
import nit.sid.eboutique.entities.Panier;
import nit.sid.eboutique.entities.Produit;
import nit.sid.eboutique.entities.Role;
import nit.sid.eboutique.entities.User;

public class BoutiqueDaoImpl implements IBoutiqueDAO {
     @PersistenceContext
	private EntityManager em;
	@Override
	public Long ajouterCategorie(Categorie c) {
		em.persist(c);
		return c.getIdcategorie();
	
	}

	@Override
	public List<Categorie> listCategories() {
		Query req = em.createQuery("select c from Categorie c");
		return null;
	}

	@Override
	public Categorie getCategorie(Long idCat) {
	  return em.find(Categorie.class, idCat);

	}

	@Override
	public void supprimerCategorie(Long idcat) {
    Categorie c= em.find(Categorie.class, idcat);
    em.remove(c);
		
	}

	@Override
	public void modifierCategorie(Categorie c) {
	
		em.merge(c);
	}

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
	   Categorie c=getCategorie(idCat);
	   p.setCategorie(c);
		em.persist(p);
		return p.getIdProduit();
	}

	@Override
	public List<Produit> listProduits() {
	  Query req = em.createQuery("select p from Produit  p");
		return req.getResultList();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		Query req = em.createQuery("select p from Produit  p where p.designation like :x or   p.description like :x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		Query req = em.createQuery("select p from Produit  p where p.selected=true ");
		return req.getResultList();
		
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		Query req = em.createQuery("select p from Produit  p where p.categorie.idcategorie=:x");
		req.setParameter("x",idCat);
		return req.getResultList();
	}

	@Override
	public Produit getProduit(Long idP) {
		// TODO Auto-generated method stub
		return em.find(Produit.class, idP);
	}

	@Override
	public void supprimerProduit(Long idP) {
		
		Produit p=getProduit(idP);
		em.remove(p);
	}

	@Override
	public void modifierProduit(Produit p) {
		em.merge(p);
		
	}

	@Override
	public void ajouterUser(User u) {
		em.persist(u);
		
	}

	@Override
	public void attribuerRole(Role r, Long userID) {
	   User u=em.find(User.class, userID);
	u.getRoles().add(r);
	em.persist(r);
	}

	

}
