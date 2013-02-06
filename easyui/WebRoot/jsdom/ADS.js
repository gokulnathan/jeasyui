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

	//在某个节点之后插入
	function insertAfter(node, referenceNode) {
		if(!(node = $(node))) {
			return false;
		}
		if(!(referenceNode = $(referenceNode))) {
			return false;
		}
		return referenceNode.parentNode.insertBefore(node,referenceNode.nextSibling);
	}
	window['ADS']['insertAfter'] = insertAfter;

	//移除子节点
	function removeChildren(parent) {
		if(!(parent = $(parent))) {
			return false;
		}
		//当存在该节点时，删除该子节点
		while(parent.firstChild) {
			parent.firstChild.parentNode.removeChild(parent.firstChild);
		}
		//返回父元素，以便实现方法连缀
		return parent;
	}
	;
	window['ADS']['removeChildren'] = removeChildren;

	//添加节点
	function prependChild(parent, newChild) {
		if(!(parent = $(parent))) {
			return false;
		}
		if(!(newChild = $(newChild))) {
			return false;
		}
		
		if(parent.firstChild) {
			//如果存在一个子节点，则在此子节点之前插入
			parent.insertBefore(newChild,parent.firstChild);
		} else {
			//如果没有子节点，直接添加
			parent.appendChild(newChild);
		}
		//再返回父元素，以便实现方法连缀
		return parent;
	};
	
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
	
	//隐藏或显示效果
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
	
	//函数绑定，修改环境
	function bindFunction(obj, func) {
		return function() {
			func.apply(obj, arguments);
		};
	}
	window['ADS']['bindFunction'] = bindFunction;
	
	//获得浏览器窗口尺寸
	function getBrowserWindowSize() {
		var de = document.documentElement;
		return {
			"width" : (window.innerWidth || (de && de.clientWidth) || document.body.clientWidth),
			"height" : (window.innerHeight || (de && de.clientHeight) || document.body.clientHeight)
			
		};
	};
	window['ADS']['getBrowserWindowSize'] = getBrowserWindowSize;
	
	//下面这个myLogger当作一个构造函数
	function myLogger(id) {
		
		id = id ||'ADSLogWindow';
		//私有属性
		var logWindow = null;
		//私有方法
		var createWindow = function () {
			//取得新窗口在浏览器中居中放置时的左上角位置
			var  browserWindowSize = ADS.getBrowserWindowSize();
			var top = ((browserWindowSize.height - 200)/2) || 0;
			var left = ((browserWindowSize.width - 200)/2) || 0;
			
			//创建作为日志窗口的DOM节点
			//使用受保护的logWindow属性维护引用
			logWindow = document.createElement("UL");
			//指定ID值， 以便必要时在DOM树中能够识别
			logWindow.setAttribute("id",id);
			
			//在屏幕居中定位日志窗口
			logWindow.style.position = 'absolute';
			logWindow.style.top = top + "px";
			logWindow.style.left = left + "px";
			
			//设置固定的大小并允许窗口内容滚动
			logWindow.style.width = "200px";
			logWindow.style.height = "200px";
			logWindow.style.overflow = "scroll";
			
			//添加一些样式以美化外观
			logWindow.style.padding = "0";
			logWindow.style.margin = "0";
			logWindow.style.border = "1px solid black";
			logWindow.style.backgroundColor = "white";
			logWindow.style.listStyle = "none";
			logWindow.style.font = "10px/10px Verdana, Tahoma, Sans";
			
			//将其添加到文档主体中
			document.body.appendChild(logWindow);
			
			
		};
		
		//特权方法，公有方法
		this.writeRaw = function(message) {
			//如果初始窗口不存在，则创建
			if(!logWindow) {
				
				createWindow();
				
			}
			
			//创建列表项并适当地添加样式
			var li = document.createElement("LI");
			li.style.padding = "2px";
			li.style.border = "0";
			li.style.borderBottom = "1px dotted black";
			li.style.margin = "0";
			li.style.color = "#000";
			li.style.font = "9px/9px Verdana, Tahoma, Sans";
			//为日志节点添加 信息
			if(typeof message == "undefined") {
				li.appendChild(document.createTextNode("Message was undefined"));
			} else if (typeof li.innerHTML != undefined) {
				li.innerHTML = message;
			} else {
				li.appendChild(document.createTextNode(message));
			}
			
			//将这个条目添加到日志窗口
			logWindow.appendChild(li);
			
			return true;
		};
		
	}
	
	//公有方法。
	myLogger.prototype = {
			write:function(message){
				//警告message 为空值
				if(typeof message =="string" && message.length == 0 ) {
					return this.writeRaw("ADS.log: null message");
				}
				
				//如果message不是字符串，尝试调用toString（）方法,如果不存在，则记录对象类型
				if(typeof message != "string") {
					if(message.toString) {
						return this.writeRaw(message.toString());
					} else {
						return this.writeRaw(typeof message);
					}
				}
				
				//转换< and >，以便.innerHTML不会将message作为HTML进行解析
				message = message.replace(/</g,"&lt;").replace(/>/g,"&gt;");
				return this.writeRaw(message);
			},
			
			//向日志窗口写入一个标量
			header:function(message) {
				message = '<span style="color:white;background-color:black;font-weigh:bold;padding:0px 5px;">'
					+ message + '</span>';
				return this.writeRaw(message);
			}
	};
	
	if(!window.ADS) {
		window['ADS'] = {};
	}
	
	window['ADS']['log'] = new myLogger();//当作构造函数调用，生成对应实例。
	
})();