/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 25 18:27:00 GMT 2017
 */

package br.com.petdelivery.jdbc.modelo;

import org.junit.Test;
import static org.junit.Assert.*;
import br.com.petdelivery.jdbc.modelo.Autonomo;
import br.com.petdelivery.jdbc.modelo.Petshop;
import br.com.petdelivery.jdbc.modelo.Prestador;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Prestador_ESTest extends Prestador_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Prestador prestador0 = new Prestador();
      prestador0.setSomaQnt(0);
      assertEquals(0, prestador0.getSomaQnt());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Prestador prestador0 = new Prestador();
      prestador0.setSomaNota((-784.7515F));
      assertEquals((-784.7515F), prestador0.getSomaNota(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Prestador prestador0 = new Prestador();
      prestador0.setSenha("");
      assertNull(prestador0.getEmail());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Prestador prestador0 = new Prestador();
      Petshop petshop0 = new Petshop();
      prestador0.setPetshop(petshop0);
      assertNull(petshop0.getDescricao());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Prestador prestador0 = new Prestador();
      prestador0.setId_prestador((Long) null);
      assertEquals(0, prestador0.getSomaQnt());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Prestador prestador0 = new Prestador();
      prestador0.setEmail("Or]VgWO%S=%G");
      assertEquals("Or]VgWO%S=%G", prestador0.getEmail());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Prestador prestador0 = new Prestador();
      prestador0.setAutonomo((Autonomo) null);
      assertNull(prestador0.getSenha());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Prestador prestador0 = new Prestador();
      int int0 = prestador0.getSomaQnt();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Prestador prestador0 = new Prestador();
      float float0 = prestador0.getSomaNota();
      assertEquals(0.0F, float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Prestador prestador0 = new Prestador();
      String string0 = prestador0.getSenha();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Prestador prestador0 = new Prestador();
      Petshop petshop0 = prestador0.getPetshop();
      assertNull(petshop0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Prestador prestador0 = new Prestador();
      Long long0 = prestador0.getId_prestador();
      assertNull(long0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Prestador prestador0 = new Prestador();
      String string0 = prestador0.getEmail();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Prestador prestador0 = new Prestador();
      Autonomo autonomo0 = prestador0.getAutonomo();
      assertNull(autonomo0);
  }
}
