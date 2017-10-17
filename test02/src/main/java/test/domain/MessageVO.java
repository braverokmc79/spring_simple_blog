package test.domain;

import java.util.Date;

public class MessageVO {

	private Integer mid;
	private String targetid;
	private String sender;
	private String message;
	private Date opendate;
	private Date sneddate;
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getTargetid() {
		return targetid;
	}
	public void setTargetid(String targetid) {
		this.targetid = targetid;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getOpendate() {
		return opendate;
	}
	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}
	public Date getSneddate() {
		return sneddate;
	}
	public void setSneddate(Date sneddate) {
		this.sneddate = sneddate;
	}
	
	@Override
	public String toString() {
		return "MessageVO [mid=" + mid + ", targetid=" + targetid + ", sender=" + sender + ", message=" + message
				+ ", opendate=" + opendate + ", sneddate=" + sneddate + "]";
	}
	
	
	
	
}
