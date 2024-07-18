package entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "locker")
public class Locker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lockerId;
	private String lockerType;
	private Double rent;

	// This is for bidirectional
	// https://www.baeldung.com/jpa-joincolumn-vs-mappedby
	@OneToOne(mappedBy = "locker", cascade = CascadeType.ALL) // CascadeType.ALL propagates all operations
	private Player player;

	public Locker() {
		super();
	}

	public Locker(String lockerType, Double rent) {
		super();
		// this.lockerId = lockerId;
		this.lockerType = lockerType;
		this.rent = rent;
	}

	public int getLockerId() {
		return lockerId;
	}

	public String getLockerType() {
		return lockerType;
	}

	public void setLockerType(String lockerType) {
		this.lockerType = lockerType;
	}

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

//	public Player getPlayer() {
//		return player;
//	}
//
//	public void setPlayer(Player player) {
//		this.player = player;
//	}

	@Override
	public String toString() {
		return "Locker [lockerId=" + lockerId + ", lockerType=" + lockerType + ", rent=" + rent + "]";
	}

}
