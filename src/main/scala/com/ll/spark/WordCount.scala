package com.ll.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf = new SparkConf().setAppName("WC").setMaster("local[*]")

    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc = new SparkContext(conf)

    //3.读取指定位置文件
    val lineRdd: RDD[String] = sc.textFile("input")

    //4.读取的一行一行的数据分解成为一个一个的单词（扁平化flatMap)
    val wordRdd:RDD[String] = lineRdd.flatMap(_.split(" "))

    //5.将数据转化结构
    val wordToOneRdd = wordRdd.map((_,1))

    //6.将转换结构后的数据进行聚合处理
    val wordToSumRdd = wordToOneRdd.reduceByKey(_+_)

//    wordToSumRdd.saveAsTextFile(args(1))

    //7.将统计结果采集到控制台打印
    val wordToCountArray:Array[(String, Int)] = wordToSumRdd.collect()
    wordToCountArray.foreach(println)
    //一行搞定
//    sc.textFile(args(0)).flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).saveAsTextFile(args(1))
    //8.关闭连接
    sc.stop()

  }
}
