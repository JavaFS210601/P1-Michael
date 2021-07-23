package com.revature.daos;

import java.util.List;

import com.revature.models.ReimbursementStatus;

public interface StatusDAOInterface {

		//get a status by it's ID
		public ReimbursementStatus getStatus(int id);
		//get all statuses
		public List<ReimbursementStatus> getAllStatus();
		//insert a new status to the DB
		public void insertStatus(ReimbursementStatus newStatus);
		//update a status already in the database
		public void updateStatus(ReimbursementStatus status);
		//delete a status
		public void deleteStatus(ReimbursementStatus status);
}
