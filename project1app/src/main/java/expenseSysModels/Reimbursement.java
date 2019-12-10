package expenseSysModels;


public class Reimbursement {
	int reimbID;
	double amount;
	//java.sql.Timestamp submitted;
	//java.sql.Timestamp resolved;
	java.sql.Timestamp submitted;
	java.sql.Timestamp resolved;
	String description;
	int author;
	int resolver;
	int status;
	int type;
	String stas;
	String typ;
	
	public Reimbursement(int reimID, double amt, java.sql.Timestamp sub, java.sql.Timestamp resd, String desc, int auth, int resr, int sts, int typ) {
		this.reimbID = reimID;
		this.amount = amt;
		this.submitted = sub;
		this.resolved = resd;
		this.description = desc;
		this.author = auth;
		this.resolver = resr;
		this.status = sts;
		this.type = typ;
	}
	
	public Reimbursement(int reimID, double amt, java.sql.Timestamp sub, java.sql.Timestamp resd, String desc, int auth, int resr, String stas, String typ) {
		this.reimbID = reimID;
		this.amount = amt;
		this.submitted = sub;
		this.resolved = resd;
		this.description = desc;
		this.author = auth;
		this.resolver = resr;
		this.stas = stas;
		this.typ = typ;
	}
	
	public Reimbursement(double amt, java.sql.Timestamp sub, java.sql.Timestamp resd, String desc, int auth, int resr, int sts, int typ) {
		this.amount = amt;
		this.submitted = sub;
		this.resolved = resd;
		this.description = desc;
		this.author = auth;
		this.resolver = resr;
		this.status = sts;
		this.type = typ;
	}

	public int getReimbID() {
		return reimbID;
	}

	public void setReimbID(int reimbID) {
		this.reimbID = reimbID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public java.sql.Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(java.sql.Timestamp submitted) {
		this.submitted = submitted;
	}

	public java.sql.Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(java.sql.Timestamp resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getStas() {
		return stas;
	}

	public void setStas(String stas) {
		this.stas = stas;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbID=" + reimbID + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", author=" + author + ", resolver=" + resolver
				+ ", status=" + status + ", type=" + type + "]";
	}
	
	
}