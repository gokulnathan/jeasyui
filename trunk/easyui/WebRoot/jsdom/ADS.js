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

		// 查找作为参数的所有元素
		for ( var int = 0; int < arguments.length; int++) {

			var element = arguments[i];

			if (typeof element == "string") {

				element = document.getElementById(element);

			}
			// 如果只提供一个参数，则立即返回这个元素
			if (arguments.length == 1) {

				return element;

			}

			// 否则，将它添加到数组中
			elements.push(element);

		}

		return elements;

	}
	window['ADS']['$'] = $;

	function addEvent(node, type, listener) {

		if (!isCompatible()) {
			return false;
		}
		if (!(node = $(node))) {
			return false;
		}
		if (node.addEventListener) {
			// w3c方法
			node.addEventListener(type, listener, false);

			return true;

		} else if (node.attachEvent) {
			// MISE方法
			node['e' + type + listener] = listener;
			note[type + listener] = function() {
				node['e' + type + listener](window.event);
			};
			node.atachEvent('on' + type, node[type + listener]);
			return true;
		}
		// 两种方法都不具备，返回false
		return false;

	}
	;
	window['ADS']['addEvent'] = addEvent;

	// 移除事件
	function removeEvent(node, type, listener) {
		if (!(node = $(node))) {
			return false;
		}
		if (node.removeEventListener) {
			// w3c
			node.removeEventListener(type, listener, false);
			return true;
		} else if (node.detachEvent) {
			// msie
			node.detachEvent("on" + type, node[type + listener]);
			node[type + listener] = null;
			return true;
		}
		return false;

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
		if (!(obj = $(obj))) {
			return false;
		}
	}

	window['ADS']['exampleLibraryMethod'] = exampleLibraryMethod;

	//根据className获得对应的数组
	function getElementsByClassName(className, tag, parent) {
		parent = parent || document;
		if (!(parent = $(parent))) {
			return false;
		}

		// 查找所有匹配的标签
		var allTags = (tag == "*" && parent.all) ? parent.all : parent
				.getElementsByTagName(tag);
		alert(allTags);
		var matchingElements = new Array;

		// 创建一个正则表达式，来判断className是否正确
		className = className.replace(/\-/g, "\\-");
		var regex = new RegExp("(^|\\s)" + className + "(\\s|$)");
		var element;
		// 检查每一个标签元素，如果符合，放入数组。
		for ( var int = 0; int < allTags.length; int++) {
			element = allTags[i];
			if (regex.test(element.className)) {
				matchingElements.push(element);
			}
		}

		return matchingElements;

	}
	
	window['ADS']['getElementsByClassName'] = getElementsByClassName;
	
	function toggleDisplay(node ,value) {
		if(!(node = $(node))) {
			return false;
		}
		if(node.style.display != "none") {
			node.style.display = "none";
		} else {
			node.style.display = value || "";
		}
		return true;
	}
	window["ADS"]["toggleDisplay"] = toggleDisplay; 
	
})();