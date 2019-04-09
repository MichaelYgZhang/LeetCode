#!/bin/bash
# 统计英文单词出现的个数并按照倒叙排序，单词在前，数量在后，比如出现 the 10
cat words.txt
#tr: translate characters 替换 ' ' 为 \n 换行
| tr ' ' '\n'
# sort 排序
| sort
# uniq -c 统计出现的次数，比如the出现10次，结果是 10 the
| uniq -c
# sort 倒序，题目意思是倒序
| sort -r
# 按照题目打印，先打印单词，后打印次数
| awk '{print $2,$1}'
