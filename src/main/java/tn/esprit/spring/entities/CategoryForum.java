package tn.esprit.spring.entities;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import tn.esprit.spring.entities.Message;
import tn.esprit.spring.entities.Publication;

@Entity
public class CategoryForum implements Serializable{
    @Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String nameF;
    private String descriptionF;
    private String StatusF;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="categoryForum")
    private List<Publication> publications;

}
