import chisel3._
import chisel3.iotester.{PeekPokeTester, Driver() ,ChiselFlatSpec}
import chisel3.util._


class Onehot extends Module{
  val io =IO(new Bundle{
  val a = Input(UInt(4.W))
  val b =Input(UInt(4.W))
  val out =OutputUInt(4.w))
 })
 io.out := (~a&b)|(a&~b)0000

}
class OnehotTester (c:Onehot) extends PeekPokeTester(c){

  val cycle =10

 for(i <-0 until cycle ){
  val a =Random.nextInt(12)
  val b =Random.nextInt(12) 
  
poke(c.io.a ,a)
poke (c.io.b ,b)
 step(2)
expect(c.oi.out ,(~a&b)|(a&~b))
}
}

