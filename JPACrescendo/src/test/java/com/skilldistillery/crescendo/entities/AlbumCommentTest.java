package com.skilldistillery.crescendo.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AlbumCommentTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private AlbumComment comment;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("SocialApp");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf = null;
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		comment = em.find(AlbumComment.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		comment = null;
		em = null;
	}

	@Test
	@DisplayName("testing album entity")
	void albumEntity() {
		assertNotNull(comment);
		assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", comment.getBody());
		assertEquals(0, comment.getEdited());

	}

	@Test
	@DisplayName("testing mapping to user")
	void mappingToUser() {
		assertNotNull(comment);
		assertEquals("TEX", comment.getUser().getFirstName());
	}

	@Test
	@DisplayName("testing mapping album comment to album")
	void albumToComment() {
		assertNotNull(comment);
		assertEquals("THE #FFFFFF ALBUM", comment.getAlbum().getTitle());
	}

}
