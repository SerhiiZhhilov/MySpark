import data.DummyMyDataProvider;
import data.MyDataProvider;
import data.MyFileDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.apache.spark.api.java.JavaRDD;
import service.MySparkService;

@Slf4j
public class Main {


    public static void main(String[] args) {
        log.info("------------------------------------------------------------------");
        dummyData();
        log.info("------------------------------------------------------------------");
        fileData();
    }


    private static void fileData(){
        log.info("------- 0. Start for dummy data");

        log.info("------- 1. Data dummy is populated");
        String fileName = "src/main/resources/fileData.txt";
        MyDataProvider<String> fileProvider = MyFileDataProvider
                .builder()
                .fileName(fileName)
                .build();

        log.info("------- 2. Init spark service using my builder");
        MySparkService sparkService = MySparkService
                .builder()
                .appName("startingSparkFile")
                .master("local[*]")
                .dataProvider(fileProvider)
                .build();
        log.info("------- 3. get data from spark context");
        JavaRDD<String> listData = sparkService.getData();

        log.info("------- 4. Print data");
        listData
                .collect()
                .forEach(item -> {log.info(String.valueOf(item));});

        log.info("------- 5. Close spark context");
        sparkService.close();
        log.info("------- 6. Spark context has been closed");

        log.info("------- 7. End for dummy data");

    }

    private static void dummyData(){
        log.info("------- 0. Start for dummy data");

        log.info("------- 1. Data dummy is populated");
        MyDataProvider<Double> dummyDataProvider = new DummyMyDataProvider();

        log.info("------- 2. Init spark service using my builder");
        MySparkService sparkService = MySparkService
                .builder()
                .appName("startingSparkDummy")
                .master("local[*]")
                .dataProvider(dummyDataProvider)
                .build();

        log.info("------- 3. get data from spark context");
        JavaRDD<Double> listData = sparkService.getData();

        log.info("------- 4. Print data");
        listData
                .collect()
                .forEach(item -> {log.info(String.valueOf(item));});


        log.info("------- 5. Close spark context");
        sparkService.close();
        log.info("------- 6. Spark context has been closed");

        log.info("------- 7. End for dummy data");
    }
}
