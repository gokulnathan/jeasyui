<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>JS学习</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript">
	/* var iNum = "a";
	//alert(isFinite(iNum));
	if(isFinite(iNum)) {
		alert("this is a finit number");
	} else {
		alert("this is a infinit number");
	
	}
	 */

	/*  
	alert(isNaN("string"));//true
	 alert(isNaN(3));//false 表示这是一个数字
	 */

	/* 
	var iNum = parseInt("1234blue");//1234
	alert(iNum);
	iNum = parseInt("0xa");//10
	alert(iNum);
	iNum = parseInt("22.5");//22
	alert(iNum);
	iNum = parseInt("blue");//NaN
	alert(iNum);
	 */

	/*  
	var fNum = parseFloat("1234blue");//1234 非书中的1234.0
	alert(fNum);
	fNum = parseFloat("0xa");//0，非书上的NaN
	alert(fNum);
	fNum = parseFloat("22.5");//22
	alert(fNum);
	fNum = parseFloat("22.34.5");//NaN
	alert(fNum);
	fNum = parseFloat("0908");//22
	alert(fNum);
	fNum = parseFloat("blue");//NaN
	alert(fNum);
	 */
	/*   
	var oFalseObject = new Boolean(false);
	var oResult =  oFalseObject && true;
	alert(oResult);//true ，理论上在Boolean运算中，false && true 的值为false,但是在这行代码中，计算的是oFalseObject，而不是他的值false,由于在Boolean表达式中，所有对象自动转为true,所以这个结果为true
	 */
	/*  
	var oNumberObject = new Number(55);
	var iNum = oNumberObject.valueOf();
	alert(iNum);
	alert(oNumberObject.toFixed(2));//只有Number对象才有的方法,toFixed只能表示0到20位小数的数字
	 */
	/*  
	var oStringObject = new String("hello,world!");
	alert(oStringObject.charAt(1));//e
	alert(oStringObject.charCodeAt(1));//101
	 */

	var oStringObject = new String("hello,world");
	/* 
	oStringObject.concat("Jerry");
	alert(oStringObject);//hello,world!,hello!
	oStringObject = oStringObject.concat("Jerry");
	alert(oStringObject);//hello,world!,hello!Jerry
	 
	alert(oStringObject.indexOf("hello"));//0
	alert(oStringObject.lastIndexOf("hello"));//13
	 */
	//alert(oStringObject.localeCompare("fuck")); //1，不过具体返回值由实现决定，所以可能的判断为 > 0 或者为< 0，这样保证代码在各种实现中都能正确运行。
	/* 
	alert(oStringObject.slice(3, 7));
	alert(oStringObject.substring(3, 7));
	 */
	/* 
	alert(oStringObject.slice(-3));//当为负数时，slice方法为字符段的长度加上参数  rld slice(8)
	alert(oStringObject.slice(3,-4));//lo,w slice(3,7)
	
	alert(oStringObject.substring(-3));//当为负数时，substring方法忽略这个参数 //hello,world substring(0)
	alert(oStringObject.substring(3,-4));//hel substring(3,0),即substring(0,3)因为substring总是把小的作为起始位，较大的作为终止位
	 */

	/* alert(oStringObject instanceof String);//true */

	/* var o = new Object();
	
	o.name = "Jerry";
	
	alert(o.name);//jerry
	
	delete o.name;
	
	alert(o.name);//undefined
	 */

	/* var iOld = -64;
	
	alert(iOld >>> 5);//把无符号32位整体右移，值 为2 。如果是-64，则值为134217726
	 */
	/*  
	var bRe = "a" < 3;
	alert(bRe);//对a调用parseInt，无法转成数字，为NaN,根据规则，任何为NaN的关系运算符返回false
	 */

	/* 
	sColor = "red";

	var BLUE = "blue", RED = "red", YELLOW = "yellow";

	switch (sColor) {
	case BLUE:
		alert("blue");

		break;

	case RED:
		alert("red");

		break;

	case YELLOW:
		alert("yellow");

		break;

	default:
		break;
	}
	 */
	/* 根据传入的参数，进行判断
	function sayHi() {
		if (arguments[0] == "bye") {
			return;
		}
		alert(arguments[0]);
	}
	
	sayHi("bye3","Jerry");
	 */
	/* js 没有重载，doAdd的值被改成了指向了不同对象的指针，类似重载
	 doAdd = new Function("iNum","alert(iNum+100)");
	 doAdd = new Function("iNum","alert(iNum+10)");
	doAdd(10);
	 */

	/*  尽管可用Function构造函数创建函数，但是最好不要使用，因为用它定义函数比用传统方式慢的多，不过所有函数都应卸任是Function类的实例。
	 //如果函数名只是指向函数的变量，那么可以把函数作为参数传递给另外一个函数。
	 function callAnotherFunc(fnFunction,vArgument) {
	 	fnFunction(vArgument);
	 }
	 
	 doAdd = new Function("iNum","alert(iNum+10)");
	 
	 callAnotherFunc(doAdd, 10);
	 */
	/*  
	//因为函数是引用类型，所以它们也有属性和方法,函数最多接受25个参数。
	function doAdd(iNum) {
		alert(iNum + 10);
	}
	
	function sayHi() {
		alert("Hi");
	}
	
	alert(doAdd.length);//1
	alert(sayHi.length);//0
	alert(sayHi.constructor);//function Function(){native code}
	alert(sayHi.prototype.constructor);//显示方法整体内容
	 */

	/*
	ECMAScript最容易让人误解的是它支持闭包（closure）,所谓闭包，是指词法表示包括不必计算的变量的函数，也就是说
	，该函数全用函数外定义的变量,ECMAScript中使用全局变量是一个简单的闭包实例，如下。
	在这段代码中，脚本 被载入到内存后，并未为函数sayHelloWorld（）计算变量sMessage的值。该函数捕获sMessage的值只是为以后使用。
	也就是说，解释程序知道在调用该函数时要检查sMessage提值。sMessage将在函数调用sayHelloWorld（）时被赋值，显示出来。
	 */
	/* 
	var sMessage = "Hello World!";
	function sayHelloWorld() {
		alert(sMessage);
	}
	sayHelloWorld();
	 */

	/*下面这个函数addNumbers包括函数doAddition()（闭包），内部函数是个闭包，因为它将获取外部函数的参数iNum1 ,iNum2以及全局变量iBasenum的值。
	addNumbers()的最后一步调用了内部函数，把两个参数和全局变量相加，并返回他们的和。这里掌握的重要概念是:doAddition根据不接收参数，它使用的值是从执行
	环境中获取的。
	 */
	/*  
	 var iBasenum = 10;
	 function addNumbers(iNum1,iNum2) {
	 	function doAddition() {
	 		return iNum1 + iNum2 + iBasenum;
	 	}
	 	
	 	return doAddition();
	 }
	 */

	/**
		可以看到，闭包是ECMASript中非常强大多用的一部分，可以用于执行复杂的计算。就像使用任何高级函数一样，在使用闭包时要当心，因为它们可能会变得非常复杂。
	 **/

	/********************************************ECMAScript面向对象*************************************************/

	/*ECMA-262把对象(object)定义为“属性的无序集合，每个属性存放一个原始值，对象或函数”。严格来说，这意味着对象是无我写顺序的值 的数组。尽管如此定义对象，
	但它更通用的定义是基于代码的名词（人、地点或事物）表示。每个对象都由类定义，可以把类卸任对象的配方。类不仅要定义对象的接口（开发者访问的属性和方法），还要定义对象内部工作 ，
	（使属性和方法发挥作用的代码）。编译器和解释程序都根据类的说明构建对象。
	程序使用类创建对象时，生成的对象叫类的实例。对类生成的对象的个数的唯一限制是来处于运行代码的机器的我更内存。每个实例的行为相同 ，但实例处理一组独立的数据。
	由类创建对象实例的过程叫实例化（instantiation）.
	ECMAScript并没有正式的类，ECMA-262把对象定义描述为对象的配方，这也是ECMAScript的一种逻辑上的折中方案，因为对象定义实际上是对象自身。即使类并不真正存在，
	本书也把对象定义为类，因为开发者对此定义更熟悉，而且从功能上说，两者等价。对象定义放在一个函数-----构造函数中。他不是一种特殊函数，只不过是用于创建对象的常规函数。
	
	 */
	/**如果构造函数无参数，则括号不是必需的**/
	/* 
	var oObject = new Object();
	var oStringObject = new String();
	var oObject = new Object;
	var oStringObject = new String;
	 */

	/*
		ECMA-262把本地对象定义为“独立于宿主环境的ECMAScript实现提供的对象”，包括Object,Boolean,Error,SyntaxError,
		Function,Number,EvalError,TypeError,Array,Date,RangeError,URIError,String,RegExp,ReferenceError.
	 */
	/* 
	var aValues = new Array(20);//表示接收20个项,后续如果每增加一个数据组，数据的大小就动态地增长。
	aValues[0] = "red";
	aValues[1] = "green";
	aValues[2] = "blue";
	aValues[20] = "yellow";
	alert(aValues);
	alert(aValues.length);//数据动态增长。
	
	 */
	/* 
	var aValues = new Array("red","green","blue");//知道数据应该存放的值，可用参数声明这些值，创建大小与参数个数相等的Array对象
	alert(aValues);
	 */

	/*
	//使用字面量表示定义Array对象
	var aColors = ["red","green","blue"];
	alert(aColors.length);
	aColors[25] = "purple";
	alert(aColors.length);
	 */
	/* 
	//join的唯一用途就是连接字符串值，把自己转换成字符串
	var aColors = ["red","green","blue"];
	// alert(aColors.join(","));
	alert(aColors.slice(1));
	alert(aColors.slice(1,3));
	 */

	var stack = new Array;
	stack.push("red");
	stack.push("green");
	stack.push("blue");
	/* 
	alert(stack.toLocaleString());
	var viTem = stack.pop();//删除数据的最后一项
	alert(viTem);
	alert(stack);//
	 */

	/* var viTem = stack.shift();
	alert(stack);//green blue,shift()方法删除数据中的第一个项。unshift()把一个项放在数据的第一个位置，余下的项向下移动一个位置。
	 */

	/*  var d = new Date;
	 alert(d.getDate());
	 */
	 
	 //内置对象定义为“由ECMAScript实现提供的，独立于宿主环境的所有对象，在ECMAScript程序开始执行时出现”.这意味着开发者不必明确有实例化内置对象，它
	 //已经被实例化了。只有两个内置对象Global和Math
	 
	 /*
	 	这此URI方法encodeURI()、encodeURIComponent()、decodeURI()、decodeURIComponent()代替了BOM的escape()和unescape（）方法。URI
	 	方法更可取，因为他们会对所有的Unicode符号编码，而BOM方法只能对ASCII符号正确编码。尽量避免使用escape()和unescape（）；
	 ***/
	 
	 
	 
</script>
</head>

<body>
	This is my JSP page.
	<br>
</body>
</html>
