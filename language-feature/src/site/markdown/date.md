# java 8 日期/时间 学习

## 1 包结构定义

> Java 8日期/时间（ Date/Time）API是开发人员最受追捧的变化之一，
Java从一开始就没有对日期时间处理的一致性方法，
因此日期/时间API也是除Java核心API以外另一项倍受欢迎的内容。详情请参考[Java8 日期/时间（Date Time）API指南](http://www.importnew.com/14140.html)

> java 8 中新增加的java.time 包含对日期，时间，瞬间、持续时间操作的主要API。java.time.* 包结构如下：

包名 | 描述
--- | ---
java.time | 这是新的Java日期/时间API的基础包，所有的主要基础类都是这个包的一部分，如 LocalDate, LocalTime, LocalDateTime, Instant, Period, Duration等等。所有这些类都是不可变的和线程安全的，在绝大多数情况下，这些类能够有效地处理一些公共的需求。
java.time.chrono | 这个包为非ISO的日历系统定义了一些泛化的API，我们可以扩展AbstractChronology类来创建自己的日历系统。
java.time.format | 这个包包含能够格式化和解析日期时间对象的类，在绝大多数情况下，我们不应该直接使用它们，因为java.time包中相应的类已经提供了格式化和解析的方法。
java.time.temporal | 这个包包含一些时态对象，我们可以用其找出关于日期/时间对象的某个特定日期或时间，比如说，可以找到某月的第一天或最后一天。你可以非常容易地认出这些方法，因为它们都具有“withXXX”的格式。
java.time.zone | 这个包包含支持不同时区以及相关规则的类。

## 2 常用的几个类

类名 | 描述
--- | ---
Instant | 表示某一个时间点的时间戳，可以类比于java.uti.Date。支持各种运算操作
Duration | 表示Instant之间的时间差，可以用来统计任务的执行时间，也支持各种运算操作
LocalDate | 用于表示日期，与时区(TimeZone)无关。
Period | 用来表示两个LocalDate之间的时间差，支持各种运算操作
TemporalAdjusters | 用于表示某个月第一天、下个周一等日期
LocalTime | 表示时间，没有日期，与时区(TimeZone)无关
LocalDateTime | 表示日期和时间，适用于时区固定不变的场合(LocalDateTime使用系统默认的时区)，如果需要根据时区调整日期和时间，应该使用ZonedDateTime
ZonedDateTime | 表示带时区的日期和时间，支持的操作与LocalDateTime非常类似


### 2.1 java.time.LocalDate

> 在ISO-8601日历系统中没有时区的日期，如2007-12-03。

> LocalDate是一个不可变的日期时间对象，表示日期，通常被视为**年月日**。
也可以访问其他日期字段，例如日期，星期几和星期。
例如，“2007年10月2日”可以存储在LocalDate中。

> 该类不存储或表示时间或时区。相反，它是日期的描述，用于生日。它不能表示时间线上的瞬时，没有附加信息，如偏移或时区。

> ISO-8601日历系统是当今世界绝大多数的现代民用日历系统。它相当于如今的闰年规则一直适用于日常生活的公历日历系统。
对于当前写的大多数应用，ISO-8601规则是完全合适的。然而，任何利用历史日期并要求它们准确的应用程序都将发现ISO-8601方法不合适。

### 2.2 java.time.LocalTime

> LocalTime 和 LocalDate 具有比较相似的API接口。表示 ISO-8601日历系统中没有时区的时间，如10:15:30。

> LocalTime是一个不可变的日期时间对象，代表一个时间，通常被视为时分秒。
时间表示为纳秒精度。
例如，值“13：45.30.123456789”可以存储在LocalTime中。

> ISO-8601日历系统是当今世界绝大多数的现代民用日历系统。
该API假定所有日历系统在时间上使用相同的表示，这个类。

>该类不存储或表示日期或时区。相反，它是当地时间的描述，如在挂钟上看到的。
它不能表示时间线上的瞬时，没有附加信息，如偏移或时区。

### 2.3 java.time.LocalDateTime

> 提供包含日期和时间的API接口。LocalDateTime是一个不可变的日期-时间对象，它表示一组日期-时间，默认格式是yyyy-MM-dd-HH-mm-ss.zzz。
它提供了一个工厂方法，接收LocalDate和LocalTime输入参数，创建LocalDateTime实例。


### 2.4 java.time.ZonedDateTime

> ISO-8601日历系统中的日期时间，如2007-12-03T10：15：30 + 01：00欧洲/巴黎。

> ZonedDateTime是具有时区的日期时间的不可变表示。
此类存储所有日期和时间字段，精度为纳秒，时区为区域偏移量，用于处理模糊的本地日期时间。
例如，值“2007年10月2日在13：45.30.123456789 +欧洲/巴黎时区的+02：00”可以存储在ZonedDateTime中。

### 2.5 java.time.Clock

> 使用时区提供对当前即时，日期和时间的访问的时钟。

> 该类的实例用于查找当前时刻，可以使用存储的时区来解释当前时刻，以查找当前日期和时间。
因此，可以使用时钟代替System.currentTimeMillis()和TimeZone.getDefault()。

> 使用时钟是可选的。所有关键的日期时间类也有一个now()工厂方法，它使用默认时区中的系统时钟。
这种抽象的主要目的是允许在需要时插入备用时钟。
应用程序使用对象获取当前时间，而不是静态方法。这可以简化测试。

### 2.6 java.time.Instant

> Instant类是用在机器可读的时间格式上的，它以Unix时间戳的形式存储日期时间。
Instant表示某一个时间点的时间戳，可以类比于java.uti.Date。

## 3 常用的日期操作

### 3.1 日期计算

### 3.2 日期格式化

> java.time.format 包提供打印和解析日期和时间的类。



