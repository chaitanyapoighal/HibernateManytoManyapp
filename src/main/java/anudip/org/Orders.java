package anudip.org;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Orders {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oid;
	private int cost;
	
	@ManyToMany(mappedBy="orders")
	
	Set<Customers> customerset=new HashSet<Customers>();

	public int getOid() {
		return oid;
	}

	public int getCost() {
		return cost;
	}

	public Set<Customers> getCustomerset() {
		return customerset;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setCustomerset(Set<Customers> customerset) {
		this.customerset = customerset;
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
