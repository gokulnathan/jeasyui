(function() {
	// ADS命名空间
	if (!window.ADS) {
		window['ADS'] = {};
	}
	// 用来检测当前浏览器是否与整个库兼容
	function isCompatible(other) {
		if (other === false || !Array.prototype.push || !Object.hasOwnProperty
				|| !document.createElement || !document.getElementsByTagName) {
			return false;
		}
		return true;
	}
	;
	window['ADS']['isCompatible'] = isCompatible;

	function $() {
		var elements = new Array;
		
		//查找作为参数的所有元素
		for ( var int = 0; int < arguments.length; int++) {
			
			var element = arguments[i];
			
			if(typeof element = "string") {
				
				element = document.getElementById(element);
				
			}
			//如果只提供一个参数，则立即返回这个元素
			if(arguments.length == 1) {
				
				return element;
				
			}
			
			//否则，将它添加到数组中
			elements.push(element);
			
		}
		
		return elements;

	}
	window['ADS']['$'] = $;

	function addEvent(node, type, listener) {

	}
	;
	window['ADS']['addEvent'] = addEvent;

	function removeEvent(node, type, listener) {

	}
	;
	window['ADS']['removeEvent'] = removeEvent;

	function getElementsByClassName(className, tag, parent) {

	}
	;
	window['ADS']['getElementsByClassName'] = getElementsByClassName;

	function toggleDisplay(node, value) {

	}
	;
	window['ADS']['toggleDisplay'] = toggleDisplay;

	function insertAfter(node, referenceNode) {

	}
	window['ADS']['insertAfter'] = insertAfter;

	function removeChildren(parent) {

	}
	;
	window['ADS']['removeChildren'] = removeChildren;

	function prependChild(parent, newChild) {

	}
	;
	window['ADS']['prependChild'] = prependChild;
	
	function exampleLibraryMethod(obj) {
		if(!(obj = $(obj))) {
			return false;
		}
	}
	
	window['ADS']['exampleLibraryMethod'] = exampleLibraryMethod;
	

})();