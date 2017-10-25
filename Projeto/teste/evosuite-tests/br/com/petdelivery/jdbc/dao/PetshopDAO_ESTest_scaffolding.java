/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Wed Oct 25 18:10:01 GMT 2017
 */

package br.com.petdelivery.jdbc.dao;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class PetshopDAO_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "br.com.petdelivery.jdbc.dao.PetshopDAO"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init();
    setSystemProperties();
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
  } 

  @Before 
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public static void setSystemProperties() {
 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
    java.lang.System.setProperty("file.encoding", "Cp1252"); 
    java.lang.System.setProperty("java.awt.headless", "true"); 
    java.lang.System.setProperty("user.country", "BR"); 
    java.lang.System.setProperty("user.language", "pt"); 
    java.lang.System.setProperty("user.timezone", "America/Sao_Paulo"); 
    java.lang.System.setProperty("sun.management.compiler", "HotSpot 64-Bit Tiered Compilers"); 
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(PetshopDAO_ESTest_scaffolding.class.getClassLoader() ,
      "oracle.jdbc.driver.OracleDriver$1",
      "oracle.sql.Datum",
      "oracle.jdbc.driver.OracleDiagnosabilityMBean",
      "oracle.jdbc.driver.DiagnosabilityMXBean",
      "oracle.sql.TypeDescriptorFactory",
      "oracle.jdbc.driver.DatabaseError",
      "oracle.jdbc.driver.Message",
      "oracle.jdbc.OracleConnection",
      "oracle.jdbc.internal.ObjectDataFactory",
      "oracle.jdbc.driver.OracleDriverExtension",
      "oracle.sql.AnyDataFactory",
      "oracle.jdbc.driver.OracleSQLException",
      "oracle.jdbc.driver.SQLStateMapping",
      "oracle.sql.ORADataFactory",
      "oracle.jdbc.internal.ObjectData",
      "oracle.jdbc.driver.Message11",
      "oracle.net.ns.Message",
      "oracle.jdbc.driver.SQLStateMapping$Tokenizer",
      "oracle.sql.ORAData",
      "br.com.petdelivery.jdbc.ConnectionFactory",
      "oracle.jdbc.internal.OracleConnection",
      "br.com.petdelivery.jdbc.dao.PetshopDAO",
      "oracle.jdbc.OracleDriver",
      "oracle.net.ns.NetException",
      "oracle.jdbc.driver.OracleDriver"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(PetshopDAO_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "br.com.petdelivery.jdbc.ConnectionFactory",
      "oracle.jdbc.driver.SQLStateMapping",
      "oracle.jdbc.driver.DatabaseError",
      "oracle.jdbc.driver.Message11",
      "oracle.sql.AnyDataFactory",
      "oracle.sql.TypeDescriptorFactory",
      "oracle.jdbc.driver.OracleDriver",
      "oracle.jdbc.OracleDriver"
    );
  }
}
