/*
 * This file was automatically generated by EvoSuite
 * Thu Oct 26 21:27:49 GMT 2017
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
      animal0.setVacinas("\u0006RP:B3w4N;``PC%7");
      String string0 = animal0.getVacinas();
      assertEquals("\u0006RP:B3w4N;``PC%7", string0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Animal animal0 = new Animal();
      animal0.setVacinas("");
      String string0 = animal0.getVacinas();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Animal animal0 = new Animal();
      animal0.setPorte(",U[UbEr4/'I5%");
      String string0 = animal0.getPorte();
      assertEquals(",U[UbEr4/'I5%", string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Animal animal0 = new Animal();
      animal0.setPorte("");
      String string0 = animal0.getPorte();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Animal animal0 = new Animal();
      Boolean boolean0 = Boolean.valueOf(true);
      animal0.setPedigree(boolean0);
      Boolean boolean1 = animal0.getPedigree();
      assertTrue(boolean1);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Animal animal0 = new Animal();
      animal0.setNome(",U[UbEr4/'I5%");
      String string0 = animal0.getNome();
      assertEquals(",U[UbEr4/'I5%", string0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Animal animal0 = new Animal();
      Long long0 = new Long((-659L));
      animal0.setId_usuario(long0);
      Long long1 = animal0.getId_usuario();
      assertEquals((-659L), (long)long1);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Animal animal0 = new Animal();
      Long long0 = Long.getLong("", 3327L);
      animal0.setId_usuario(long0);
      Long long1 = animal0.getId_usuario();
      assertEquals(3327L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Animal animal0 = new Animal();
      Long long0 = new Long(0L);
      animal0.setId_raca(long0);
      Long long1 = animal0.getId_raca();
      assertEquals(0L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Animal animal0 = new Animal();
      Long long0 = new Long(2056L);
      animal0.setId_raca(long0);
      Long long1 = animal0.getId_raca();
      assertEquals(2056L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Animal animal0 = new Animal();
      Long long0 = new Long((byte) (-75));
      animal0.setId_raca(long0);
      Long long1 = animal0.getId_raca();
      assertEquals((-75L), (long)long1);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Animal animal0 = new Animal();
      Long long0 = new Long(0L);
      animal0.setId_animal(long0);
      Long long1 = animal0.getId_animal();
      assertEquals(0L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Animal animal0 = new Animal();
      Long long0 = new Long((-1L));
      animal0.setId_animal(long0);
      Long long1 = animal0.getId_animal();
      assertEquals((-1L), (long)long1);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Animal animal0 = new Animal();
      animal0.setGenero("%-v\"Mrz[");
      String string0 = animal0.getGenero();
      assertEquals("%-v\"Mrz[", string0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Animal animal0 = new Animal();
      byte[] byteArray0 = new byte[0];
      animal0.setFoto(byteArray0);
      byte[] byteArray1 = animal0.getFoto();
      assertSame(byteArray1, byteArray0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Animal animal0 = new Animal();
      animal0.setComportamento(",U[UbEr4/'I5%");
      String string0 = animal0.getComportamento();
      assertEquals(",U[UbEr4/'I5%", string0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Animal animal0 = new Animal();
      animal0.setComportamento("");
      String string0 = animal0.getComportamento();
      assertEquals("", string0);
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
      String string0 = animal0.getVacinas();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Animal animal0 = new Animal();
      Long long0 = new Long(0L);
      animal0.setId_usuario(long0);
      Long long1 = animal0.getId_usuario();
      assertEquals(0L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Animal animal0 = new Animal();
      Long long0 = new Long(1L);
      animal0.setId_animal(long0);
      Long long1 = animal0.getId_animal();
      assertEquals(1L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Animal animal0 = new Animal();
      Long long0 = animal0.getId_usuario();
      assertNull(long0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Animal animal0 = new Animal();
      Boolean boolean0 = Boolean.FALSE;
      animal0.setPedigree(boolean0);
      Boolean boolean1 = animal0.getPedigree();
      assertFalse(boolean1);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      Animal animal0 = new Animal();
      String string0 = animal0.getComportamento();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      Animal animal0 = new Animal();
      String string0 = animal0.getPorte();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      Animal animal0 = new Animal();
      animal0.setGenero("");
      String string0 = animal0.getGenero();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      Animal animal0 = new Animal();
      byte[] byteArray0 = new byte[4];
      animal0.setFoto(byteArray0);
      byte[] byteArray1 = animal0.getFoto();
      assertArrayEquals(new byte[] {(byte)0, (byte)0, (byte)0, (byte)0}, byteArray1);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      Animal animal0 = new Animal();
      String string0 = animal0.getNome();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      Animal animal0 = new Animal();
      Long long0 = animal0.getId_raca();
      assertNull(long0);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      Animal animal0 = new Animal();
      animal0.setNome("");
      String string0 = animal0.getNome();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      Animal animal0 = new Animal();
      Long long0 = animal0.getId_animal();
      assertNull(long0);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      Animal animal0 = new Animal();
      Boolean boolean0 = animal0.getPedigree();
      assertNull(boolean0);
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      Animal animal0 = new Animal();
      String string0 = animal0.getGenero();
      assertNull(string0);
  }
}
