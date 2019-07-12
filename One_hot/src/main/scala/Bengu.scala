package Scala
//mport scala.util.Random
import chisel3._
 import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}
import scala.util.Random


class Bengu extends Module{
  val io =IO(new Bundle{
  val a_x = Input(UInt(4.W))
  val b_x = Input(UInt(4.W))
  val c_x = Input(UInt(4.W))
  val out =Output(UInt(4.W))
  })
   io.out := (io.a_x *io.c_x)/io.b_x
}




class BenguTester (c:Bengu) extends PeekPokeTester(c){
 
   for (i <- 0 until 100) {

   val a_x =Random.nextInt(16)
   val b_x =Random.nextInt(16)
   val c_x =Random.nextInt(16)
 
	poke(c.io.a_x ,a_x)
	poke(c.io.b_x, b_x)
	poke(c.io.c_x, c_x)
 expect(c.io.out ,(a_x*c_x)/b_x)
  assert (Driver(()=> new Bengu) {c => new BenguTester (c)})
}

}
