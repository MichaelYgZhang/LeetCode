package com.leetcode.bigData;

import java.io.*;
import java.util.*;

/**
 * 两个大文件比较不同
 * 1. createBigFile
 * 2. compartorFile 借鉴mapReduce思想
 *      a. 利用hash分桶，估算桶的个数
 *      b. 分别取出每个桶的文件，分别比较，输出结果到一个文件中
 *
 */
public class DiffFile {
    static String path = "/Users/michael/Study/java/LeetCode/src/com/bigData";
    static String filePath = path + "/bigFile01.txt";
    static String filePath2= path + "/bigFile02.txt";
    /**
     * 创建两个超大文件
     */
    public static void createFile(int fileSize) {
        long start = System.currentTimeMillis();
        try {
            File file = new File(filePath);
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            File file2 = new File(filePath2);
            FileWriter fileWriter2 = new FileWriter(filePath2);
            BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
            while (true) {
                String value = UUID.randomUUID().toString().replace("-", "")+"\n";
                bufferedWriter.write(value);
                bufferedWriter2.write(value);
                if (file.length() / 1024 / 1024 == fileSize) {
                    break;
                }
            }
            System.out.println("写文件路径:" + filePath + "\n"
            + "文件大小:" + file.length() / 1024 /1024 +"M\n"
            + "耗时:" + (System.currentTimeMillis() - start)/1000 + "s\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void splitBigFile(int splitFileLength, String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int p = RSHash(line) % splitFileLength;
                line = line + "\n";
                writerFile(getPath(p + ".txt"), line.toCharArray());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    static Set<String> set = new HashSet<String>();
    public static void getOne(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bufferedReader.readLine())!=null) {
                if (set.contains(line)) {
                    set.remove(line);
                    continue;
                } else {
                    set.add(line);
                }
            }
            if (set.isEmpty()) {
                System.out.println("无！！！！！！");
                return;
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + "/oneData.txt", true));
            for (String one : set) {
                System.out.println(one);
                bufferedWriter.write(one + "\n");
            }
            System.out.println("one data size: " + set.size());
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //布隆过滤 找不同的数据
    public static void bloomFiltersGetOne(String fileName) {
        //guava
//        BloomFilter<String> bloomFilter = BloomFilter.create(
//                Funnels.stringFunnel(Charset.defaultCharset()),
//                500,
//                0.00001);
        //源文件切分为2个，假设: a为最终文件 b为初始化文件
        //利用BloomFilter读入a做初始化，然后再读b判断，如果不在BloomFilter中则输出到某个目标文件中，目标文件就是最终丢失的数据
    }
    
    public static List<String> getFiles() {
        List<String> files = new ArrayList<>();
        File file = new File(path);
        File[] filesTemp = file.listFiles();
        for (File f : filesTemp) {
            if (f.getName().matches("[0-9].txt")) {
                files.add(f.getName());
            }
        }
        return files;
    }
    
    public static void main(String[] args) {
        createFile(50);
        // 文件分桶 hash 10个文件
        splitBigFile(5, filePath);
        splitBigFile(5, filePath2);
        //找出只出现一次的ip
        //getFiles();
        //getOne(path + "/0.txt");
    }



    public static String getPath(String p) {
        return path + "/" + p;
    }

    public static void writerFile(String path, char[] chars) {
        File file = new File(path);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            if (file.exists()) {
                bufferedWriter.write(chars);
            } else {
                file.createNewFile();
                bufferedWriter.write(chars);
            }
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int RSHash(String str)
    {
        int b  = 378551;
        int a  = 63689;
        int hash = 0;
        for(int i = 0; i < str.length(); i++)
        {
            hash = hash * a + str.charAt(i);
            a  = a * b;
        }
        return (hash & 0x7FFFFFFF);
    }

}
