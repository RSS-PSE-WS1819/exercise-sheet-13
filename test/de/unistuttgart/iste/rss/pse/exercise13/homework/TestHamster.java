package de.unistuttgart.iste.rss.pse.exercise13.homework;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Direction;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Location;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Size;
import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.Hamster;
import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.HamsterGame;
import de.unistuttgart.iste.rss.oo.hamstersimulator.internal.model.territory.TerritoryBuilder;

public class TestHamster {

	/**
	 * Size used in this test for both, colums and rows.
	 */
	private static final int TERRITORY_SIZE = 4;
	private HamsterGame game;

	@Before
	public void init() {
		game = new HamsterGame();

		final TerritoryBuilder territoryBuilder = game.getNewTerritoryBuilder();
		territoryBuilder.initializeTerritory(new Size(TERRITORY_SIZE, TERRITORY_SIZE));
		/* Configure hamster with position (0,0), direction, and number of grains */
		territoryBuilder.defaultHamsterAt(Location.ORIGIN, Direction.EAST, 0);

		/* Place a grain at position (1,0) */
		territoryBuilder.grainAt(Location.from(1, 0));

		game.initialize(territoryBuilder);
		game.startGame(false);
	}

	/**
	 * Test creating a territory via API.
	 */
	@Test
	public void testConfiguredHamsterOnTerritory() {
		game.runGame(territory -> {
			final Hamster paule = territory.getDefaultHamster();
			assertEquals(new Size(TERRITORY_SIZE, TERRITORY_SIZE), territory.getTerritorySize());
			assertEquals(Location.ORIGIN, paule.getLocation());
			assertEquals(0, territory.getTotalGrainCount());
		});
	}

}
