function override() {
	//覆盖alert函数
	var alert = function(message) {
		window.alert("overriden:" + message);
	}
	alert('alert');
	//在override函数的作用域调用原始的alert()函数。
	window.alert("window.alert");
}

override();

//在window作用域中调用原始的alert()函数
window.alert("alert from outside");