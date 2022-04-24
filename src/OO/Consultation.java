package OO;

import java.sql.Date;

public class Consultation {
	private int code;
	private Date date;
	private String type;
	private String remarques;
	private int pcode;
	
	public Consultation(Date date, String remarques, String type) {
		super();
		this.date = date;
		this.type = type;
		this.remarques = remarques;
		this.pcode = pcode;
	}
	public Consultation(Date date, String remarques, int pcode, String type) {
		super();
		this.date = date;
		this.type = type;
		this.remarques = remarques;
		this.pcode = pcode;
	}
	public Consultation(int code, Date date, String type, String remarques, int pcode) {
		super();
		this.code = code;
		this.date = date;
		this.type = type;
		this.remarques = remarques;
		this.pcode = pcode;
	}
	public Consultation() {
		// TODO Auto-generated constructor stub
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRemarques() {
		return remarques;
	}
	public void setRemarques(String remarques) {
		this.remarques = remarques;
	}
	public int getPcode() {
		return pcode;
	}
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	

	
	
    
    
}
