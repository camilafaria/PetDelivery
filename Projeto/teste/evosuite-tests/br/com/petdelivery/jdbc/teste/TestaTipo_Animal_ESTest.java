/*
 * This file was automatically generated by EvoSuite
 * Thu Oct 26 21:45:28 GMT 2017
 */

package br.com.petdelivery.jdbc.teste;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import br.com.petdelivery.jdbc.teste.TestaTipo_Animal;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class TestaTipo_Animal_ESTest extends TestaTipo_Animal_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      TestaTipo_Animal testaTipo_Animal0 = new TestaTipo_Animal();
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      String[] stringArray0 = new String[1];
      // Undeclared exception!
      try { 
        TestaTipo_Animal.main(stringArray0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // java.sql.SQLException: No suitable driver found for jdbc:mysql://null/null?useSSL=null
         //
         verifyException("br.com.petdelivery.jdbc.ConnectionFactory", e);
      }
  }
}
