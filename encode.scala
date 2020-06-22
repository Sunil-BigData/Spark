package com.inceptez.datasecurity

/*36. Inside the class mask create a private val as prefixstr=”aix” and a method
revEncode(str:String):String={return the prefixstr+reverse of str value}*/

class encode 
{
   val prefixstr = "aix"
   
   def revEncode(str:String):String=
   {
     return prefixstr + str.reverse
   } /*End of method*/
   
   def revDecode(destr:String):String=
   {
     return destr.replace("aix", "").reverse
   }
} /*End of class*/