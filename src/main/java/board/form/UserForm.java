package board.form;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserForm {
	private Integer id;

	@NotEmpty(message = "ログインIDは必須です")
	@Size(min = 6,max = 20,message = "ログインIDは{min}文字以上{max}文字以下で入力してください")
	private String loginId;
	@Size(min = 6,max = 225,message = "パスワードは{min}文字以上{max}文字以下で入力してください")
	@NotEmpty(message = "パスワードは必須です")
	private String password;
	@Size(max = 10,message = "名称は{max}で入力してください")
	@NotEmpty(message = "名称は必須です")
	private String name;
	@Max(value = 7,message = "支店名を選択してください")
	private Integer branchId;
	@Max(value = 4,message ="部署・役職を選択してください")
	private Integer positionId;
	private Boolean useable;
	private Date insertDate;
	private Date updateDate;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public Boolean getUseable() {
		return useable;
	}

	public void setUseable(Boolean useable) {
		this.useable = useable;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
