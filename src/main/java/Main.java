import lombok.extern.slf4j.Slf4j;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {



    public static void main(String[] args) {
        log.info("-----start----");

        List<Double> inputData = new ArrayList<>();
        inputData.add(35.5);
        inputData.add(36.9);
        inputData.add(25.54655);
        inputData.add(15.23);
        inputData.add(64.5667);
        log.info("1. Data filled");

        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName("startingSpark").setMaster("local[*]");
        log.info("2. Spark configuration have been created");

        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
        log.info("3. Spark context have been initialized");

        JavaRDD<Double> myRdd = sparkContext.parallelize(inputData);
        log.info("4. Spark RDD created");



        sparkContext.close();
        log.info("5. Spark context has been closed");

        log.info("-----end----");
    }
}
