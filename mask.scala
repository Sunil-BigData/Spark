package com.inceptez.datasecurity

/*35. Inside the class mask create a private val as addhash=100 and a method
hashMask(str:String):Int={return the hashcode of str+addhash value}*/

class mask 
{
  val addhash=100
  def hashMask(str:String):Int=
  {
    return (str+addhash).hashCode() 
  } /*End of method*/
} /*End of class*/