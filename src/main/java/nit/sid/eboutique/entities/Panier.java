package nit.sid.eboutique.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Panier implements Serializable {
	
	private Map<Long,LigneCommande> items = new HashMap<Long, LigneCommande>();
	
	public void addArticle(Produit p, int quantite)
	{
		if( items.get(p.getIdProduit()) != null )
		{
			items.get(p.getIdProduit()).setQuantite(quantite + items.get(p.getIdProduit()).getQuantite());
		}
		else
		{
			LigneCommande ligneCommande = new LigneCommande();
			ligneCommande.setProduit(p);
			ligneCommande.setQuantite(quantite);
			ligneCommande.setPrix(p.getPrix());
		}
		
	}
	
	
	public Map<Long, LigneCommande> getItems() {
		return items;
	}


	public void setItems(Map<Long, LigneCommande> items) {
		this.items = items;
	}


	public Collection<LigneCommande> getCommandes()
	{
		return items.values();
	}
	
	public double getTotal()
	{
		double total = 0 ;
		for ( LigneCommande l : items.values())
			total += l.getPrix() * l.getQuantite() ;
		
		return total;
	}
	
	public int getSize()
	{
		return items.size();
	}
	
	public void deleteProduit(Long idProduit)
	{
		items.remove(idProduit);
	}
	
	

}