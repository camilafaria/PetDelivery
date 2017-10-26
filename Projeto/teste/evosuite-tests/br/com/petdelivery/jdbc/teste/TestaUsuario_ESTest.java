/*
 * This file was automatically generated by EvoSuite
 * Thu Oct 26 21:47:07 GMT 2017
 */

package br.com.petdelivery.jdbc.teste;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import br.com.petdelivery.jdbc.teste.TestaUsuario;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class TestaUsuario_ESTest extends TestaUsuario_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      // Undeclared exception!
      try { 
        TestaUsuario.insert();
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // java.sql.SQLException: No suitable driver found for jdbc:mysql://null/null?useSSL=null
         //
         verifyException("br.com.petdelivery.jdbc.ConnectionFactory", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      TestaUsuario testaUsuario0 = new TestaUsuario();
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      // Undeclared exception!
      try { 
        TestaUsuario.main((String[]) null);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // java.sql.SQLException: No suitable driver found for jdbc:mysql://null/null?useSSL=null
         //
         verifyException("br.com.petdelivery.jdbc.ConnectionFactory", e);
      }
  }
}
