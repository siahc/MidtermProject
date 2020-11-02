package com.skilldistillery.crescendo.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "blog_comment")
public class BlogComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String body;

	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	private int edited;

	@Column(name = "in_reply_id")
	private Integer inReplyId;
	
	@ManyToOne
	@JoinColumn(name = "creator_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name= "blog_id")
	private Blog blog;
	
	

	public BlogComment() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}


	public LocalDateTime getCreatedId() {
		return createdAt;
	}

	public void setCreatedId(LocalDateTime createdId) {
		this.createdAt = createdId;
	}

	public int getEdited() {
		return edited;
	}

	public void setEdited(int edited) {
		this.edited = edited;
	}

	public Integer getInReplyId() {
		return inReplyId;
	}

	public void setInReplyId(Integer inReplyId) {
//		this.inReplyId = inReplyId;
		this.inReplyId = (inReplyId == null) ? 0 : inReplyId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blog == null) ? 0 : blog.hashCode());
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + edited;
		result = prime * result + id;
		result = prime * result + ((inReplyId == null) ? 0 : inReplyId.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlogComment other = (BlogComment) obj;
		if (blog == null) {
			if (other.blog != null)
				return false;
		} else if (!blog.equals(other.blog))
			return false;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (edited != other.edited)
			return false;
		if (id != other.id)
			return false;
		if (inReplyId == null) {
			if (other.inReplyId != null)
				return false;
		} else if (!inReplyId.equals(other.inReplyId))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BlogComment [id=" + id + ", body=" + body + ", createdAt=" + createdAt + ", edited=" + edited
				+ ", inReplyId=" + inReplyId + ", user=" + user + ", blog=" + blog + "]";
	}

	
}
