package sparkexam;

import java.util.Arrays;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class SparkLab1 {

	public static void main(String[] args) {
		JavaSparkContext sc = SparkUtils.getSparkContext("lab1");
		doLab(sc);
		sc.stop();
	}
	
	public static void doLab(JavaSparkContext sc) {
				
		JavaRDD<String> rdd1 = sc.textFile("hdfs://192.168.111.120:9000/edudata/product_click.log");
		JavaRDD<String> rdd2 = rdd1.flatMap(line -> Arrays.asList(line.split("\\s")[1]).iterator());
		JavaPairRDD<String, Integer> rdd3 = rdd2.mapToPair(word -> new Tuple2<String, Integer>(word, 1));
		JavaPairRDD<String, Integer> rdd5 = rdd3.reduceByKey((x, y)-> x+y);		
		JavaPairRDD<String, Integer> rdd6 = rdd5.sortByKey();
		rdd6.foreach((data-> System.out.printf("(%s,%d)\n", data._1, data._2)));		

	}

}
