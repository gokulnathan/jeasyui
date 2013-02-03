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
	/* 
	function showColor() {
		alert(this.color);
	}
	
	var oCar = new Object;
	oCar.color = "red";
	oCar.showColor = showColor;
	
	var oCar1 = new Object;
	oCar1.color = "blue";
	oCar1.showColor = showColor;
	
	oCar.showColor();
	oCar1.showColor();
	 */
	/* 
	 function showColor() {
	 alert(this.color);
	 }
	
	 function createCar(color) {
	 var oCar = new Object;
	 oCar.color = color;
	 oCar.showColor = showColor;
	 return oCar;//任何没有返回值的函数，默认返回undefined
	 }
	
	 var oCar1 = createCar("red");
	 var oCar2 = createCar("blue");
	
	 oCar1.showColor();
	 oCar2.showColor();
	 */

	/**构造函数:会重复生成函数，为每个对象都创建独立的函数版本，也可以
	用外部函数重写构造函数。同样的，语义上无任何意义，这就是原型方式的优势所在。
	全用new运算符调用构造函数时，在执行第一行代码前先创建一个对象
	只有this才能访问该对象。然后可以直接赋予this属性，默认情况下
	是构造函数的返回值。
	 **/
	/*  
	function Car(color) {
		this.color = color;
		this.showColor = function() {
			alert(this.color);
		};
		//这里不必明确返回
	}

	var oCar1 = new Car("red");
	oCar1.showColor();
	 */

	///////////////////原型方式/////////////////////////////////////
	/*原型方式利用了对象的prototype属性，可把它看成新对象所依赖的原型。
	调用new Car()时，原型的所有属性都被立刻赋予要创建的对象，意味着所有的Car实例存放的
	都是指向showColor()函数的指针。从主义上讲，所有属性看起来都属于一个对象。
	因此解决了前面两种方式的两个问题。使用此方法，还能用instanceof检查给定变量指向的对象的类型。
	对象创建后才能改变属性的默认值，但是不是最坏的，真正的问题出现在属性指向的是对象，而
	不是函数时，函数共享不会造成问题，但是对象却很少被多个实例共享的。
	下例中，由于drivers是引用值，Car的两个实例都指向同一个数组。这意味着car1.drivers
	添加的值，在car2.drivers中也可以看到。是否有合理的创建对象的方式呢?
	答案是联合使用构造函数和原型的方式。
	
	 */
	/* 
	function Car() {
	}
	Car.prototype.color = "red";
	Car.prototype.doors = 4;
	Car.prototype.mpg = 23;
	Car.prototype.drivers = new Array("Mike","Jerry");
	Car.prototype.showColor = function() {
	alert(this.color);
	};
	
	var oCar1 = new Car();
	oCar1.drivers.push("Tom");
	oCar1.color = "blue";
	var oCar2 = new Car();
	alert(oCar1.drivers);
	alert(oCar2.drivers);
	alert(oCar2.color);
	 */

	//////////////////联合使用构造函数和原型的方式///////////////////////////
	/**
		要住很简单，用构造 函数定义对象的所有非函数属性，用原型的方式定义对象的函数属性（方法）。结果
		所有的函数都只创建一次，而每个对象都有自己的对象属性实例。
	 **/
	/* 
	function Car(color) {
	this.color = color;
	this.drivers = new Array("Mike","Jerry");
	}
	
	Car.prototype.showColor = function() {
	alert(this.color);
	};
	
	var oCar1 = new Car("red");
	var oCar2 = new Car("blue");
	
	oCar1.drivers.push("Tom");
	alert(oCar1.drivers);
	alert(oCar2.drivers);
	 */

	//对象冒充实现继承
	/**
		在这段代码中，为ClassA赋予了方法newMethod（函数名只是指向它的指针）。然后调用该方法
		，传递给它的是ClassB构造函数的参数sColor。最后一行删除了对ClassA的引用，这样以后就不能
		再 调用它。
	 **/

	/* 
	function ClassA(sColor) {
	this.sColor = sColor;
	this.sayHi = function() {
		alert(this.sColor);
	};
	}

	function ClassB(sColor) {
	this.newMethod = ClassA;
	this.newMethod(sColor);
	delete this.newMethod;
	}
	 */
	//call() and apply()用来实现对象冒充继承方式的
	//call()第一个参数的作用是用作this的对象。其他参数都直接传递给函数本身。
	//使用继承和对象冒充修改以上方法
	//这里，想让ClassA中的关键字this等于新创建的ClassB对象，因此this是第一个参数。第二个
	//参数是实际传入的参数。
	/*
	 *只有超类中的参数顺序与子类中的参数顺序完全一致时才可以传递参数对象，如果不是，则创建一个单独数组
	，按照正确的顺序旋转参数，此外还可以使用call（）方法。
	 */
	/* 
	function ClassB(sColor) {
		ClassA.call(this,sColor);
	}
	
	function ClassB(sColor) {
		//ClassA.apply(this,new Array(sColor));
		ClassA.apply(this, arguments);
	}
	 */

	//原型链
	/****prototype对象是个模板，要实例化的对象都以这个模板为基础。prototype对象的任何属性和方法
	都被传递给那个类的所有实例，利用这种功能来实现继承机制.
	
	调用ClassA的构造函数时，没有给它传递参数，这是原型链中的标准做法。要确保构造函数中没有任何参数。
	 */
/* 
	function ClassA() {
	}
	ClassA.prototype.color = "red";
	ClassA.prototype.sayColor = function() {
		alert(this.color);
	};

	function ClassB() {

	}

	ClassB.prototype = new ClassA();

	var objA = new ClassA();
	objA.color = "red";
	objA.sayColor();
	var objB = new ClassB();
	objB.color = "blue";
	objB.sayColor();
	alert(objB instanceof ClassB);//true
	alert(objB instanceof ClassA);//true,对象冒充时不能使用instaceof这个方法判断
 */
	/**
		原型链的弊端不支持多重继承。原型链会用另一类型的对象重写类的prototype属性。
	 **/

	/*
	用对象冒充继承构造函数的属性，用原型链继承prototpye对象的方法。
	 ***/
	 
	function ClassA(sColor) {
		 this.color = sColor;
	}
	ClassA.prototype.sayColor = function() {
		alert(this.color);
	};
	
	function ClassB(sColor,sName) {
		ClassA.call(this, sColor);//对象冒充构造函数的属性
		this.name = sName;
	}
	ClassB.prototype = new ClassA();//用原型链继承方法
	ClassB.prototype.sayName = function() {//此方法要放在上一句之后，否则会被重置，不起作用。
		alert(this.name);
	};
	
	var objA = new ClassA();
	objA.color = "red";
	objA.sayColor();
	var objB = new ClassB();
	objB.color = "blue";
	objB.sayColor();
	alert(objB instanceof ClassB);//true
	alert(objB instanceof ClassA);//true,对象冒充时不能使用instaceof这个方法判断
	
	 
</script>
</head>

<body>
	This is my JSP page.
	<br>
</body>
</html>
