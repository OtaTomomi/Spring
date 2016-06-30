package board.form;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class MessageForm {
	private Integer id;
	@NotEmpty(message = "本文は必須です")
	@Size(max = 1000,message= "本文は{max}字以下で入力してください")
	private String text;
	@NotEmpty(message = "件名は必須です")
	@Size(max = 50,message = "件名は{max}字で入力してください")
	private String subject;
	@NotEmpty(message = "カテゴリーは必須です")
	@Size(max = 10,message = "カテゴリーは{max}字で入力してください")
	private String category;
	private Date updateDate;
	private Date insertDate;
	private Integer userId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
