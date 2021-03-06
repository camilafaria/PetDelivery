/*
 * This file was automatically generated by EvoSuite
 * Thu Oct 26 21:20:17 GMT 2017
 */

package br.com.petdelivery.jdbc.dao;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import br.com.petdelivery.jdbc.dao.Servico_PetshopDAO;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Servico_PetshopDAO_ESTest extends Servico_PetshopDAO_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Servico_PetshopDAO servico_PetshopDAO0 = null;
      try {
        servico_PetshopDAO0 = new Servico_PetshopDAO();
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // java.sql.SQLException: No suitable driver found for jdbc:mysql://null/null?useSSL=null
         //
         verifyException("br.com.petdelivery.jdbc.ConnectionFactory", e);
      }
  }
}
