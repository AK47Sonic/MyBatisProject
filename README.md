# hello
```
fdefd  
dsds  
dsds  
``` 

#{}:更丰富的用法：
	规定参数的一些规则：
	javaType、jdbcType、mode（存储过程）、numericScale、
	resultMap、typeHandler、jdbcTypeName、expression（未来准备支持的功能）

	jdbcType通常需要在某种特定的条件下被设置：
		在我们数据为null时，有些数据库是不能识别mybatis对null的默认处理 （null -> other）
		比如Oracle（报错）：
		JdbcType OTHER: 无效的类型，因为mybatis对所有的null都映射的是原生Jdbc的OTHER类型，Oracle不能正确处理。
		
		所以由于mybatis全局配置中，jdbcTypeForNull=OTHER,有些数据库不支持；
		1. #{id, jdbcType=OTHER};
		2. jdbcTypeForNull=NULL
		<setting name="jdbcTypeForNull" value="NULL"/>
		
如果mybatis的返回结果是一个集合，那么mybatis会把返回的对象自动封装成List集合
