package cn.javass.point.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;


/**
 * 商品表
 * @author Jerry
 *
 */
@Entity
@Table(name="tb_goods")
public class GoodsModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**主键**/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", length=10)
	private int id;
	
	/**商品名称*/
	@Column(name="name", length=100, nullable=false)
	private String name;
	
	/**商品简介*/
	@Column(name="description", length=500, nullable=false)
	private String description;
	
	/**原需积分*/
	@Column(name="orginal_Point", length=10, nullable=false)
	private int orginalPoint;
	
	/**现需积分*/
	@Column(name="now_Point", length=10, nullable=false)
	private int nowPoint;
	
	/**是否已发布*/
	@Column(name="published", nullable=false)
	private boolean published;
	
	/**是否已删除*/
	@Column(name="is_deleted", nullable=false)
	private boolean deleted;
	
	/**版本，乐观锁，并发用。*/
	@Version
	@Column(name="version", length=10, nullable=false)
	private int version;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getOrginalPoint() {
		return orginalPoint;
	}

	public void setOrginalPoint(int orginalPoint) {
		this.orginalPoint = orginalPoint;
	}

	public int getNowPoint() {
		return nowPoint;
	}

	public void setNowPoint(int nowPoint) {
		this.nowPoint = nowPoint;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
}
