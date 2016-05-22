package music.recommd.model;

public class ReturnParam {
	private String StringStatus;
	private Boolean BooleanStatus;
	
	public ReturnParam(String StringStatus){
		this.StringStatus=StringStatus;
	}
	
	public ReturnParam(Boolean BooleanStatus){
		this.BooleanStatus=BooleanStatus;
	}

	public String getStringStatus() {
		return StringStatus;
	}

	public void setStringStatus(String stringStatus) {
		StringStatus = stringStatus;
	}

	public Boolean getBooleanStatus() {
		return BooleanStatus;
	}

	public void setBooleanStatus(Boolean booleanStatus) {
		BooleanStatus = booleanStatus;
	}

}
