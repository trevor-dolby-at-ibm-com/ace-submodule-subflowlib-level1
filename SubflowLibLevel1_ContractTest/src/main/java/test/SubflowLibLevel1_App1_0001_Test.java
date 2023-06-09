package test;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.ibm.integration.test.v1.NodeSpy;
import com.ibm.integration.test.v1.SpyObjectReference;
import com.ibm.integration.test.v1.TestMessageAssembly;
import com.ibm.integration.test.v1.TestSetup;
import com.ibm.integration.test.v1.exception.TestException;

import static com.ibm.integration.test.v1.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.InputStream;

public class SubflowLibLevel1_App1_0001_Test {

	/*
	 * SubflowLibLevel1_ScaffoldApp_TestFlow_AddHTTPHeader_0001_Test
	 * Test generated by IBM App Connect Enterprise Toolkit 12.0.8.0 on Mar 30, 2023 4:28:24 PM
	 */

	@AfterEach
	public void cleanupTest() throws TestException {
		// Ensure any mocks created by a test are cleared after the test runs 
		TestSetup.restoreAllMocks();
	}

	@Test
	public void SubflowLibLevel1_ScaffoldApp_TestFlow_AddHTTPHeader_TestCase_001() throws TestException {

		// Define the SpyObjectReference
		SpyObjectReference nodeReference = new SpyObjectReference().application("SubflowLibLevel1_ScaffoldApp")
				.messageFlow("TestFlow").node("AddHTTPHeader");

		// Initialise a NodeSpy
		NodeSpy nodeSpy = new NodeSpy(nodeReference);

        // Declare a new TestMessageAssembly object for the message being sent into the node
        // This message matches the message assembly App1 sends into the subflow
        TestMessageAssembly inputMessageAssembly = new TestMessageAssembly();
        InputStream inputMessage = Thread.currentThread().getContextClassLoader().getResourceAsStream("App1/HTTPFlow/00000408-6425FEAF-00000001-1.mxml");
        // Resource files sometimes get flattened into the top-level directory during the build . . .  
        if ( inputMessage == null ) inputMessage = Thread.currentThread().getContextClassLoader().getResourceAsStream("00000408-6425FEAF-00000001-1.mxml");
        inputMessageAssembly.buildFromRecordedMessageAssembly(inputMessage);

        // Call the message flow node with the Message Assembly
        nodeSpy.evaluate(inputMessageAssembly, true, "Input");

        // Assert the terminal propagate count for the message
        assertThat(nodeSpy, terminalPropagateCountIs("Output", 1));

        /* Compare Output Message 1 at output terminal out */
        TestMessageAssembly actualMessageAssembly = nodeSpy.propagatedMessageAssembly("Output", 1);
        
        // This message matches the message assembly App1 received from the subflow 
        TestMessageAssembly expectedMessageAssembly = new TestMessageAssembly();
        InputStream expectedMessage = Thread.currentThread().getContextClassLoader().getResourceAsStream("App1/HTTPFlow/00000408-6425FEAF-00000001-4.mxml");
        // Resource files sometimes get flattened into the top-level directory during the build . . .  
        if ( expectedMessage == null ) expectedMessage = Thread.currentThread().getContextClassLoader().getResourceAsStream("00000408-6425FEAF-00000001-4.mxml");
        expectedMessageAssembly.buildFromRecordedMessageAssembly(expectedMessage);
        
        // Assert that the actual message assembly matches the expected message assembly
	    assertThat(actualMessageAssembly, equalsMessage(expectedMessageAssembly).ignoreTimeStamps());
	}

}
