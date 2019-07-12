import chisel3._
import chisel3.util._



class Pipo extends Module{
  val io =IO(new Bundle{
    
    val mul_out =Input(UInt(4.W))
    val sub_out =Input(UInt(4.W))
    val add_out =Input(UInt(4.W))
    val div_out =Output(UInt(4.W))
    val out =Output(UInt(4.W))

  })
    
   io.mul_out :=5.U*2.U
    io.sub_out := 4.U-1.U
   io.add_out := 7.U+5.U
   io.div_out := 9.U/3.U
   io.out := (io.mul_out,io.sub_out,io.add_out,io.div_out)
    

}


