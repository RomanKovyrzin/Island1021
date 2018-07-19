package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.sql.Date;

@Entity
@Table (name = "authors")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;

	private Date death;
	private Date born;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "author_to_publish",
			inverseJoinColumns = {
				@JoinColumn(name = "publish", nullable = false)
			},
			joinColumns = {
				@JoinColumn(name = "author", nullable = false)
			}
	)
	//@OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
	private Set<Publish> publishes = new HashSet<Publish>();

	public Author() {
	}

	public Author(String name, Date born) {
		this.name = name;
		this.born = born;
	}

	public void addPublishes(Publish publish) {
		this.publishes.add(publish);
	}
	public Set<Publish> getPublishes() {
		return publishes;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setDeath(Date death) {
		this.death = death;
	}
	public Date getDeath() {
		return death;
	}

	public void setBorn(Date born) {
		this.born = born;
	}
	public Date getBorn() {
		return born;
	}

	public int getId() {
		return id;
	}

}
