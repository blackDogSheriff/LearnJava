import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import com.example.Config;

public class ConfigTest {
    Config config;

    @BeforeEach
    public void setUp() {
        config = new Config();
    }

    @AfterEach
    public void tearDown() {
        config = null;
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void testWin() {
        assertEquals("C:\\test.ini", config.getConfigFile("test.ini"));
    }

    @Test
    @EnabledOnOs({ OS.LINUX, OS.MAC })
    public void testLinuxAndMac() {
        assertEquals("/usr/local/test.cfg", "test.cfg");
    }

}


/*
 * @DisabledOnJre(JRE.JAVA_8)
 * @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
 * @EnabledIfEnvironmentVariable(named = "DEBUG", matches = "true")
 */