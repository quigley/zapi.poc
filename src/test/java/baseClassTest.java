import org.junit.*;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import zephyr.zapi.*;


import static org.junit.Assert.*;

public class baseClassTest {

    public static Config config = new Config();

    static zapi zapi = new zapi(config.GetConfigValue("username"),
            config.GetConfigValue("password"),
            "https://jirauat.concurqa.com"
    );
    public static TestCycle testCycle;
    public static String projectName = "E2E Service";

    @Rule
    public TestName name = new TestName();

    @Rule
    public TestRule testWatcher = new zapiTestWatcher(testCycle);

    @BeforeClass
    public static void TestCycleUpdate() throws Exception {
        String cycleName = "Magnum Test Cycle 2";
        String cycleDescription = "automagically created";
        testCycle = zapi.InitiateTestCycle(cycleName, cycleDescription, projectName, "-1");
    }
    @Before
    public void setUp() throws Exception {
        zapi.TestCycleUpdate(name, testCycle.projectId,testCycle.cycleId);
    }

    @After
    public void tearDown() throws Exception {
    }



    @Test
    public void baseClass() {
        assertTrue(false);
    }

    @Test
    public void baseClassPass() {
        assertTrue(true);
    }

    @Test
    public void baseClassPass3() {
        assertTrue(false);
    }

    @Test
    public void baseClassPass4() {
        assertTrue(false);
    }
}