# apache-common-lang3

参考 [javaDoc3.6](https://commons.apache.org/proper/commons-lang/javadocs/api-release/index.html)

## 1 包结构

包名 | 描述
--- | ---
org.apache.commons.lang3 | 提供高度可重用的静态实用程序方法，主要涉及向java.lang类添加值。
org.apache.commons.lang3.arch | 提供类来处理os.arch系统属性的值。
org.apache.commons.lang3.builder | 协助创建一致的equals()，toString()，hashCode()和compareTo()方法。
org.apache.commons.lang3.concurrent	| 为多线程编程提供支持类。
org.apache.commons.lang3.event	| 提供一些有用的基于事件的工具。
org.apache.commons.lang3.exception	| 提供异常处理功能。
org.apache.commons.lang3.math	| 扩展业务数学类的java.math。
org.apache.commons.lang3.mutable | 为原始值和Object提供类型可变包装。
org.apache.commons.lang3.reflect	| 积累java.lang.reflect API的常见高级使用
~~org.apache.commons.lang3.text~~	| ~~提供用于处理和处理文本的类，部分作为java.text的扩展。~~ 已弃用，参考 apache-commons-text
org.apache.commons.lang3.text.translate	| 用于从一组较小的构建块创建文本翻译程序的API。
org.apache.commons.lang3.time	| 提供使用日期和持续时间的类和方法。
org.apache.commons.lang3.tuple	| 元组类，从版本3.0中的Pair类开始。

## 2 常用工具类

### 2.1 StringUtils 字符串处理类

> StringUtils主要包含以下功能：

* IsEmpty/IsBlank - checks if a String contains text
* Trim/Strip - removes leading and trailing whitespace
* Equals/Compare - compares two strings null-safe
* startsWith - check if a String starts with a prefix null-safe
* endsWith - check if a String ends with a suffix null-safe
* IndexOf/LastIndexOf/Contains - null-safe index-of checks
* IndexOfAny/LastIndexOfAny/IndexOfAnyBut/LastIndexOfAnyBut - index-of any of a set of Strings
* ContainsOnly/ContainsNone/ContainsAny - does String contains only/none/any of these characters
* Substring/Left/Right/Mid - null-safe substring extractions
* SubstringBefore/SubstringAfter/SubstringBetween - substring extraction relative to other strings
* Split/Join - splits a String into an array of substrings and vice versa
* Remove/Delete - removes part of a String
* Replace/Overlay - Searches a String and replaces one String with another
* Chomp/Chop - removes the last part of a String
* AppendIfMissing - appends a suffix to the end of the String if not present
* PrependIfMissing - prepends a prefix to the start of the String if not present
* LeftPad/RightPad/Center/Repeat - pads a String
* UpperCase/LowerCase/SwapCase/Capitalize/Uncapitalize - changes the case of a String
* CountMatches - counts the number of occurrences of one String in another
* IsAlpha/IsNumeric/IsWhitespace/IsAsciiPrintable - checks the characters in a String
* DefaultString - protects against a null input String
* Rotate - rotate (circular shift) a String
* Reverse/ReverseDelimited - reverses a String
* Abbreviate - abbreviates a string using ellipsis or another given String
* Difference - compares Strings and reports on their differences
* LevenshteinDistance - the number of changes needed to change one String into another

> StringUtils类定义了与String处理相关的字段：

* null - 对象为 null
* empty - 长度为0的String对象，即 ""
* space - 空格字符 (' '，char 32)
* whitespace - Character.isWhitespace（char）定义的字符
* trim - String.trim() 中的字符 <= 32

### 2.2 DateUtils 时间处理

> DateUtils包含许多常见的操作日期或日历的方法。

> 提供了几种添加到Date对象的方法，形式为addXXX（Date date，int amount）。 
请注意，这些方法在内部使用日历（默认时区和区域设置），并可能受到夏令时变更（DST）的影响。



### 2.3 数学计算

### 2.4 反射工具

