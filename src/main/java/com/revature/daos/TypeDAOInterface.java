package com.revature.daos;

import java.util.List;

import com.revature.models.ReimbursementType;

public interface TypeDAOInterface {

	
	//get a type by it's ID
		public ReimbursementType getType(int id);
		//get all typees
		public List<ReimbursementType> getAllType();
		//insert a new type to the DB
		public void insertType(ReimbursementType newType);
		//update a type already in the database
		public void updateType(ReimbursementType type);
		//delete a type
		public void deleteType(ReimbursementType type);
}
