package entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@SuppressWarnings("unused")
@Entity
@Table(name = "PLAYER")
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;
	private String playerName;
	private Date dateOfBirth;
	private String address;
	private long phoneNo;

	@OneToOne(cascade = CascadeType.ALL) // CascadeType.ALL propagates all operations
	//@JoinColumn(name = "lockerId") // this can be used to give name to foreign key column
	// https://www.baeldung.com/jpa-joincolumn-vs-mappedby
	private Locker locker;

	public Player(String playerName, Date dateOfBirth, String address, long phoneNo) {
		super();
		this.playerName = playerName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNo = phoneNo;
	}

	public Player() {
		super();
	}

	public int getPlayerId() {
		return playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Locker getLocker() {
		return locker;
	}

	public void setLocker(Locker locker) {
		this.locker = locker;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", dateOfBirth=" + dateOfBirth
				+ ", address=" + address + ", phoneNo=" + phoneNo + ", locker=" + locker + "]";
	}

}
