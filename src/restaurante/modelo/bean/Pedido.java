package restaurante.modelo.bean;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


@Entity
public class Pedido {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany
	@JoinTable(name="pedido_item",joinColumns=@JoinColumn(name="id_pedido"),inverseJoinColumns=@JoinColumn(name="id_item"))
	private Collection<Item> itens = new ArrayList<Item>();
	
	
}
