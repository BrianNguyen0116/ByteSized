import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.rules.TemporaryFolder;

class SerializedInventoryTest {

	@Test
	void testSerializedInvGettor() {
		SerializedInventory sinv = SerializedInventory.getInstance();
		
		sinv.getInventory().getItem("Tomato Sauce").setPrice(2);
		assertEquals(2, sinv.getInventory().getItem("Tomato Sauce").getPrice());
	}
}
