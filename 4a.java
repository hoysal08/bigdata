package pgm4a;
import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;
public class wc
{
//mapper code
public static class Map extends MapReduceBase implements
Mapper<LongWritable,Text,Text,IntWritable>{
private final static IntWritable one = new IntWritable (1);
@Override
public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable>
output, Reporter reporter)
throws IOException
{
String valueString = value.toString ();
String[] data = valueString.split(",");
output.collect(new Text(data[2]), one);
}
}
//reducer code
public static class Reduce extends MapReduceBase implements Reducer<Text,
IntWritable, Text, IntWritable>{
@Override
public void reduce(Text t_key , Iterator<IntWritable> values, OutputCollector<Text,
IntWritable> output, Reporter reporter)
throws IOException
{
int finaluserCount = 0 ;
Text mykey = t_key ;
while(values.hasNext())
{
IntWritable value = values.next();
finaluserCount += value.get();
}
output.collect(mykey, new IntWritable(finaluserCount));
}
}
public static void main(String[] args) throws IOException
{
JobConf conf = new JobConf(wc.class);
conf.setJobName("wordcount");
conf.setOutputKeyClass(Text.class);
conf.setOutputValueClass(IntWritable.class);
conf.setMapperClass(Map.class);
conf.setCombinerClass(Reduce.class);
conf.setReducerClass(Reduce.class);
conf.setInputFormat(TextInputFormat.class);
conf.setOutputFormat(TextOutputFormat.class);
FileInputFormat.setInputPaths(conf, new Path(args[0]));
FileOutputFormat.setOutputPath(conf, new Path(args[1]));
JobClient.runJob(conf);
}
}