package com.revature.models;

import java.time.LocalDateTime;


import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ers_reimbursement")
public class Reimbursement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reimb_id")
	private int id;
	
	@Column(name = "reimb_amount", nullable = false)
	private int amount;
	
	@Column(name = "reimb_submitted", nullable = false)
	private LocalDateTime submitted;
	
	@Column(name = "reimb_resolved")
	private LocalDateTime resolved;
	
	@Column(name = "reimb_description")
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ers_author_fk")
	private Users author;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ers_resolver_fk")
	private Users resolver;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "reimburse_status_id_fk")
	private ReimbursementStatus status;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "reimburse_type_id_fk")
	private ReimbursementType type;

	

	
	
	
	//Constructors, toString() etc below-------------------------------------------------------
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}






	public Reimbursement(int id, int amount, LocalDateTime submitted, LocalDateTime resolved, String description,
			Users author, Users resolver, ReimbursementStatus status, ReimbursementType type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}






	public Reimbursement(int amount, LocalDateTime submitted, LocalDateTime resolved, String description, Users author,
			Users resolver, ReimbursementStatus status, ReimbursementType type) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}






	public Reimbursement(int parseInt, Date date, Object object, String desc, Users user, Object object2,
			ReimbursementStatus status2, ReimbursementType type2) {
		// TODO Auto-generated constructor stub
	}






	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", author=" + author + ", resolver=" + resolver + ", status="
				+ status + ", type=" + type + "]";
	}






	@Override
	public int hashCode() {
		return Objects.hash(amount, author, description, id, resolved, resolver, status, submitted, type);
	}






	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		return amount == other.amount && Objects.equals(author, other.author)
				&& Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(resolved, other.resolved) && Objects.equals(resolver, other.resolver)
				&& Objects.equals(status, other.status) && Objects.equals(submitted, other.submitted)
				&& Objects.equals(type, other.type);
	}






	public int getId() {
		return id;
	}






	public void setId(int id) {
		this.id = id;
	}






	public int getAmount() {
		return amount;
	}






	public void setAmount(int amount) {
		this.amount = amount;
	}






	public LocalDateTime getSubmitted() {
		return submitted;
	}






	public void setSubmitted(LocalDateTime submitted) {
		this.submitted = submitted;
	}






	public LocalDateTime getResolved() {
		return resolved;
	}






	public void setResolved(LocalDateTime resolved) {
		this.resolved = resolved;
	}






	public String getDescription() {
		return description;
	}






	public void setDescription(String description) {
		this.description = description;
	}






	public Users getAuthor() {
		return author;
	}






	public void setAuthor(Users author) {
		this.author = author;
	}






	public Users getResolver() {
		return resolver;
	}






	public void setResolver(Users resolver) {
		this.resolver = resolver;
	}






	public ReimbursementStatus getStatus() {
		return status;
	}






	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}






	public ReimbursementType getType() {
		return type;
	}






	public void setType(ReimbursementType type) {
		this.type = type;
	}






	
	
}
