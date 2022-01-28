# MySpark
This application is for learning what is Spark and how to use it in common job.

URL EXAMPLE : https://www.youtube.com/watch?v=MWUV801ZWUw


# What's going on here? 
Main class Main



#Possible errors
1. While running project got the error "Caused by: java.lang.ClassNotFoundException: org.apache.spark.SparkConf"
   Solution:
   1. change dependencies in build.gradle compileOnly to implementation 
2. Caused by: java.io.FileNotFoundException: HADOOP_HOME and hadoop.home.dir are unset.
    Solution: 
    1. set variable HADOOP_HOME=D:\WORK\Hadoop
    2. Download winutils.exe + libraries for windows into bin directory
    3. From here: https://github.com/steveloughran/winutils
    4. restart
    


