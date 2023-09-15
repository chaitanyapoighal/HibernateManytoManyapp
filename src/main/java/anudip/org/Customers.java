package anudip.org;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String cname;
	
	@ManyToMany
	@JoinTable(name = "Customer_orders", joinColumns = @JoinColumn(name = "cid"), inverseJoinColumns = @JoinColumn(name = "oid"))

	private Set<Orders> orders = new HashSet<Orders>();

	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCid() {
		return cid;
	}

	public String getCname() {
		return cname;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

}
