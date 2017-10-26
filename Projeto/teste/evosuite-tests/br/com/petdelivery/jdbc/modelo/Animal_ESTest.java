/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 25 18:23:39 GMT 2017
 */

package br.com.petdelivery.jdbc.modelo;

import org.junit.Test;
import static org.junit.Assert.*;
import br.com.petdelivery.jdbc.modelo.Animal;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Animal_ESTest extends Animal_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Animal animal0 = new Animal();
      animal0.setVacinas("A-<V*:%Bc[6%BHe%2");
      assertEquals("A-<V*:%Bc[6%BHe%2", animal0.getVacinas());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Animal animal0 = new Animal();
      animal0.setPorte((String) null);
      assertNull(animal0.getGenero());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Animal animal0 = new Animal();
      Boolean boolean0 = new Boolean(false);
      animal0.setPedigree(boolean0);
      assertNull(animal0.getPorte());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Animal animal0 = new Animal();
      animal0.setNome("");
      assertEquals("", animal0.getNome());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Animal animal0 = new Animal();
      Long long0 = animal0.getId_usuario();
      animal0.setId_usuario(long0);
      assertNull(animal0.getNome());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Animal animal0 = new Animal();
      animal0.setId_animal((Long) null);
      assertNull(animal0.getComportamento());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Animal animal0 = new Animal();
      animal0.setGenero("QS[.1aQ4jYBe;S/");
      assertNull(animal0.getPorte());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Animal animal0 = new Animal();
      byte[] byteArray0 = new byte[1];
      animal0.setFoto(byteArray0);
      assertNull(animal0.getNome());
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Animal animal0 = new Animal();
      animal0.setComportamento("");
      assertNull(animal0.getPorte());
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Animal animal0 = new Animal();
      String string0 = animal0.getVacinas();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Animal animal0 = new Animal();
      String string0 = animal0.getPorte();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Animal animal0 = new Animal();
      Boolean boolean0 = animal0.getPedigree();
      assertNull(boolean0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Animal animal0 = new Animal();
      String string0 = animal0.getNome();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Animal animal0 = new Animal();
      Long long0 = animal0.getId_usuario();
      animal0.setId_raca(long0);
      assertNull(animal0.getId_usuario());
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Animal animal0 = new Animal();
      Long long0 = animal0.getId_raca();
      assertNull(long0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Animal animal0 = new Animal();
      Long long0 = animal0.getId_animal();
      assertNull(long0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Animal animal0 = new Animal();
      String string0 = animal0.getGenero();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Animal animal0 = new Animal();
      byte[] byteArray0 = animal0.getFoto();
      assertNull(byteArray0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Animal animal0 = new Animal();
      String string0 = animal0.getComportamento();
      assertNull(string0);
  }
}