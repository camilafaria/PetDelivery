/*
 * This file was automatically generated by EvoSuite
 * Thu Oct 26 21:15:45 GMT 2017
 */

package br.com.petdelivery.jdbc.dao;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import br.com.petdelivery.jdbc.dao.Raca_AnimalDAO;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Raca_AnimalDAO_ESTest extends Raca_AnimalDAO_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Raca_AnimalDAO raca_AnimalDAO0 = null;
      try {
        raca_AnimalDAO0 = new Raca_AnimalDAO();
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // java.sql.SQLException: No suitable driver found for jdbc:mysql://null/null?useSSL=null
         //
         verifyException("br.com.petdelivery.jdbc.ConnectionFactory", e);
      }
  }
}
