package com.leetcode;

/**
 * SQL题目
 * 找出以下出现2次及以上的邮箱
 * id   Email
 * 1    a@b.com
 * 2    c@d.com
 * 3    a@b.com
 * 输出: a@b.com
 *
 * select Email from Person group by Email having count(Email) > 1;
 */

public class DuplicateEmails {
}
