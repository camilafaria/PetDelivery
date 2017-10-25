/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 25 18:25:30 GMT 2017
 */

package br.com.petdelivery.jdbc.modelo;

import org.junit.Test;
import static org.junit.Assert.*;
import br.com.petdelivery.jdbc.modelo.Busca;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Busca_ESTest extends Busca_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Busca busca0 = new Busca();
      busca0.setServico("<z=S*XsGj1(Sq7)^4G");
      assertNull(busca0.getBairro());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Busca busca0 = new Busca();
      busca0.setPreco(0.0);
      assertNull(busca0.getCondicoes());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Busca busca0 = new Busca();
      busca0.setNota((Long) null);
      assertNull(busca0.getBairro());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Busca busca0 = new Busca();
      busca0.setNome(">;?;pT");
      assertNull(busca0.getNota());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Busca busca0 = new Busca();
      Long long0 = Long.valueOf((-2013L));
      busca0.setId(long0);
      assertEquals((-2013L), (long)busca0.getId());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Busca busca0 = new Busca();
      busca0.setDelivery(false);
      assertFalse(busca0.isDelivery());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Busca busca0 = new Busca();
      busca0.setCondicoes("");
      assertNull(busca0.getBairro());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Busca busca0 = new Busca();
      busca0.setBairro((String) null);
      assertNull(busca0.getBairro());
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Busca busca0 = new Busca();
      boolean boolean0 = busca0.isDelivery();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Busca busca0 = new Busca();
      String string0 = busca0.getServico();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Busca busca0 = new Busca();
      double double0 = busca0.getPreco();
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Busca busca0 = new Busca();
      Long long0 = busca0.getNota();
      assertNull(long0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Busca busca0 = new Busca();
      String string0 = busca0.getNome();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Busca busca0 = new Busca();
      Long long0 = busca0.getId();
      assertNull(long0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Busca busca0 = new Busca();
      String string0 = busca0.getCondicoes();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Busca busca0 = new Busca();
      String string0 = busca0.getBairro();
      assertNull(string0);
  }
}
