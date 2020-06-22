package org.inceptez.scalaprograms

import scala.Array._

object mylearning 
{
  def main(args:Array[String]) 
  {
    //var are mutable and val is immutable
    val bonus:Int = 10000
    var salary:Int = 100000
    
    //val bonus=20000
    
    salary=salary+bonus
    
    println("Emp Salary is :" + salary)    
    
    //static definition and dynamic inference
    var x:String="Sunil"
    //x=1
    
    var y=10.2
    //y="Sunil"
    
    //conditional structure using nested if,else if and else then nested if
    
    
    //Break usage
    import util.control.Breaks.{break,breakable}
    breakable
    {
      for (i<-1 to 10)
      {
        println("value of i " + i)
        if(i>5)
          break
      } /* End of for */
    } /* End of breakable */    
    
    /* Collections: Seq, Array, List, Map and Set */
    /*20. Create an array, list and prove mutability and immutability and non-resizable properties.*/
    
    var seq=Seq(1,2,3,4,5)
    println(seq)
    
    var seqarr=Seq(1,2,3,4,5).toArray
    println(seqarr(2))
    
    var arr=Array(10,20,30)
    println(arr(0))
    
    var lst=List("Sunil","BigData")
    println(lst(0))
    
    /* Proving mutable */
    arr(0)=50
    println(arr(0))
    
    seqarr(2)=12
    println("seqarr " + seqarr(2))

    /*    26. Write a program to create an Int List with 5 different values using range and sum all the values*/
    var intlst=scala.collection.immutable.Range(1,10,2)
    println("list sum " + intlst.sum)
    
    /*27. Write a program to create string list to store the values of Spark,Scala,Python,Java,Hadoop and
count the number of elements in the List*/

    var strlst=List("Spark","Scala","Python","Java","Hadoop")
    println("Result of elements " + strlst.size)
    
    /*28. Write a program to store (China,Beijing),(India,New Delhi),(USA,Washington),(UK,London)
using Map*/

    var capitals = Map("China" -> "Beijing" , "India" -> "New Delhi")
    var Indiacap = capitals("India") 
    println("India Capital is " + Indiacap)
    
    println("Keys " + capitals.keys)
    println("values " + capitals.values)
    
    /*30. Take only countries and store in an array and use foreach and println to print line by line of
elements.*/

    
    var caparr:Array[String] = capitals.keys.toArray
    println("Capitals Array ")
    caparr.foreach { println }
    
/*31. Take only countries and store in an set and use foreach and println to print line by line of
elements.*/
    
    var capset = scala.collection.mutable.Set(capitals.values).toArray
    println("Capitals Set ")
    capset.foreach { println }
    
        
    var ran=range(0,10,2)
    ran.foreach { println }
    
    /* Proving immutable */
    //lst(0)="Ganeshan"
    //seq(2)=11
    println(ran(1))
    ran(1)=3
    println(ran(1))
    /* Non-Resizable */    
    //arr+=100
    //arr-=2
    
    //lst+=100

    var arrbuff=scala.collection.mutable.ArrayBuffer("A","B","C")
    var lstbuff=scala.collection.mutable.ListBuffer(11,22,33)
    
    println(arrbuff)
    println(lstbuff)
    
    arrbuff+="D"
    lstbuff+=44
    
    println(arrbuff)
    println(lstbuff)
    
    arrbuff-="D"
    lstbuff-=44
    
    println(arrbuff)
    println(lstbuff)
    
    arrbuff(1)="S"
    lstbuff(1)=66
    
    println(arrbuff)
    println(lstbuff)
    
    case class casecls(empid:Int,empname:String,empdept:String,empsal:Int)
    var caseclsval = casecls(1,"SunilG","BigD",100000)
    
    println("Result   Caseclass " + caseclsval)
    println("caseclass name " + caseclsval.empname)
    
    //caseclsval.empid = 6
    
    
    var tup=(1,"Sunil","BigData",100000)
    println(tup)
    
    var tup1=(tup._2,tup._4)
    println(tup1)
    
    var maxarr=Array(2,3,1,5,4)
    println("Max Value is " + maxarr.max)
    
    var maxminarr=Array(maxarr.max,maxarr.min)
    maxminarr.foreach { println }
    
    //maxarr=Array()
    println(maxarrval(maxarr))
    
    
  } /* End of main */

    def maxarrval(a:Array[Int]):Any=
    {
      if(a.isEmpty)
        return("Array is empty")
      else
        return ("Max value from func. " + a.max)
    }

} /* End of Object */

