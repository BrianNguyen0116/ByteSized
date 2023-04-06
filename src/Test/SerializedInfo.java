import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.rules.TemporaryFolder;

class SerializedInfoTest {

	@Test
	void testSerializableInfoSave() {
		SerializedInfo sinfo = SerializedInfo.getInstance();
		
		sinfo.getInfo().setAddress("123 Hello Street");
        sinfo.saveInfo();

        SerializedInfo sinfo_2 = SerializedInfo.getInstance();
        assertEquals(sinfo_2.getInfo().getAddress(), "123 Hello Street");
		
	}
}
