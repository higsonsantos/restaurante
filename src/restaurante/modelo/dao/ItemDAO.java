package restaurante.modelo.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import restaurante.modelo.bean.Item;

@SuppressWarnings("unchecked")

public class ItemDAO {
	
	private EntityManager entityManager;
	
	public ItemDAO(EntityManager entityManager){
		this.entityManager=entityManager;
	}
	
	public void cadastrar (Item item){
		entityManager.persist(item);
	}
	
	public void alterar (Item item){
		entityManager.merge(item);
	}
	
	public void excluir (Item item){
		entityManager.remove(entityManager.merge(item));
	}
	
	public Item consultar (Long id){
		return entityManager.getReference(Item.class, id);
	}
	
	public List<Item> listar(){
		String jpql = "Select i from Item i order by nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}	
}
