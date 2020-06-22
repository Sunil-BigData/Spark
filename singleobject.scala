package com.inceptez.datasecurity

/*37. Create a scala object namely singleobject, create a main method, create objects like
val objmask=new com.inceptez.datasecurity.mask;
val objencode=new com.inceptez.datasecurity.endecode;
38. Create an array with 3 names like Array(“arun”,”ram kumar”,”yoga murthy”), loop the array
elements, apply hashMask(name) for all 3 elements and println of the masked values.
39. Loop the array created in above step and apply the revEncode(name) for all 3 elements and
println of the encoded values.
40. If possible create a decode function inside endecodeclass as revDecode and write a logic to
decode the encoded string in step 39.*/


object singleobject 
{
  def main(args:Array[String])=
  {
    val objmask = new com.inceptez.datasecurity.mask;
    val objencode = new com.inceptez.datasecurity.encode;

    var arr = Array("arun","ram kumar","yoga murthy")

    println("Following are the results:")
    println()
    for (x<-arr)
    {
      println("Masked value of "+ x + " is "+ objmask.hashMask(x))
      println("Encoded value of "+ x + " is "+ objencode.revEncode(x))
      println("Decoded value of "+ objencode.revEncode(x) + " is " + objencode.revDecode(objencode.revEncode(x)))
      println()
    }

  } /*End of main*/
} /*End of object*/

