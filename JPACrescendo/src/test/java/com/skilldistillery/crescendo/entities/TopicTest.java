package com.skilldistillery.crescendo.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TopicTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Topic thread;

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
		thread = em.find(Topic.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		thread = null;
		em = null;
	}

	@Test
	@DisplayName("testing thread entity")
	void threadEntity() {
		assertNotNull(thread);
		assertEquals("RANDOM DISCUSSION THREAD", thread.getTitle());

	}

	@Test
	@DisplayName("testing thread creation time stamp")
	void threadTime() {

		Topic newThread = new Topic();

		newThread.setTitle("title");
		newThread.setUser(em.find(User.class, 1));
		em.getTransaction().begin();
		em.persist(newThread);
		em.flush();

		em.getTransaction().commit();

		assertNotNull(newThread.getCreatedAt());

	}

	@Test
	@DisplayName("testing thread user mapping")
	void threadToUserMapping() {
		assertNotNull(thread);
		assertEquals("TEX", thread.getUser().getFirstName());

	}

	@Test
	@DisplayName("Thread to Genre Mapping")
	void threadToGenre() {
		assertNotNull(thread);
		assertTrue(thread.getGenres().size() > 0);
		assertEquals("NEO-CLASSICAL POST-METAL", thread.getGenres().get(0).getName());
	}

}
