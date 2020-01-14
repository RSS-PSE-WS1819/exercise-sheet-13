package de.unistuttgart.iste.rss.pse.exercise13.presence;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.unistuttgart.iste.rss.pse.exercise13.presence.Person;

public class TestPerson {

	/** Tests whether two Person with equal properties are equal. */
	@Test
	public void personsWithEqualNameAreEqual() {
		Person personA1 = new Person("Ronald", "McBurger");
		Person personA2 = new Person("Ronald", "McBurger");

		assertEquals("Expect object to be equal", personA1, personA2);
	}

	/** Tests whether the a Person object is equal to itself. */
	@Test
	public void SamePersonsIsEqual() {
		Person personA1 = new Person("Ronald", "McBurger");
		Person personA2 = personA1;

		assertEquals("Expect object to be equal", personA1, personA2);
	}
}
