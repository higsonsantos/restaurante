package restaurante.controle.mb;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import restaurante.modelo.bean.Item;
import restaurante.modelo.dao.JPAUtil;
import restaurante.modelo.dao.ItemDAO;

@ViewScoped
@ManagedBean
public class ItemMB {
	
	private Item item = new Item();
	
	public Item getItem(){
		return item;
	}
	
	public void setItem(Item item){
		this.item=item;
	}
	
	public List<Item> listaItem = new ArrayList<Item>();
	
	public List<Item> getListaItem() {
		return listaItem;
	}
	
	
	@PostConstruct
	public void carregarItem(){
		EntityManager em = JPAUtil.getEntityManager();
		ItemDAO dao = new ItemDAO(em);
		listaItem = dao.listar();
		em.close();
	}	
	
	public void salvar (){
		EntityManager em = JPAUtil.getEntityManager();
		ItemDAO dao = new ItemDAO(em);
		em.getTransaction().begin();
		item.setDataCadastro(Calendar.getInstance());
		if(item.getId()!=null){
			dao.alterar(item);
		}else{
			dao.cadastrar(item);
		}
		em.getTransaction().commit();
		em.close();
		item = new Item();
		carregarItem();
	}
	
	public void excluir(){
		EntityManager em = JPAUtil.getEntityManager();
		ItemDAO dao = new ItemDAO(em);
		em.getTransaction().begin();
		dao.excluir(item);
		em.getTransaction().commit();
		em.close();
		carregarItem();
	}
}
