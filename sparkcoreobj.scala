package org.inceptez.sparkusecases

object sparkcoreobj 
{
  def main(args:Array[String])=
  {
    /* Initializing SparkConf & SparkContext for setting-up Spark Environment*/
    
    val Sparkconf = new org.apache.spark.SparkConf().setAppName("Sunil").setMaster("local[*]")
    val izsc = new org.apache.spark.SparkContext(Sparkconf)
        
/*		Steps:  
      1. create a hdfs filerdd from the file in a location /user/hduser/videolog/youtube_videos.tsv
      2. split the rows using tab ("\t") delimiter
      3. Remove the header record by filtering the first column value does not contains "id" into an rdd splitrdd
      4. display only first 10 rows in the screen from splitrdd.
      5. filter only Music category data from splitrdd into an rdd called music
      6. filter only duration>100 data from splitrdd into an rdd called longdur
      7. Union music and longdur rdd and find only distinct records into an rdd music_longdur
      8. Select only id, duration, codec and category by re ordering the fields like id,category,codec,duration into an rdd mapcolsrdd
      9. Select only duration from mapcolsrdd and find max duration by using max fuction.
      10. Select only codec from mapcolsrdd, convert to upper case and print distinct of it in the screen.
    Fields in the file: (id,duration,bitrate,bitrate(video),height,width,frame rate,frame rate(est.),codec,category)    
*/
    
    val filerdd = izsc.textFile("hdfs://localhost:54310/user/hduser/spark/videolog/youtube_videos.tsv")
    val maprdd = filerdd.map(x=>x.split("\t"))
    
    val splitrdd = maprdd.filter { x=>x(0)!=("id") }
    println("Result of first 10 rows from splitrdd")
    for(i<-splitrdd.take(10))
      println(i(0),i(1),i(2),i(3),i(4),i(5),i(6),i(7),i(8),i(9))
    
    println("Result of first 10 rows from musicrdd")  
    val musicrdd = splitrdd.filter(_.contains("Music"))
    for(i<-musicrdd.take(10))
      println(i(0),i(1),i(2),i(3),i(4),i(5),i(6),i(7),i(8),i(9))
    
    println("Result of first 10 rows from longdurrdd")  
    val longdurrdd = splitrdd.filter(x=>x(1).toInt>100)
    for(i<-longdurrdd.take(10))
      println(i(0),i(1),i(2),i(3),i(4),i(5),i(6),i(7),i(8),i(9))

    println("Result of first 10 rows from unionrdd")  
    val unionrdd = musicrdd.union(longdurrdd)
    for(i<-unionrdd.take(10))
      println(i(0),i(1),i(2),i(3),i(4),i(5),i(6),i(7),i(8),i(9))
       
    /*val music_longdurrdd = unionrdd.distinct*/
    
    val mapcolsrdd = splitrdd.map(x=>(x(0),x(9),x(8),x(1)))
    println("Result of first 10 rows from mapcolsrdd")
    mapcolsrdd.take(10).foreach(println)
    
    println("Maximum Duration value is " + mapcolsrdd.map(x=>(x._4).toInt).max)
    
    println("Result of distinct codec codes in UpperCase")
    val distrdd = mapcolsrdd.map(x=>(x._3).toUpperCase).distinct
    distrdd.collect.foreach(println)

    /*Using the split rdd created in the step 2 below, create another rdd called hashmaskrdd should
    return (id,maskedcategory) by passing id,hashMask(category) in the map method and print only
    first 20 tuples using take.*/
    println("Result of id,maskedcategory ")
    val hashmaskobj = new com.inceptez.datasecurity.mask  
    val hashmaskrdd = splitrdd.map { x => (x(0),hashmaskobj.hashMask(x(9)))}
    hashmaskrdd.take(20).foreach(println)
    
  } /* End of Main*/
} /* End of Object*/
