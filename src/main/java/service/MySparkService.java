package service;

import data.DummyMyDataProvider;
import data.MyDataProvider;
import data.MyFileDataProvider;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import javax.ws.rs.NotSupportedException;

public class MySparkService<T> {

    @NonNull
    private String appName;
    @NonNull
    private String master;
    @NonNull
    private MyDataProvider<T> dataProvider;

    private SparkConf sparkConf;

    @Getter
    private JavaSparkContext sparkContext;

    @Builder
    public MySparkService(@NonNull String appName, @NonNull String master, @NonNull MyDataProvider dataProvider) {
        this.appName = appName;
        this.master = master;
        this.dataProvider = dataProvider;
        //
        initSparkConfAndContext();
    }

    private void initSparkConfAndContext() {
        this.sparkConf =  new SparkConf();
        this.sparkConf
                .setAppName(this.appName)
                .setMaster(this.master);
        this.sparkContext = new JavaSparkContext(this.sparkConf);
    }

    public JavaRDD<T> getData() {
        if (dataProvider instanceof DummyMyDataProvider){
            return this.sparkContext.parallelize(dataProvider.retrieveData());
        } else if (dataProvider instanceof MyFileDataProvider){
            return (JavaRDD<T>) this.sparkContext.textFile(((MyFileDataProvider) dataProvider).getFileName());
        }
        throw new NotSupportedException();
    }

    public void close(){
        this.sparkContext.close();
    }
}
