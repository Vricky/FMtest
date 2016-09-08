<#assign x = date>
<#assign seq = ["winter", "spring", "summer", "autumn"]>
<html>
<head>  
    <title>${title}</title>  
</head>  
<body>  
	${timer("yyyy-MM-dd H:mm:ss", x)}
	${timer("yyyy-MM-dd ", x)} 
	
	<@upcase>${title}</@upcase> 
	${title?upper_case?html}
	${x?number}
	<#if mouse?exists>exists<#else>not exist</#if> 
	
	<#macro test foo bar="Bar" baaz=-1>
	  Test text, and the params: ${foo}, ${bar}, ${baaz}
	</#macro>
	<@test foo="a" bar="b" baaz=5*5-2/>
	<@test foo="a" bar="b"/>
	<@test foo="a" baaz=5*5-2/>
	<@test foo="a"/> 
	
	<#list sequence as item>
		<#if item = "spring">春天
		<#else>${item}
		</#if>
	</#list> 
	
	<#list seq as x>
	  ${x_index + 1}. ${x}<#if x_has_next>,</#if>
	</#list>
	
	${book.author.name}    //全部使用点语法
	${book["author"].name}
	${book.author["name"]}   //混合使用点语法和方括号语法
	${book["author"]["name"]}   //全部使用方括号语法
	
	<#list animals as being>
		${being.name} , ${being.size} , ${being.height} 
		<#switch being.size>
		<#case "small">
	     This will be processed if it is small
	     <#break>
		<#case "medium">
	     This will be processed if it is medium
	     <#break>
		<#case "large">
	     This will be processed if it is large
	     <#break>
		<#default>
	     This will be processed if it is neither
		</#switch>
	</#list>
	<#assign xx = 1>
	<#switch xx>
	  <#case 1>
	    1<#break>
	  <#case 2>
	    2<#break>
	  <#default>
	    d<#break>
	</#switch>
	
	<#assign scores = m1+ m2> 
	语文成绩是${scores.语文}
	数学成绩是${scores.数学}
	英语成绩是${scores.英语} 
	
	
	<#import "common.ftl" as com>
	<#assign bgColor="red" in com> 
	<@com.page title="book list">
	<u1>
	<li>spring</li>
	<li>${com.bgColor}</li>
	</ul>
	</@com.page> 
</body>  
</html>