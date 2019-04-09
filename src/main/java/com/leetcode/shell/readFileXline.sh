#!/bin/bash
# 题目: 读取一个文件的第n行并输出
# 读取第x行文件
xLine=$1
# 读取的文件名
fileName=$2
# print
echo "读取的文件: ${fileName} 的第 ${xLine} 行."
# cnt 计数
cnt=0
while read line
do
    # 注意这里不能写成 cnt=`expr $cnt+1`
    let 'cnt=cnt+1'
    if [ $cnt -eq $xLine ]
        echo $line
        exit 0
    fi
done < $fileName