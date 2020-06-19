package sparkexam;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class SparkLab3 {

	public static void main(String[] args) {
		JavaSparkContext sc = SparkUtils.getSparkContext("lab3");
		doLab(sc);
		sc.stop();
	}
	
	public static void doLab(JavaSparkContext sc) {
				
		JavaRDD<String> rdd1 = sc.textFile("hdfs://192.168.111.120:9000/edudata/tomcat_access_log.txt");
		JavaRDD<String> rdd1_1 = rdd1.map(line -> line.split("- -")[1]);
		JavaRDD<String> rdd2 = rdd1_1.map(line -> line.substring(14, 16));
		JavaPairRDD<String, Integer> rdd3 = rdd2.mapToPair(data -> new Tuple2<String, Integer>(data, 1));
		JavaPairRDD<String, Integer> rdd4 = rdd3.reduceByKey((x, y)-> x+y);
		JavaPairRDD<Integer, String> rdd5 = rdd4.mapToPair(data -> data.swap());
		JavaPairRDD<Integer, String> rdd6 = rdd5.sortByKey(false);
		rdd6.foreach(data -> System.out.println(data._1 + " : " + data._2));
		System.out.printf("제일 많이 요청된 시간은 %s 시간대입니다.", rdd6.first()._2);
		
	}

}
