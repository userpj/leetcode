Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

抄答案

```java
public class Solution {
    public String intToRoman(int num) {
        // values和strs数组的index上是对应的。相当于一个mapping的对照。
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        // 从最大的roman字母(或字母pair)开始使用，然后次大，然后次次大，直到能完全表示当前int为止。
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                // 每用一次字母strs[i]，num的值都有一份values[i]得到了转化
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
}
```



Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

```java
public class Solution {
    
    public int romanToInt(String s) {
        char[] cs = s.toCharArray();
        int i = 0, val = 0;
        
        while (i<cs.length) {
            // System.out.print(cs[i]);
            switch (cs[i++]) {
                case 'M': val+=1000; break;
                case 'D': val+=500; break;
                case 'C':
                    if (i<cs.length && cs[i]=='D') { val+=400; i++; }
                    else if (i<cs.length && cs[i]=='M') { val+=900; i++; }
                    else val+=100;
                    break;
                case 'L': val+=50; break;
                case 'X':
                    if (i<cs.length && cs[i]=='L') { val+=40; i++; }
                    else if (i<cs.length && cs[i]=='C') { val+=90; i++; }
                    else val+=10;
                    break;
                case 'V': val+=5; break;
                case 'I':
                    if (i<cs.length && cs[i]=='V') { val+=4; i++; }
                    else if (i<cs.length && cs[i]=='X') { val+=9; i++; }
                    else val+=1;
                    break;
            }
            // System.out.println(" "+val);
        }
        
        return val;
    }
}
```

